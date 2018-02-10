import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 消息转换：
 * 用户名=-=消息    ->   用户名=-=ALL=-=消息
 * 用户名=-=命令    ->   用户名=-=ALL=-=命令
 * 消息            ->   用户名=-=ALL=-=消息
 * 通讯协议：
 * 用户名=-=ALL=-=消息               发送给除自己以外所有人消息
 * 用户名=-=ALL=-=命令
 * 用户名=-=Address=-=消息           发送给指定Address客户端
 * 用户名=-=Addiess-Address=-=消息   发送给多个指定Address客户端
 */
public class Server {
    List<ServerThread> clients = new ArrayList<ServerThread>();
    
    public static void main(String[] args) {
        new Server();
    }
    
    public Server() {
        try {
            String address = InetAddress.getLocalHost().getHostAddress();
            System.out.println("服务器IP：" + address);
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("启动成功");
            while (true) {
                Socket socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                clients.add(serverThread);
                System.out.println("连接人数： " + clients.size());
                
            }
        } catch (UnknownHostException e) {
            System.out.println("+++++++++++1++++++++++++");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("+++++++++++2++++++++++++");
            System.out.println("启动失败");
            e.printStackTrace();
        }
    }
    
    
    class ServerThread extends Thread {
        private Socket socket;
        private PrintWriter writer = null;
        private BufferedReader reader = null;
        private boolean close = false;
        
        public ServerThread(Socket socket) {
            this.socket = socket;
            try {
                writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(socket.getRemoteSocketAddress() + " 已连接");
            } catch (IOException e) {
                System.out.println("+++++++++++3++++++++++++");
                System.out.println("客户端连接失败");
                e.printStackTrace();
            }
        }
    
        public void run() {
            while (true) {
                InPut();
                if (close)
                    break;
            }
        }
    
        public void InPut() {
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String string = reader.readLine();
                String[] ss1 = string.split("=-=",3);
                ss1=Regulation(ss1);
                System.out.println("-|从 " + ss1[0] + " (" + socket.getRemoteSocketAddress() + ") 发来消息 ：" + ss1[2]);
                Agreement(ss1);
                System.out.println("—————————————————————————————————————————");
            } catch (IOException e) {
                System.out.println("+++++++++++4++++++++++++");
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("+++++++++++5++++++++++++");
                Close();
            }
        }
        public String[] Regulation(String[] s) {
            String[] ss = new String[3];
            if (s.length==1){
                ss[0] = "其他客户端";
                ss[1] = "ALL";
                ss[2] = s[0];
            }else if (s.length == 2) {
                ss[0] = s[0];
                ss[1] = "ALL";
                ss[2] = s[1];
            } else if (s.length == 3) {
                ss[0] = s[0];
                ss[1] = s[1];
                ss[2] = s[2];
            }
            return ss;
        }
        public void Agreement(String[] s) {
            if ("ALL".equals(s[1])){
                if (!("==name==".equals(s[2])||"==user==".equals(s[2]))){
                    SendALL(s);
                }
            }else {
                SendAppoint(s);
            }
            SendBack(s);
        }
        public void SendBack(String[] s){//发送给发送的客户端
            for (int i = 0; i < clients.size(); i++) {//发回给发送消息的客户端
                if (socket == clients.get(i).socket) {
                    ServerThread thread = clients.get(i);
                    if ("==name==".equals(s[2])) {
                        thread.OutPut("改名成功");
                    } else if ("==user==".equals(s[2])){
                        thread.OutPut("目前在线人数除去自己："+(clients.size()-1)+"人");
                        
                        for (int j = 0; j < clients.size(); j++) {//查找除发送消息的客户端其他客户端
                            int otherUser=0;
                            System.out.println(otherUser+"--------");
                            System.out.println(socket+"---"+clients.get(j).socket);
                            if (socket != clients.get(j).socket) {
                                System.out.println(j+"---");
                                otherUser++;
                                thread.OutPut(otherUser+". "+clients.get(j).socket.getRemoteSocketAddress());
                            }
                        }
                    }else
                        thread.OutPut("发送： " + s[2]);
                }
            }
        }
        public void SendALL(String[] string) {//发送给除去发送消息的客户端
            System.out.println("--------群发--------发送人数： " + (clients.size() - 1));
            for (int i = 0; i < clients.size(); i++) {
                if (socket != clients.get(i).socket) {
                    System.out.println("    -|给 " + clients.get(i).socket.getRemoteSocketAddress() + " 发送消息： " + string[2]);
                    ServerThread thread = clients.get(i);
                    thread.OutPut(string[0] + "(" + clients.get(i).socket.getRemoteSocketAddress() + ") :" + string[2]);
                }
            }
        }
        public void SendAllOrder(String string){//发送给所有客户端
            String[] order = string.split("==------>==<-------==");
            if (order.length==2){
                if ("EXIT".equals(order[0])){
                    for (int i = 0; i < clients.size(); i++) {
                        ServerThread thread = clients.get(i);
                        thread.OutPut(order[1] + "已退出，剩余人数： "+clients.size());
                    }
                }
            }
        }
    
        public void SendAppoint(String[] string) {//发送给指定Address客户端
            boolean b=true;
            System.out.println("--------指定发--------");
            String[] s1 = string[1].split("-");
            System.out.println("发送给" + s1.length + "个人");
            System.out.println("Address :");
            for (int j = 0; j < s1.length; j++) {
                s1[j]="/"+s1[j];
                b=true;
                System.out.println("-|" + j + ". " + s1[j]);
                for (int i = 0; i < clients.size(); i++) {
                    System.out.println("    -|" + i + ". " + clients.get(i).socket.getRemoteSocketAddress().toString());
                    if ((s1[j]).equals(clients.get(i).socket.getRemoteSocketAddress().toString())) {
                        b = false;
                        System.out.println("        -|给 " + clients.get(i).socket.getRemoteSocketAddress() + " 发送消息： "+ string[2]);
                        ServerThread thread = clients.get(i);
                        thread.OutPut(string[0] + "(" + clients.get(i).socket.getRemoteSocketAddress() + ") :" + string[2]);
                    }
                }
                if (b) {
                    System.out.println("    -|失败----");
                    for (int k = 0; k < clients.size(); k++) {
                        if (socket == clients.get(k).socket) {
                            ServerThread thread = clients.get(k);
                            thread.OutPut("发送给(" + s1[j] + ")发送失败");
                        }
                    }
                }
            }

        }
    
        public void OutPut(String string) {
            try {
                writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
//            String str = scanner.next();
    
                writer.println(string);
                writer.flush();
                if (string.equals("exit")) {
                    Close();
                }
            } catch (IOException e) {
                System.out.println("+++++++++++6++++++++++++");
                e.printStackTrace();
            }
        }
    
    
        public void Close() {
            try {
                socket.close();
                writer.close();
                reader.close();
                for (int i = 0; i < clients.size(); i++) {
                    if (clients.get(i).socket == socket) {
                        clients.remove(i);
                        break;
                    }
                }
                System.out.println("Address：" + socket.getRemoteSocketAddress() + " 已退出");
                System.out.println("连接人数： " + clients.size());
                SendAllOrder("EXIT==------>==<-------=="+socket.getRemoteSocketAddress());
            } catch (IOException e) {
                System.out.println("+++++++++++7++++++++++++");
                e.printStackTrace();
                System.out.println("关闭失败");
            }
            close = true;
        }
    }
}


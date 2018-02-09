import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {
    List<ServerThread> clients = new ArrayList<ServerThread>();
    
    public static void main(String[] args) {
        new Server();
    }
    
    public Server() {
        try {
            String addr = InetAddress.getLocalHost().getHostAddress();//获得本机IP
            System.out.println("服务器IP：" + addr);
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
//            System.out.println(socket);
//            System.out.println(socket.getRemoteSocketAddress());
//                System.out.println("addr：" + socket.getInetAddress() + " ；port: " + socket.getPort() + " 已连接");
                System.out.println(socket.getRemoteSocketAddress() + " 已连接");
            } catch (IOException e) {
                System.out.println("+++++++++++3++++++++++++");
                System.out.println("客户端连接失败");
                e.printStackTrace();
            }
        }
    
        public PrintWriter getWriter() {
            return writer;
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
                System.out.println("-|从 " + socket.getRemoteSocketAddress() + " 发来消息 ：" + string);
//                OutPut(string);
                String[] ss1 = string.split("\\|-=-=-=-\\|");
                System.out.println("昵称： " + ss1[0]);
                System.out.println("发送给： " + ss1[1]);
                System.out.println("发送消息： " + ss1[2]);
    
                if ("ALL".equals(ss1[1])) {
                    SendALL(ss1);
                } else
                    SendAppoint(ss1);
                System.out.println("—————————————————————————————————————————");
            } catch (IOException e) {
                System.out.println("+++++++++++4++++++++++++");
                e.printStackTrace();
            } catch (NullPointerException e) {
                System.out.println("+++++++++++5++++++++++++");
                Close();
            }
        }
    
        public void SendALL(String[] string) {
            System.out.println("--------群发--------发送人数： "+(clients.size()-1));
            for (int i = 0; i < clients.size(); i++) {
                if (socket != clients.get(i).socket) {
                    System.out.println("    -|给 " + clients.get(i).socket.getRemoteSocketAddress() + " 发送消息： " + string[0] + "||=-=-=-=||" + string[2]);
                    ServerThread thread = clients.get(i);
                    thread.OutPut(string[0] + "(" + clients.get(i).socket.getRemoteSocketAddress() + ") :" + string[2]);
                }
            }
        }
    
        public void SendAppoint(String[] string) {
            boolean b = true;
            System.out.println("--------指定发--------");
            String[] s1 = string[1].split("<-=-=-=->");
            System.out.println("发送给" + s1.length + "个人");
            System.out.println("Address :");
            for (int i = 0; i < s1.length; i++) {
                System.out.println(i + ". " + s1[i]);
            }
            for (int i = 0; i < clients.size(); i++) {
                System.out.println("-|" + i + ". " + clients.get(i).socket.getRemoteSocketAddress().toString());
                for (int j = 0; j < s1.length; j++) {
                    System.out.println("    -|" + j + ". " + s1[j]);
                    if (s1[j].equals(clients.get(i).socket.getRemoteSocketAddress().toString())) {
                        b = false;
                        System.out.println("    -|给 " + clients.get(i).socket.getRemoteSocketAddress() + " 发送消息： " + string[0] + "||=-=-=-=||" + string[2]);
                        ServerThread thread = clients.get(i);
                        thread.OutPut(string[0] + "(" + clients.get(i).socket.getRemoteSocketAddress() + ") :" + string[2]);
                    }
                }
            }
            if (b) {
                System.out.println("失败");
                for (int i = 0; i < clients.size(); i++) {
                    if (socket == clients.get(i).socket) {
                        ServerThread thread = clients.get(i);
                        thread.OutPut("发送给(" + clients.get(i).socket.getRemoteSocketAddress() + ")发送失败");
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
                System.out.println("addr：" + socket.getInetAddress() + " ；port: " + socket.getPort() + " 已退出");
                System.out.println("连接人数： " + clients.size());
            } catch (IOException e) {
                System.out.println("+++++++++++7++++++++++++");
                e.printStackTrace();
                System.out.println("关闭失败");
            }
            close = true;
        }
    }
}

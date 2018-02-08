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
                ServerThread serverThread=new ServerThread(socket);
                serverThread.start();
                clients.add(serverThread);
                System.out.println("连接人数： "+clients.size());
                
//                clients.add(serverThread);
//                System.out.println(clients.size());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
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
                System.out.println("addr：" + socket.getInetAddress() + " ；port: " + socket.getPort() + " 已连接");
            } catch (IOException e) {
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
                System.out.println(socket.getRemoteSocketAddress() + " 发来 ：" + string);
                OutPut(string);
                for (int i = 0; i < clients.size(); i++) {
                    ServerThread thread=clients.get(i);
                    thread.OutPut(string);
                }
            } catch (IOException e) {
                e.printStackTrace();
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
                e.printStackTrace();
            }
        }


        public void Close() {
            try {
//            serverSocket.close();
                socket.close();
                writer.close();
                reader.close();
                System.out.println("addr：" + socket.getInetAddress() + " ；port: " + socket.getPort() + " 已退出");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("关闭失败");
            }
            close = true;
        }
    }

//    class ServerThread extends Thread {
//        private ServerSocket serverSocket;
//        public ServerThread(ServerSocket serverSocket){
//            this.serverSocket=serverSocket;
//        }
//        public void run() {
//            while (true){
//                try {
//                    Socket socket = serverSocket.accept();
//                    IO client = new IO(socket);
//                    client.start();// 开启对此客户端服务的线程
//                    clients.add(client);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }


    
//    public class IO extends Thread{
//        private Socket socket;
//        private PrintWriter writer = null;
//        private BufferedReader reader = null;
//        private boolean close = false;
//
//        public PrintWriter getWriter() {
//            return writer;
//        }
//
//        public IO(Socket socket){
//            try {
//                this.socket=socket;
//                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        public void run() {
//            Start();
//        }
//        public void InPut() {
//            try {
//                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                String string = reader.readLine();
//                System.out.println(socket.getRemoteSocketAddress() + " 发来 ：" + string);
//                OutPut(string);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        public void OutPut(String string) {
//            try {
//                writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
////            String str = scanner.next();
//
//                writer.println(string);
//                writer.flush();
//                if (string.equals("exit")) {
//                    Close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//        public void Start() {
//            try {
//                writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
//                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
////            System.out.println(socket);
////            System.out.println(socket.getRemoteSocketAddress());
//                System.out.println("addr：" + socket.getInetAddress() + " ；port: " + socket.getPort() + " 已连接");
//
//            } catch (IOException e) {
//                System.out.println("客户端连接失败");
//                e.printStackTrace();
//            }
//
//        }
//
//        public void Close() {
//            try {
////            serverSocket.close();
//                socket.close();
//                writer.close();
//                reader.close();
//                System.out.println("addr：" + socket.getInetAddress() + " ；port: " + socket.getPort() + " 已退出");
//            } catch (IOException e) {
//                e.printStackTrace();
//                System.out.println("关闭失败");
//            }
//            close = true;
//        }
//    }
}


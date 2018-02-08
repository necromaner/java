package qw;

import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    List<ClientThread> clients = new ArrayList<ClientThread>();
    public static void main(String[] args) {
        new ChatServer();
    }
    public ChatServer(){
        try {
            ServerSocket serversocket = new ServerSocket(5000);
            while(true){
                System.out.println("端口绑定");
                Socket socket = serversocket.accept();
                System.out.println("有外部客户端接入");
                ClientThread currentClient = new ClientThread(socket);
                clients.add(currentClient);
                currentClient.start();
                System.out.println("客户端线程开始");
            }
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    class ClientThread extends Thread{
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;
        private String line;
        
        
        public ClientThread(Socket socket){
            this.socket = socket;
        }
        
        
        @Override
        public void run() {
            System.out.println("run方法启动了！");
            try {
                while(true){
                    reader = new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));
                    line = reader.readLine();
                    System.out.println("接收到消息");
                    for(int i=0; i<clients.size(); i++){
                        
                        ClientThread c = clients.get(i);
                        c.send(line);
                    }
                }
            } catch (IOException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            
        }
        public void send(String line){
            try {
                writer = new PrintWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream()));
                writer.println(line);
                writer.flush();
                System.out.println("正在向客户端写消息成功！");
                
                
            } catch (IOException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            
        }
    }
    
    
}



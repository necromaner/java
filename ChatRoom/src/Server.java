import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private PrintWriter pw=null;
    private BufferedReader br=null;
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args)  {
        new Server();
    }
    public Server() {
        try {
            String addr = InetAddress.getLocalHost().getHostAddress();//获得本机IP
            System.out.println("服务器IP："+addr);
            serverSocket =new ServerSocket(5000);
            System.out.println("启动成功");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("启动失败");
            e.printStackTrace();
        }
        Start();
        input();
        Close();
    }
    public void Start() {
        try {
            while (true) {
                socket = serverSocket.accept();
                pw=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(socket);
            }
        } catch (IOException e) {
            System.out.println("客户端连接失败");
            e.printStackTrace();
        }
    
    }
    public void input(){
        try {
            pw=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
    
            while(true){
                String string=br.readLine();
                System.out.println("Server读到："+string);
                System.out.print("Server端请输入：");
                String str=scanner.next();
                pw.println(str);
                pw.flush();
                if(str.equals("exit")){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Close(){
        try{
            serverSocket.close();
            socket.close();
            System.out.println("关闭成功");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("关闭失败");
        }
    }
}

class ServerThread extends Thread{
    private ServerSocket serverSocket;
//    private Socket socket;
    
    public ServerThread(ServerSocket serverSocket){
//        this.socket = socket;
        this.serverSocket=serverSocket;
    }
    public void run() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println(socket);
            }
        } catch (IOException e) {
            System.out.println("客户端连接失败");
            e.printStackTrace();
        }
    }
}
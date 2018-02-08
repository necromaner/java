
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import static java.net.InetAddress.getLocalHost;

public class Client {
    private Socket socket;
    private PrintWriter pw = null;
    private BufferedReader br = null;
    private boolean close = false;
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        new Client();
    }
    
//    public Client() {
//        Start();
//        while (true) {
////            new test1(socket).start();
////            new OutPut().start();
//            OutPut();
//            if (close) {
//                break;
//            }
//            InPut();
////            new InPut().start();
//            if (close)
//                break;
//        }
////        Close();
//    }

    public Client() {
        try {
            Scanner input = new Scanner(System.in);
//            System.out.print("输入连接ip:");
//            String ip=input.nextLine();
//            System.out.print("输入连接端口号:");
//            String port=input.nextLine();
            socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 5000);
            System.out.println("连接成功");
            System.out.println(socket);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            new test1(socket).start();
            new test2(socket).start();
        } catch (Exception e) {
            System.out.println("连接失败");
        }
    }
    
    public void Start() {
        try {
            Scanner input = new Scanner(System.in);
//            System.out.print("输入连接ip:");
//            String ip=input.nextLine();
//            System.out.print("输入连接端口号:");
//            String port=input.nextLine();
            socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 5000);
            System.out.println("连接成功");
            System.out.println(socket);
        } catch (Exception e) {
            System.out.println("连接失败");
        }
    }
    

    public class test1 extends Thread{
        Socket socket1;
        public test1(Socket socket){
            this.socket1=socket;
        }
        public void run() {
            try {
                while(true){
                    
//                    System.out.println("Client端请输入：");
                    String str = scanner.next();
                    pw.println(str);
                    pw.flush();
//                    String string=br.readLine();
//                    System.out.println("Client读到："+string);
                }
            }catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public class test2 extends Thread{
        Socket socket1;
        public test2(Socket socket){
            this.socket1=socket;
        }
        public void run() {
            try {
                while(true){
                
//                    System.out.println("Client端请输入：");
//                    String str = scanner.next();
//                    pw.println(str);
//                    pw.flush();
                    String string=br.readLine();
                    System.out.println("Client读到："+string);
//                    System.out.println(string);
                }
            }catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public void Close() {
        try {
            close = true;
            socket.close();
            System.out.println("关闭成功");
        } catch (IOException e) {
            System.out.println("关闭失败");
            e.printStackTrace();
        }
    }
}

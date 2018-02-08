
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
    
    public Client() {
        Start();
        while (true) {
//            new test1(socket).start();
//            new OutPut().start();
            OutPut();
            if (close) {
                break;
            }
            InPut();
//            new InPut().start();
            if (close)
                break;
        }
//        Close();
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
    
        public void InPut() {
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String string = br.readLine();
            System.out.println("Client读到：" + string);
            if (string.equals("exit")) {
                Close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void OutPut(){
        try {
            pw=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
                System.out.print("Client端请输入：");
                String str = scanner.next();
                pw.println(str);
                pw.flush();
                if(str.equals("exit")){
                    Close();
                }
        } catch (IOException e) {
            e.printStackTrace();
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
    
                    br = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
                    pw=new PrintWriter(new OutputStreamWriter(socket1.getOutputStream()));
                    System.out.println("Client端请输入：");
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
//    public class InPut extends Thread {
//        public InPut() {
//
//        }
//
//        public void run() {
//            try {
//                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                String string = br.readLine();
//                System.out.println("Client读到：" + string);
//                if (string.equals("exit")) {
//                    Close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    public class OutPut extends Thread {
//        public OutPut() {
//
//        }
//
//        public void run() {
//            try {
//                pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
//                System.out.print("Client端请输入：");
//                String str = scanner.next();
//                pw.println(str);
//                pw.flush();
//                if (str.equals("exit")) {
//                    Close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
    
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

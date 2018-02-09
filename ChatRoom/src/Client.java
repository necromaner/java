
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
    private String name="";
    
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
            System.out.print("请输入昵称： ");
            name=input.nextLine();
            if ("".equals(name)){
                name=InetAddress.getLocalHost().getAddress().toString();
            }
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            new OutPut(socket).start();
            new InPut(socket).start();
        } catch (Exception e) {
            System.out.println("+++++++++++1++++++++++++");
            System.out.println("连接失败");
        }
    }
    public class InPut extends Thread{
        Socket socket1;
        public InPut(Socket socket){
            this.socket1=socket;
        }
        public void run() {
            try {
                while(true){
                    
//                    System.out.println("Client端请输入：");
                    String str = scanner.next();
                    if ("======ERROR======".equals(Agreement(str))){
                        break;
                    }
                    pw.println(Agreement(str));
                    pw.flush();
                    System.out.println("test--1");
                }
            }catch (Exception e) {
                System.out.println("+++++++++++2++++++++++++");
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        /**
        协议:
         ==exit==     关闭客户端
         */
        public String Agreement(String s){
            if ("==exit==".equals(s)) {
                Close();
                return "======ERROR======";
            }else {
            String[] s1 = s.split("=-=",2);
            System.out.println("----1----"+s1.length);
            if (s1.length==2) {
                String[] s2 = s1[0].split("\\.");
                System.out.println("----2----"+s2.length);
                System.out.println();
                if (s2.length == 4) {
                    String[] s3 = s2[3].split(":");
                    System.out.println("----3----"+s3.length);
                    if (s3.length == 2)
                        return name + "|-=-=-=-|/" + s1[0] + "|-=-=-=-|" + s1[1];
                }
            }
            
            
            return name+"|-=-=-=-|"+"ALL"+"|-=-=-=-|"+s;
            }
        }
    }
    public class OutPut extends Thread{
        Socket socket1;
        public OutPut(Socket socket){
            this.socket1=socket;
        }
        public void run() {
            try {
                while(true){
                    String string=br.readLine();
                    System.out.println("Client读到："+string);
                }
            }catch (Exception e) {
                System.out.println("+++++++++++3++++++++++++");
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public void Close() {
        try {
            close = true;
            socket.close();
            System.exit(0);
            System.out.println("关闭成功");
        } catch (IOException e) {
            System.out.println("+++++++++++4++++++++++++");
            System.out.println("关闭失败");
            e.printStackTrace();
        }
    }
}

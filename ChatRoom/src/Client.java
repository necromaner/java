
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import static java.net.InetAddress.getLocalHost;

/**
 * 群发：直接发送
 * 单发：Address=-=发送内容
 * 多发：Address-Address-Address=-=发送内容
 *
 * 命令：
 * ==exit==     退出客户端
 * ==name==     改名
 * ==user==     查看所有在线用户的Address
 */
public class Client {
    private Socket socket;
    private PrintWriter writer = null;
    private BufferedReader reader = null;
    static Scanner scanner = new Scanner(System.in);
    private String name = "";
    
    public static void main(String[] args) {
        new Client();
    }
    public Client() {
        try {
            Scanner input = new Scanner(System.in);
//            System.out.print("输入连接ip:");
//            String ip=input.nextLine();
//            System.out.print("输入连接端口号:");
//            String port=input.nextLine();
            socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 5000);
            System.out.println("连接成功");
            System.out.println(socket.getLocalSocketAddress());
            if ("".equals(name)) {
                name = InetAddress.getLocalHost().getAddress().toString();
            }
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            new OutPut(socket).start();
            new InPut(socket).start();
        } catch (Exception e) {
            System.out.println("+++++++++++1++++++++++++");
            System.out.println("连接失败");
        }
    }
    public void ChangeName(){
        Scanner input = new Scanner(System.in);
        System.out.print("请输入昵称： ");
        this.name = input.nextLine();
    }
    public class InPut extends Thread {
        Socket socket1;
        
        public InPut(Socket socket) {
            this.socket1 = socket;
        }
        
        public void run() {
            try {
                while (true) {
                    String str = scanner.nextLine();
    
                    if ("==name==".equals(str))
                        ChangeName();
                    if ("==exit==".equals(str))
                        Close();
//                    String s=Agreement(str);
                    writer.println(name + "=-=" + str);
                    writer.flush();
                }
            } catch (Exception e) {
                System.out.println("+++++++++++2++++++++++++");
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    public class OutPut extends Thread {
        Socket socket1;
        
        public OutPut(Socket socket) {
            this.socket1 = socket;
        }
        
        public void run() {
            try {
                while (true) {
                    String string = reader.readLine();
                    System.out.println("Client读到：" + string);
                }
            } catch (Exception e) {
                System.out.println("+++++++++++3++++++++++++");
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    public void Close() {
        try {
            InPut.sleep(100);
            OutPut.sleep(100);
            writer.close();
            reader.close();
            socket.close();
            
            System.exit(0);
            System.out.println("关闭成功");
        } catch (IOException e) {
            System.out.println("+++++++++++4++++++++++++");
            System.out.println("关闭失败");
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }
}

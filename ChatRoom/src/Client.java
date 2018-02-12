
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
 * ==user==     查看所有在线用户的Address
 * ==help==     查看帮助
 *
 * 协议：
 * 发送内容                    发送给所有人消息
 * ALL=-=发送内容              发送给所有人消息
 * Address=-=消息             发送给Address消息
 * Address-Address=-=消息     发送给多个Address消息
 * NAME=-=昵称                修改昵称
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
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            new OutPut(socket).start();
            new InPut(socket).start();
        } catch (Exception e) {
            System.out.println("服务器端Address错误或未启动");
        }
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
    
                    if ("==exit==".equals(str))
                        Close();
                    writer.println(str);
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
                    if ("null".equals(string)){
                        Close();
                    }
                    System.out.println(string);
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
            writer.close();
            reader.close();
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

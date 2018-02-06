import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import static java.net.InetAddress.getLocalHost;

public class Client {
    private Socket socket;
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
            socket=new Socket(InetAddress.getLocalHost().getHostAddress(),5000);
            System.out.println("连接成功");
            System.out.println(socket);
        }catch (Exception e){
            System.out.println("连接失败");
        }
        try {
            socket.close();
            System.out.println("关闭成功");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("关闭失败");
        }
    }
}

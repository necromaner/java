import java.net.InetAddress;
import java.net.Socket;

import static java.net.InetAddress.getLocalHost;

public class Client {
    private Socket socket;
    public static void main(String[] args) {
        new Client();
    }
    public Client() {
        try {
            socket=new Socket(InetAddress.getLocalHost(),5000);
            System.out.println("连接成功");
        }catch (Exception e){
            System.out.println("连接失败");
        }
    }
}

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    public static void main(String[] args)  {
        new Server();
    }
    public Server() {
        
        try {
            String addr = InetAddress.getLocalHost().getHostAddress();//获得本机IP
            System.out.println("服务器IP："+addr);
            serverSocket =new ServerSocket(5000);
            System.out.println("启动成功");
            while (true) {
                socket = serverSocket.accept();
                System.out.println(socket);
            }
        }
        catch (Exception e){
            System.out.println("启动失败");
        }
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

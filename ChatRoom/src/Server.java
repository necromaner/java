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
            serverSocket =new ServerSocket(5000);
            System.out.println("启动成功");
            socket=serverSocket.accept();
            
        }
        catch (Exception e){
            System.out.println("启动失败");
        }
        
    }
}

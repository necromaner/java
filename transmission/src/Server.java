import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-03-06
 *
 * @Description: java类作用描述
 * Time: 下午4:04
 */
public class Server {
    List<ServerThread> clients = new ArrayList<ServerThread>();
    public static void main(String[] args) {
        new Server();
    }
    public Server(){
        String address = null;
        try {
            address = InetAddress.getLocalHost().getHostAddress();
            System.out.println("服务器IP：" + address);
            ServerSocket serverSocket=new ServerSocket(5000);
            System.out.println("服务器启动成功");
            while (true) {
                Socket socket = serverSocket.accept();
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                clients.add(serverThread);
                System.out.println("连接人数： " + clients.size());
        
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("未知主机异常");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("启动失败，请检查端口是否被占用");
        }
    }
    class ServerThread extends Thread {
        private Socket socket;
        public ServerThread(Socket socket){
            this.socket=socket;
            System.out.println(socket.getRemoteSocketAddress() + " 已连接");
            
        }
    }
}

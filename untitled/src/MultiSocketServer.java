import java.io.*;
import java.net.*;
public class MultiSocketServer
{
    public static void main(String str[]) throws IOException
    {
        ServerSocket server=new ServerSocket(3333);//绑定端口
        while(true)
        {
            Socket client=server.accept();//监听
            ChildTh child=new ChildTh(client);
            Thread t=new Thread(child);
            t.start();
        }
    }
}
class ChildTh implements Runnable
{
    private Socket client;
    public ChildTh(Socket client)
    {
        this.client=client;
    }
    
    public void run() {
        try
        {
            BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter out=new PrintWriter(client.getOutputStream());
            while(true)
            {
                String s=in.readLine();
                System.out.println(s);
                out.println("has received……");
                out.flush();
                if(s.equals("end"))
                    break;
            }
            client.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
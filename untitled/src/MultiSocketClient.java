import java.net.*;
import java.io.*;
public class MultiSocketClient
{
    static Socket server;
    public static void main(String str[]) throws  IOException
    {
        server=new Socket(InetAddress.getLocalHost().getHostAddress(),3333);
        BufferedReader in=new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter out=new PrintWriter(server.getOutputStream());
        BufferedReader wt=new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            String s=wt.readLine();
            out.println(s);
            out.flush();
            if(s.equals("end"))
            {
                break;
            }
            System.out.println(in.readLine());
        }
        server.close();
    }
}
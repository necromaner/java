
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
    private PrintWriter pw=null;
    private BufferedReader br=null;
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        new Client();
    }
    public Client() {
        Start();
        input();
        Close();
    }
    public void Start(){
        try {
            Scanner input = new Scanner(System.in);
//            System.out.print("输入连接ip:");
//            String ip=input.nextLine();
//            System.out.print("输入连接端口号:");
//            String port=input.nextLine();
            socket=new Socket(InetAddress.getLocalHost().getHostAddress(),5000);
            pw=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("连接成功");
            System.out.println(socket);
        }catch (Exception e){
            System.out.println("连接失败");
        }
    }
    public void input(){
        try {
            pw=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
    
            while(true){
                System.out.print("Client端请输入：");
                String str = scanner.next();
                pw.println(str);
                pw.flush();
                String string=br.readLine();
                System.out.println("Client读到："+string);
                if(str.equals("exit")){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Close(){
        try{
            socket.close();
            System.out.println("关闭成功");
        } catch (IOException e) {
            System.out.println("关闭失败");
            e.printStackTrace();
        }
    }
}

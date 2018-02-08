
import java.io.IOException;
import java.net.*;
import java.io.*;
import java.util.*;

/**
 * Description:
 * 搭建一个Socket服务器响应多用户访问
 * @author Lee
 * */
public class ServerSocketDemo {
    ArrayList MSG = new ArrayList<>();
    ArrayList RES = new ArrayList<>();
    
    /**
     * Description:
     * 初始化数据
     * */
//    public void init(){
//        MSG.add("hellow");
//        RES.add("hi");
//    }
    
    /**
     * Description:
     * 搭建一个Socket服务器响应多个用户访问
     * */
    public void test1(){
//        init();
        ServerSocket server = null;
        
        try{
            //以指定端口搭建一个Socket服务端
            server = new ServerSocket(12000);
            
            //等待客户端Socket实例，并创建一个线程去响应该客户单实例
            while(true){
                new Response(server.accept()).start();;
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                server.close();
            }catch(IOException e){
                e.printStackTrace();
            }
            
        }
    }
    
    /**
     * Description:
     * 根据用户输入的内容，返回相应的内容
     *
     * @param msg 客户端输入的内容
     * @return 返回服务端回复的内容
     * */
    public String getMsg(String msg){
        String res = "Are you kidding me?Please speak English.";
        
        for(int i=1;i<MSG.size();i++){
            if(msg.contains((CharSequence) MSG.get(i))){
                res = (String) RES.get(i);
            }
        }
        
        return res;
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new ServerSocketDemo().test1();
    }
    
    /**
     * Description:
     * 响应用户
     * @author Lee
     * */
    class Response extends Thread{
        Socket client;
        
        /**
         * Description:
         * 默认构造器
         * */
        public Response(){}
        /**
         * Description:
         * 初始化Socket
         * */
        public Response(Socket client){
            this.client = client;
        }
        
        @Override
        public void run(){
            Scanner input = null;
            PrintWriter output = null;
            
            try{
                //获取用户端的输入和输出流
                input = new Scanner(client.getInputStream());
                output = new PrintWriter(client.getOutputStream());
                
                output.println("欢迎访问!");
                output.flush();
                
                //等待客户端的输入
                String content = null;
                while(input.hasNext()){
                    content = input.nextLine();
                    System.out.println(client.getLocalSocketAddress()+" :"+content);
                    //根据用户端的输入，做出相应的反应
                    if(content.equalsIgnoreCase("quit")){
                        break;
                    }else{
                        output.println(getMsg(content));
                        output.flush();
                    }
                }
                
            }catch(IOException e){
                e.printStackTrace();
            }finally{
                //关闭资源
                input.close();
                output.close();
            }
            
            
        }
    }
}

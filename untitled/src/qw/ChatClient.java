package qw;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
    private JTextArea ta;
    private JTextField tf;
    private JButton b;
    private BufferedReader reader;
    private PrintWriter writer;
    private Socket socket;
    public static void main(String[] args) {
        new ChatClient().frame();
    }
    public void frame(){
        JFrame f = new JFrame("BB");
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        ta = new JTextArea(12, 30); // 文本域，第一个参数为行数，第二个参数为列数
        ta.setEditable(false); // 文本域只读
        JScrollPane sp = new JScrollPane(ta); // 滚动窗格
        tf = new JTextField(20);
        b = new JButton("发送");
        p1.add(sp);
        p2.add(tf);
        p2.add(b);
        f.add(p1, "Center");
        f.add(p2, "South");
        f.setBounds(300, 300, 360, 300);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.b.addActionListener(new TFListener());
        this.connect();
        
        
    }
    public void connect(){
        try {
            socket = new Socket("127.0.0.1", 5000);
            writer = new PrintWriter((socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            new sendThread().start();
            
        } catch (UnknownHostException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
    }
    class TFListener implements ActionListener {
        private String str;
        @Override
        public void actionPerformed(ActionEvent e) {
            str = tf.getText()+"\n";
            tf.setText("");
//            ta.append(str);
            writer.println(str);
            writer.flush();
            
        }
        
    }
    class sendThread extends Thread{
        private String str;
        @Override
        public void run() {
            recMsg();
        }
        public void recMsg(){
            try {
                while(true){
                    str = reader.readLine()+"\n";
                    ta.append(str);
                }
            } catch (IOException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            
        }
    }
}

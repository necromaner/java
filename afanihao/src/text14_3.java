import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-25
 * Time: 下午8:17
 */
public class text14_3 {
    private JFrame frame;
    private JButton but;
    private JPasswordField txt;
    private JPanel kuang;
    public int cishu=0;
    public void window(String password,int max){
        frame=new JFrame("密码");
        frame.setLayout(new BorderLayout());
        frame.setSize(400,100);
        but=new JButton("确认");
        txt=new JPasswordField();
        txt.setEchoChar('*');
        kuang=new JPanel(new BorderLayout());
        kuang.setBorder(new TitledBorder("输入密码"));
        kuang.add(txt,"Center");
        kuang.add(but,"East");
        frame.add(kuang);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);// 退出程序
            }
        });
        // 文本框按回车键时事件
        txt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shuru(password,max);
            }
        });
    
        // 单击发送按钮时事件
        but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                shuru(password,max);
            }
        });
    }
    public void shuru(String password,int max) {
        String aaa = txt.getText();
        System.out.println(password + " " + max + " " + aaa + " ");
        if (password.equals(aaa)) {
            System.out.println("密码正确");
            System.exit(0);
        } else {
            cishu++;
            System.out.println("密码错误，剩余输入次数"+(max-cishu));
            if(cishu>=max){
                System.out.println("错误次数太多");
                System.exit(0);
            }
        }
    }
}

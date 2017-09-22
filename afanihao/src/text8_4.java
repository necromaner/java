import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-22
 * Time: 下午1:56
 */
public class text8_4 {
    private JFrame frame;
    private JButton but;
    public int color = 0;  // 0: 红色  1:绿色  2: 黄色
    
    public void window() {
        frame = new JFrame("变换颜色");
        frame.setSize(500, 400);               //设置窗体大小
        but = new JButton("变色");
        but.setForeground(Color.RED);
        Font f=new Font("华文行楷",Font.BOLD,50);//根据指定字体名称、样式和磅值大小，创建一个新 Font。
        but.setFont(f);
        frame.add(but);
        frame.setVisible(true);                               //设置窗体可见
        // 关闭窗口时事件
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);// 退出程序
            }
        });
        but.addActionListener(new ActionListener() {            //点击发送触发事件
            @Override
            public void actionPerformed(ActionEvent e) {
                but.setText("变色");
                color++;
                if (color > 2)
                    color = 0;
                switch (color) {
                    case 0:
                        but.setForeground(Color.RED);
                        break;
                    case 1:
                        but.setForeground(Color.GREEN);
                        break;
                    case 2:
                        but.setForeground(Color.YELLOW);
                        break;
                    default:
                        but.setText("坏了");
                        break;
                }
            }
        });
    }
}

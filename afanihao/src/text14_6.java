import java.util.Random;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-10-01
 * Time: 下午10:08
 */
public class text14_6 {
    public int a;
    public int b;
    public int c;//0加 1减 2乘
    public int min;
    public int max;
    private int answer;
    private int read;
    private boolean bbb = true;
    private int tihao = 0;
    
    public text14_6() {
        this.min = 0;
        this.max = 100;
    }
    
    public text14_6(int max) {
        this.min = 0;
        this.max = max;
    }
    
    public text14_6(int min, int max) {
        this.min = min;
        this.max = max;
    }
    
    public void ti() {
        while (bbb) {
            int cc = 3;
            timu();
            boolean aaa = true;
            while (aaa) {
                int shu = ReadTest();
                if (answer == shu) {
                    System.out.println("答案正确");
                    aaa = false;
                } else {
                    if (cc < 1) {
                        aaa = false;
                        System.out.println("答案是：" + answer);
                    } else {
                        System.out.println("答案错误，请再次输入，" + cc + "次后告诉正确答案");
                        cc--;
                    }
                }
            }
        }
    }
    
    private void timu() {
        tihao++;
        Random random = new Random();
        a = random.nextInt(max) % (max - min + 1) + min;
        b = random.nextInt(max) % (max - min + 1) + min;
        c = random.nextInt(3);
        switch (c) {
            case 0:
                System.out.print("第" + tihao + "题： " + a + "+" + b + "=");
                answer = a + b;
                break;
            case 1:
                System.out.print("第" + tihao + "题： " + a + "-" + b + "=");
                answer = a - b;
                break;
            case 2:
                System.out.print("第" + tihao + "题： " + a + "*" + b + "=");
                answer = a * b;
                break;
        }
    }
    public int ReadTest() {
        //System.out.println("ReadTest, Please Enter Data:");
        InputStreamReader is = new InputStreamReader(System.in); //new构造InputStreamReader对象
        BufferedReader br = new BufferedReader(is); //拿构造的方法传到BufferedReader中
        try { //该方法中有个IOExcepiton需要捕获
            String name = br.readLine();
            read = Integer.parseInt(name);
            //    System.out.println("ReadTest Output:" + read);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return read;
    }
}

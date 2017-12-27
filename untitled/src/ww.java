import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-11-16
 * Time: 下午10:26
 */
public class ww {
    public static void main(String[] args) {
//        System.out.println(sum(100));
        qwe q1=new qwe();
        q1.name="aaa";
        q1.x=10;
        q1.y();
        qwe q2=q1;
        q2.name="bbb";
        q2.y();
        q1.y();
        qwe q3=new qwe();
        q3=q1;
        q3.name="ccc";
        q1.y();
        
    }
    public static int sum(int num){
        if (num==1){
            return num;
        }
        return num+sum(num-1);
        
    }
}

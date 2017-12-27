/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-12-26
 * Time: 下午4:16
 */
public class String1 {
    public static void main(String[] args) {
        String x1="hello";
        String x2=new String("hello");
        String x3="hello";
        String x4=new String("hello");
        System.out.println(x1==x2);
        System.out.println(x1==x3);
        System.out.println(x2==x4);
        System.out.println(x2.equals(x4));
        
    }
}

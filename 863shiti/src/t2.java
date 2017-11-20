/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-11-18
 * Time: 下午4:13
 */
public class t2 {
    public static void main(String[] args) {
        String c="1,2";
        String[] strs=c.split(",");
        if(strs.length==2) {
            int a = Integer.parseInt(strs[0]);
            int b = Integer.parseInt(strs[1]);
            if (a > b) {
                int cc = a;
                a = b;
                b = cc;
            }
            System.out.println(a + " " + b + " " + (b - a));
        }else System.out.println("输入错误");
    }
}

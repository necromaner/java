/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-10-14
 * Time: 下午3:50
 */
public class recursive {
    public static void main(String[] args) {
        System.out.println("1.一列数的规则如下: 1、1、2、3、5、8、13、21、34...... 求第30位数是多少， 用递归算法实现。");
        r1 r1=new r1();
        int x1=6;
        System.out.println("第"+x1+"位数是 "+r1.R1(x1));
    
        System.out.println("\n\n2.将一整数逆序后放入一数组中（要求递归实现） Ex : 1234 变为 {4,3,2,1}");
        int x2=1234;
        int[] xx2=r1.R2(x2);
        System.out.print("整数"+x2+"变为");
        for (int i = 0; i < xx2.length; i++) {
            System.out.print(xx2[i]+" ");
        }
    
        System.out.println("\n\n\n递归实现回文判断（如：abcdedbca就是回文，判断一个面试者对递归理解的简单程序）");
        String x3="abcdedbca";
        System.out.print(x3+"："+r1.R3(x3,0,x3.length()-1));
    
    
        System.out.println("\n\n分解成质因数(如435234=251*17*17*3*2，据说是华为笔试题)");
        int x4=435234;
        int[] x44=r1.R4(x4,1);
        System.out.print(x4+"=");
        for (int i = 0; i < xx2.length; i++) {
            System.out.print(xx2[i]);
            if (i!=xx2.length-1){
                System.out.print("*");
            }else if (i==xx2.length-1){
                System.out.println("");
            }
        }
    }
}

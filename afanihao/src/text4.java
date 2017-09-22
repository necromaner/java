/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-12
 * Time: 下午6:16
 */
public class text4 {
    public static void main(String[] args) {
        System.out.println("给定一个数a, 如果为奇数则输出“为奇数\"  。如果是偶数则输出“为偶数");
        int  a = 123;
        if(a/2==0)
            System.out.println("为奇数");
        else
            System.out.println("为偶数");
        System.out.println("给定一个数，判断它是否既能被3整除，又能被7整除");
        if(a/3==0&&a/7==0)
            System.out.println("既能被3整除，又能被7整除");
        else
            System.out.println("No");
        System.out.println("给定一个数，判断它是否在70和80之间");
        if(a>=70&&a<=80)
            System.out.println("在70和80之间");
        else
            System.out.println("No");
        System.out.println("给定一个数，如果它在 [ 10, 20] 之间 ，或者在 [50-60] 之间，则显示 OK。 否则显示错误");
        if(a>=10&&a<=20||a>=50&&a<=60)
            System.out.println("OK");
        else
            System.out.println("错误");
        System.out.println("给定一个值 （可正可负) ，显示它的绝对值\n" + "int  a = -98;");
        int  a1 = -98;
        if(a1>=0)
            System.out.println(a1);
        else
            System.out.println(-a1);
        System.out.println("给定3个数 a, b , c ，判断它们是否相等\n" +
                "int  a = 10;\n" +
                "int  b = 10;\n" +
                "int  c = 11;");

        int  a2 = 10;
        int  b2 = 10;
        int  c2 = 11;
        if (a2==b2)
            System.out.println("a2==b2");
        else
            System.out.println("a2!=b2");
        if(b2==c2)
            System.out.println("b2==c2");
        else
            System.out.println("b2!=c2");
        if(a2==c2)
            System.out.println("a2==c2");
        else
            System.out.println("a2!=c2");
        System.out.println("打印从1到20所有能被4整除的数");
        for (int i=1;i<=40;i++){
            if(i%4==0)
                System.out.println(i+" ");
        }
        System.out.println("打印所有1-20之间能被3带除的数。按从大到小的顺序。");
        for (int i=20;i>=1;i--){
            if(i%3==0)
                System.out.print(i+" ");
        }
        
        System.out.println("给定一个数N,  求 1 + 2 + 3 + ... + N 的和");
        int N=20;
        int sum=0;
        for (int i=0;i<=N;i++)
            sum+=i;
        System.out.println(sum);
        
        System.out.println("求100以内的奇数的平方和 \n" +
                "即 1* 1 +  3*3  + 5*5 + ... + 99 * 99 的和");
        int sum1=0;
        for (int i=1;i<=100;i++){
            if(i%3==0){
                sum1+=i*i;
            }
        }
        System.out.println(sum1);
    }
}

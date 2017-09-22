/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-12
 * Time: 下午6:09
 */
/*
描述：

给定3个整数，求它们的乘积。
		int a = 123;
		int b = 23;
		int c = 9;
求a,b,c的乘积。并打印输出。
 */
public class text3 {
    public static void main(String[] args) {
        /*
		int a = 123;
		int b = 23;
		int c = 9;
求a,b,c的乘积。并打印输出。
 */
        int a = 123;
        int b = 23;
        int c = 9;
        System.out.println(a*b*c);
        /*
        给定3个数a,b,c ，求它们的平方之和。

int a = 123;
int b = 23;
int c = 9;
求a,b,c的平方之和。并打印输出。
         */
        System.out.println(a^2+b^2+c^2);
        /*
        在以下表达式中，result的值是多少？
(1)
int  a = 10;
int  b = 20;
int  result = a * b;

(2)
int result = 17 % 4 ;

(3)
int result = 4 % 17;

(4)
int result = 17 % 17;

(5)
int result = 13 / 5;

(6)
double result = 13.0 / 5.0;
         */
        int  a1 = 10;
        int  b1 = 20;
        int  result1 = a1 * b1;//200
    
        int result2 = 17 % 4 ;//1
    
        int result3 = 4 % 17;//4
    
        int result4 = 17 % 17;//0
    
        int result5 = 13 / 5;//2
    
        double result6 = 13.0 / 5.0;//2.6
        System.out.println(result1+"  "+result2+"  "+result3+"  "+result4+"  "+result5+"  "+result6);
    }
}

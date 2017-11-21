/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-11-20
 * Time: 下午10:27
 */
/*
Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

Example:
Given a = 1 and b = 2, return 3.
 */
public class Leetcode_15_371_SumofTwoIntegers {
    public static void main(String[] args) {//完成
        int a=-12;
        int b=-8;
        Solution solution = new Solution();
        int c=solution.getSum(a,b);
        System.out.println("a = "+a);
        System.out.println("b = "+b);
        System.out.println("c = "+c);
    }
    
}

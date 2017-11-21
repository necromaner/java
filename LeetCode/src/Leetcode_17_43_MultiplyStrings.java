/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-11-21
 * Time: 下午12:30
 */
/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

    The length of both num1 and num2 is < 110.
    Both num1 and num2 contains only digits 0-9.
    Both num1 and num2 does not contain any leading zero.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.

 */
public class Leetcode_17_43_MultiplyStrings {//完成
    public static void main(String[] args) {
        String num1 = "999";
        String num2 = "9";
        Solution solution = new Solution();
        String num3 = solution.multiply(num1, num2);
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("num3 = " + num3);
    }
}

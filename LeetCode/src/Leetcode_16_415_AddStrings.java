/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-11-20
 * Time: 下午10:38
 */
/*
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

    The length of both num1 and num2 is < 5100.
    Both num1 and num2 contains only digits 0-9.
    Both num1 and num2 does not contain any leading zero.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.

 */
public class Leetcode_16_415_AddStrings {//完成
    public static void main(String[] args) {
        String num1 = "99";
        String num2 = "9";
        Solution solution = new Solution();
        String num3 = solution.addStrings(num1, num2);
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
        System.out.println("num3 = " + num3);
    }
}

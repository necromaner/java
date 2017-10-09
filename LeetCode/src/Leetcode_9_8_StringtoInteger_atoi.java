/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-10-09
 * Time: 下午8:48
 */
/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

 */
public class Leetcode_9_8_StringtoInteger_atoi {//完成
    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "2147483648";
        System.out.println(str+" = " + solution.myAtoi(str));
    }
}

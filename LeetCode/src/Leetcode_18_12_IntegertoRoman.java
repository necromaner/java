/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-11-21
 * Time: 下午10:01
 */
/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.
 */
public class Leetcode_18_12_IntegertoRoman {//完成
    public static void main(String[] args) {
        Solution solution = new Solution();
        int num=100;
        String roman=solution.intToRoman(num);
        System.out.println("num is = "+num);
        System.out.println("Roman  = "+roman);
    }
}

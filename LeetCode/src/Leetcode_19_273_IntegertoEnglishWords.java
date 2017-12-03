/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-11-25
 * Time: 下午4:24
 */
/*
 Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 2^31 - 1.

For example,

123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 */
public class Leetcode_19_273_IntegertoEnglishWords {//完成
    public static void main(String[] args) {
        Solution solution = new Solution();
        int num=10000;
        String english=solution.numberToWords(num);
        System.out.println("num  is  = "+num);
        System.out.println("English  = "+english);
    }
}

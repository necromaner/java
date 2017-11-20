/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-11-17
 * Time: 下午8:45
 */
/*
 Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
 */
public class Leetcode_14_67_AddBinary {
    public static void main(String[] args) {
        String a="11111";
        String b="11111";
        Solution solution = new Solution();
        String c=solution.addBinary(a,b);
        System.out.println("a = "+a);
        System.out.println("b = "+b);
        System.out.println("c = "+c);
    }
}

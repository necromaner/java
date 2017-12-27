/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-12-14
 * Time: 下午9:49
 */
/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class Leetcode_27_32LongestValidParentheses {//抄
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "()(())";
        System.out.println("the longest valid parentheses substring is \" " + s + "\",");
        System.out.println("which has length = " + solution.longestValidParentheses(s));
    }
}

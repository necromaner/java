/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-10-07
 * Time: 下午11:44
 */
/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.

Example:

Input: "cbbd"

Output: "bb"

 */
public class Leetcode_4_5_LongestPalindromicSubstring {//完成
    public static void main(String[] args) {
        Solution solution=new Solution();
        String s="ccc";
        System.out.println(s+" longest palindromic substring is "+solution.longestPalindrome(s));
    }
}

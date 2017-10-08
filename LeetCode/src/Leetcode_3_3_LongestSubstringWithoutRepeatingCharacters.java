/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-10-07
 * Time: 下午10:33
 */
/*
Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Leetcode_3_3_LongestSubstringWithoutRepeatingCharacters {//完成
    public static void main(String[] args) {
        Solution solution=new Solution();
        String s="pww";
        System.out.println(s+" the length of "+solution.lengthOfLongestSubstring(s));
    }
}

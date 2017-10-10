/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-10-09
 * Time: 下午11:10
 */
/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
 */
public class Leetcode_11_10_RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcd";
        String p = "d*a*c*c*b*c*d";
        System.out.println("isMatch(\""+s+"\", \""+p+"\") → "+ solution.isMatch(s,p));
    }
}

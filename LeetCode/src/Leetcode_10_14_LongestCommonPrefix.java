/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-10-09
 * Time: 下午10:41
 */
/*
Write a function to find the longest common prefix string amongst an array of strings.
 */
public class Leetcode_10_14_LongestCommonPrefix {//完成
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] str = {"aaaa","aaaa","aaaaa"};
        System.out.println("longest common prefix is : " + solution.longestCommonPrefix(str));
    }
}

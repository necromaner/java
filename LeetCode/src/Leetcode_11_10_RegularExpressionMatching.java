/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-10-09
 * Time: 下午11:10
 */
public class Leetcode_11_10_RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aab";
        String p = "c*a*b";
        System.out.println("isMatch(\""+s+"\", \""+p+"\") → "+ solution.isMatch(s,p));
    }
}

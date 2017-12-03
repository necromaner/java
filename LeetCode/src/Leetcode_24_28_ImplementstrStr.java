/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-11-30
 * Time: 下午4:22
 */
public class Leetcode_24_28_ImplementstrStr {//完成
    public static void main(String[] args) {
        Solution solution = new Solution();
        String haystack = "aqq";
        String needle = "qqq";
        System.out.println("Input: haystack = \""+haystack+"\", needle = \""+needle+"\"");
        System.out.println("Output: "+solution.strStr(haystack,needle));
    }
}

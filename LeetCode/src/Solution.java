/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-10-05
 * Time: 下午5:57
 */
import java.util.Arrays;
public class Solution {
    public int[] twoSum(int[] nums, int target) {//1. Two Sum
        int[] answer = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return answer;
    }
    
    public int reverse(int x) {//7. Reverse Integer
        int punctuation = 1;
        if (x < 0) {
            x = -x;
            punctuation = -1;
        }
        int y = 0;
        while (x >= 1) {
            if ((Integer.MAX_VALUE / 10 < y) || (Integer.MAX_VALUE / 10 == y && Integer.MAX_VALUE % 10 < x))//if out of the range
                return 0;
            y = y * 10 + x % 10;
            x /= 10;
        }
        return y * punctuation;
    }
    
    public int lengthOfLongestSubstring(String s) {//3. Longest Substring Without Repeating Characters
        if (s.length() == 0) {
            return 0;
        }
        int max = 1;
        lableC:
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                lableB:
                for (int j = i + 1; j < s.length(); j++) {
                    int answer = 1;
                    lableA:
                    for (int k = i; k < j; k++) {
                        if (s.charAt(j) == s.charAt(k)) {
                            break lableB;
                        }
                        answer++;
                    }
                    if (max < answer) {
                        max = answer;
                    }
                }
            }
        }
        return max;
    }
    
    public String longestPalindrome(String s) {//5. Longest Palindromic Substring
        /*
        1.以i为中心
        2.判断i后面一样的字符，中心点为middle,把i变大中心一样的数量-1（减少运算次数）
        3.找到所求字符中最小的位置和最大的位置
        4.输出
         */
        String maxString = "";
        if (s.length() > 1000) {
            return maxString;
        }
        maxString = String.valueOf(s.charAt(0));
        if (s.length() == 0) {
            return maxString;
        }
        int maxLong = 0;//最大长度
        lableB:
        for (int i = 0; i < s.length() - 1; i++) {//以i为中心
            double middle = i;//中心点
            int heart = 1;//中心一样的数量
            lableA:
            for (int j = i + 1; j < s.length(); j++) {//找中心一样的数量
                while (s.charAt(i) != s.charAt(j)) {
                    break lableA;
                }
                heart++;
            }
            if (heart % 2 == 0) {
                middle += heart / 2 - 0.5;
            } else {
                middle += heart / 2;
            }
            i += heart - 1;
            int min = (int) (middle - heart / 2 + 0.5);
            int max = (int) (middle + heart / 2);
            lableC:
            while (min > 0 && max < s.length() - 1) {
                if (s.charAt(min - 1) != s.charAt(max + 1)) {
                    break lableC;
                }
                min--;
                max++;
                heart += 2;
            }
            if (maxLong < heart) {
                maxLong = heart;
                maxString = s.substring(min, max + 1);
            }
        }
        return maxString;
    }
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {//4. Median of Two Sorted Arrays
        double answer = 0;
        int[] longmax = new int[nums1.length + nums2.length];
        //int longnum=nums1.length+nums2.length;
        for (int i = 0; i < longmax.length; i++) {
            if (i < nums1.length) {
                longmax[i] = nums1[i];
            } else {
                longmax[i] = nums2[i - nums1.length];
            }
        }
        double longmaxlength = longmax.length;
        double length = longmaxlength / 2 + 0.5;
        int min = (int) (length - 1);
        int max = (int) (length + 0.5 - 1);
        Arrays.sort(longmax);
        answer = longmax[min] + longmax[max];
        return answer / 2;
    }
    
    public int maxProfit(int[] prices) {//121. Best Time to Buy and Sell Stock
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int maxprices = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else {
                if (maxprices < prices[i] - min) {
                    maxprices = prices[i] - min;
                }
            }
        }
        return maxprices;
    }
    
    public int maxProfit1(int[] prices) {//121. Best Time to Buy and Sell Stock
        if (prices == null || prices.length < 1) {
            return 0;
        }
        int maxprices = 0;
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            } else {
                if (maxprices < prices[i] - min) {
                    maxprices = prices[i] - min;
                }
                if (i + 1 <= prices.length - 1) {
                    if (prices[i] > prices[i + 1]) {
                        max += maxprices;
                        maxprices = 0;
                        min = prices[i + 1];
                    }
                }
                if (i == prices.length - 1) {
                    max += maxprices;
                }
            }
        }
        return max;
    }
    
    public int maxSubArray(int[] nums) {//53. Maximum Subarray
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int len = nums.length;
        if (len == 1)
            return nums[0];
    
        int sum0 = nums[0];
        int sum1 = nums[0];
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("");
        for (int i = 1; i < len; i++) {
            System.out.println("---------------------");
            if (sum1 >= 0) {
                System.out.println("sum1-1 = " + sum1);
                System.out.println("nums[i]1 = " + nums[i]);
                sum1 = sum1 + nums[i];
                System.out.println("sum1 = " + sum1);
            } else {
                System.out.println("sum1-2 = " + sum1);
                System.out.println("nums[i]2 = " + nums[i]);
                sum1 = nums[i];
                System.out.println("sum1 = " + sum1);
            }
            System.out.println("sum0 = " + sum0);
            if (sum1 > sum0) {
                sum0 = sum1;
                System.out.println("sum = " + sum0);
            }
        }
        return sum0;
    }
    
    public int myAtoi(String str) {//8. String to Integer (atoi)
        int answer = 0;
        String answer1 = "";
        boolean symbol = true;
        boolean symbolSwitch = true;
        boolean number = false;
        int min = 0;
        int max = str.length();
        for (int i = 0; i < str.length(); i++) {
            if (symbolSwitch) {//去除最前面空格
                while (str.charAt(i) == ' ') {
                    i++;
                    min++;
                }
            }
            if (symbolSwitch) {//判断第一个是否为符号
                if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                    if (str.charAt(i) == '-') {
                        symbol = false;
                    }
                    if (i + 1 >= str.length()) {
                        break;
                    }
                    i++;
                }
                symbolSwitch = false;
            }
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                number = true;
            } else {
                max = i;
                break;
            }
        }
        if (number) {
            answer1 = str.substring(min, max);
            try {
                answer = Integer.parseInt(answer1);
                return answer;
            } catch (NumberFormatException e) {//Number Format Exception:数字格式异常
                return (symbol) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        } else
            return 0;
    }
    
    public String longestCommonPrefix(String[] strs) {//14. Longest Common Prefix
        String answer = null;
        if (strs == null || strs.length < 1) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int min = strs[0].length();
        int minlocation = 0;
        for (int i = 1; i < strs.length; i++) {
            if (min > strs[i].length()) {
                min = strs[i].length();
                minlocation = i;
            }
        }
        int max = 0;
        lB:
        for (int i = 0; i < min; i++) {
            lA:
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[minlocation].charAt(i)) {
                    break lB;
                }
            }
            max++;
        }
        answer = strs[minlocation].substring(0, max);
        System.out.println(max);
        return answer;
    }
    
    public boolean isMatch(String s, String p) {//10. Regular Expression Matching
        //http://www.jianshu.com/p/85f3e5a9fcda
        System.out.println("p = "+p);
        System.out.println("s = "+s);
        if (p.isEmpty()) {                              //条件1：p没有内容；//isEmpty:指出变量是否已经初始化
            //p为空，看s会否也为空
            //判断类型：p为空
            System.out.println("------1------");
            return s.isEmpty();                         //返回1:s是否有内容，有内容为false
        }
        
        
        if (p.length() == 1 || p.charAt(1) != '*') {    //条件2：如果p的长度为1或者p的第二个字符不为"*"
            //p存在字符且p后不为"*"，
            //判断类型：p的长度为1或ab aa
            System.out.println("------2------");
            if (s.isEmpty() || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))) {//条件2-1：如果s中没有内容，或（p的第一个字符不为"."且p的第一个元素不等于s的第一个字符）
                //1：s为空，p不为空；2：s的第一个字符与p的第一个字符不对应，如a b
                //判断类型：s为空或b a
                System.out.println("------2-1-----");
                return false;                           //返回2-1：错误
            } else {                                    //条件2-2：如果s中有内容，或（p的第一个字符为"."或s的第一个等于p的第一个字符）
                //1:s和p都不为空；2：s的第一个字符与p的第一个字符对应，如a a,a .
                //判断类型：a a或a .
                System.out.println("------2-2-----");
                return isMatch(s.substring(1), p.substring(1));//返回2-2：isMatch，s去掉前一个字符，p去掉前一个字符
            }
        }
    
        while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {//条件3：如果s不为空且（s的第一个等于p的第一个字符或p的第一个字符为"."）
            //s不为空且s的第一个字符与p的第一个字符对应，因为上一个的筛选，所有p的长度大于1且后面为*，如a a*,
            //判断类型：ab a*，
            System.out.println("------3开始------");
            if (isMatch(s, p.substring(2))) {               //条件3-1：递归
                //去掉p前两个字符，看是否带*有影响
                //判断*给前面应有0个
                //筛选类型：ab a*ab，
                System.out.println("------3-1-----");
                return true;
            }
            System.out.println("------3结束------");
            s = s.substring(1);
        }
    
        System.out.println("-------------");
        return isMatch(s, p.substring(2));//返回：isMatch，s不变，p去掉前二个字符 //substring:java中截取字符串的一个方法
        //执行类型：b a*，
    }
}
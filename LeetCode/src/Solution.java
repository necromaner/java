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
        System.out.println("p = " + p);
        System.out.println("s = " + s);
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
    
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val > l2.val) {
            ListNode tmp = l2;
            tmp.next = mergeTwoLists(l1, l2.next);
            return tmp;
        } else {
            ListNode tmp = l1;
            tmp.next = mergeTwoLists(l1.next, l2);
            return tmp;
        }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {//2. Add Two Numbers
        ListNode result = new ListNode(0);
        int carry = 0;
        ListNode pointer = result;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
    
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            pointer.next = new ListNode(carry % 10);
            carry /= 10;
            pointer = pointer.next;
    
        }
        
        if (carry > 0) {
            pointer.next = new ListNode(carry);
        }
        return result.next;
    }
    
    public String addBinary(String a, String b) {
        String answer = "";
        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return a;
        }
        String lmax = a.length() >= b.length() ? a : b;
        char l1 = '0';//上一循环的进位，也是下一循环的本位
        for (int i = 0; i < lmax.length(); i++) {
            char ca = a.length() > i ? a.charAt(a.length() - i - 1) : '0';
            char cb = b.length() > i ? b.charAt(b.length() - i - 1) : '0';
            int sum = ca + cb + l1 - 144;
            char l0 = '0';
            switch (sum) {
                case 0:
                    l0 = '0';
                    l1 = '0';
                    break;
                case 1:
                    l0 = '1';
                    l1 = '0';
                    break;
                case 2:
                    l0 = '0';
                    l1 = '1';
                    break;
                case 3:
                    l0 = '1';
                    l1 = '1';
                    break;
            }
            answer = l0 + answer;
        }
        if (l1 == '1') {
            answer = l1 + answer;
        }
        return answer;
    }
    
    public int getSum(int a, int b) {
        if (b >= 0)
            for (int i = 0; i < b; i++)
                a++;
        else
            for (int i = 0; i > b; i--)
                a--;
        return a;
    }
    
    public String addStrings(String num1, String num2) {//415.Add Strings
        String answer = "";
        if (num1.length() == 0) {
            return num2;
        }
        if (num2.length() == 0) {
            return num1;
        }
        String lmax = num1.length() >= num2.length() ? num1 : num2;
        int l1 = 0;//上一循环的进位，也是下一循环的本位
        for (int i = 0; i < lmax.length(); i++) {
            char ca = num1.length() > i ? num1.charAt(num1.length() - i - 1) : '0';
            char cb = num2.length() > i ? num2.charAt(num2.length() - i - 1) : '0';
            int sum = ca + cb + l1 - 96;
            l1 = sum / 10;
            int l0 = sum % 10;
            answer = String.valueOf(l0) + answer;
        }
        if (l1 >= 1 && l1 <= 9) {
            answer = l1 + answer;
        }
        return answer;
    }
    
    public String multiply(String num1, String num2) {//43. Multiply Strings
        if (num1.length() == 0 || num2.equals("0")) {
            return num2;
        }
        if (num2.length() == 0 || num1.equals("0")) {
            return num1;
        }
        String[] sa = num1.split("");
        String[] sb = num2.split("");
        int[] answer = new int[sa.length + sb.length];
        for (int i = 0; i < sa.length; i++) {
            for (int j = 0; j < sb.length; j++) {
                char ca = sa[sa.length-1-i].charAt(0);
                char cb = sb[sb.length-1-j].charAt(0);
                int sum = (ca - 48) * (cb - 48);
                answer[answer.length - i - j-1] += (sum);
            }
        }
        for (int i = answer.length-1; i >0; i--) {
            while (answer[i]>9){
                answer[i-1]+=answer[i]/10;
                answer[i]%=10;
            }
        }
        String answer1="";
        for (int i = answer.length-1; i >=0 ; i--) {
            answer1=answer[i]+answer1;
        }
        while (answer1.charAt(0)=='0'){
            answer1=answer1.substring(1,answer1.length());
        }
        return answer1;
    }
    public String intToRoman(int num) {//12. Integer to Roman
        //Ⅰ（1）、X（10）、C（100）、M（1000）
        //V（5）、L（50）、D（500）
        // 0-4     I  II  III IV
        //5-9   V VI VII VIII IX
        String[] roman={"I","V","X","L","C","D","M"};
        String answer="";
        int wei=0;
        while (num>0){
            int l=num%10;
            if(l<4){
                for (int i = 0; i < l; i++) {
                    answer=roman[wei]+answer;
                }
            }else if (l<5){
                answer=roman[wei]+roman[wei+1]+answer;
            }else if (l<9){
                for (int i = 0; i < l-5; i++) {
                    answer=roman[wei]+answer;
                }
                answer=roman[wei+1]+answer;
            }else {
                answer=roman[wei]+roman[wei+2]+answer;
            }
            wei+=2;
            num/=10;
        }
        return answer;
    }
    public String numberToWords(int num) {//273. Integer to English Words
        String[] a0_9={"","One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine "};
        String[] a10_19={"Ten ","Eleven ","Twelve ","Thirteen ","Fourteen ","Fifteen ","Sixteen ","Seventeen ","Eighteen ","Nineteen "};
        String[] a20_90={"","","Twenty ","Thirty ","Forty ","Fifty ","Sixty ","Seventy ","Eighty ","Ninety "};
        String[] a100={"","Thousand ","Million ","Billion ","Trillion "};
        String[] aelse={"Zero","Hundred "};
        String answer="";
        if(num==0){
            return aelse[0];
        }
        int l0=0;   //千位
        while (num>0) {
            int l3 = num % 10;//个位
            int l2 = 0;//十位
            int l1 = 0;//百位
            if (num > 9) {
                l2 = num / 10 % 10;
                if (num > 99)
                    l1 = num / 100 % 10;
            }
            if (l1 != 0 || l2 != 0 || l3 != 0) {
                answer = a100[l0] + answer;
                if (l2 == 1) {
                    answer = a10_19[l3] + answer;
                } else {
                    answer = a20_90[l2] + a0_9[l3] + answer;
                }
                if (l1!=0) {
                    answer = a0_9[l1] + aelse[1] + answer;
                }
            }
            num /= 1000;
            l0++;
        }
        answer = answer.substring(0, answer.length()-1);
        return answer;
    }
    public int maxArea(int[] height) {//11. Container With Most Water
        int t=0;
        int max=0;
        int x0=0;
        int x1=height.length-1;
        while (x0!=x1){
            t=(x1-x0)*Math.min(height[x0],height[x1]);
            max=max>t?max:t;
            if (height[x0]>height[x1])
                x1--;
            else
                x0++;
        }
        return max;
    }
}
/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-10-05
 * Time: 下午5:57
 */
import java.util.Arrays;
import java.util.*;


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
                char ca = sa[sa.length - 1 - i].charAt(0);
                char cb = sb[sb.length - 1 - j].charAt(0);
                int sum = (ca - 48) * (cb - 48);
                answer[answer.length - i - j - 1] += (sum);
            }
        }
        for (int i = answer.length - 1; i > 0; i--) {
            while (answer[i] > 9) {
                answer[i - 1] += answer[i] / 10;
                answer[i] %= 10;
            }
        }
        String answer1 = "";
        for (int i = answer.length - 1; i >= 0; i--) {
            answer1 = answer[i] + answer1;
        }
        while (answer1.charAt(0) == '0') {
            answer1 = answer1.substring(1, answer1.length());
        }
        return answer1;
    }
    
    public String intToRoman(int num) {//12. Integer to Roman
        //Ⅰ（1）、X（10）、C（100）、M（1000）
        //V（5）、L（50）、D（500）
        // 0-4     I  II  III IV
        //5-9   V VI VII VIII IX
        String[] roman = {"I", "V", "X", "L", "C", "D", "M"};
        String answer = "";
        int wei = 0;
        while (num > 0) {
            int l = num % 10;
            if (l < 4) {
                for (int i = 0; i < l; i++) {
                    answer = roman[wei] + answer;
                }
            } else if (l < 5) {
                answer = roman[wei] + roman[wei + 1] + answer;
            } else if (l < 9) {
                for (int i = 0; i < l - 5; i++) {
                    answer = roman[wei] + answer;
                }
                answer = roman[wei + 1] + answer;
            } else {
                answer = roman[wei] + roman[wei + 2] + answer;
            }
            wei += 2;
            num /= 10;
        }
        return answer;
    }
    
    public String numberToWords(int num) {//273. Integer to English Words
        String[] a0_9 = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine "};
        String[] a10_19 = {"Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
        String[] a20_90 = {"", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
        String[] a100 = {"", "Thousand ", "Million ", "Billion ", "Trillion "};
        String[] aelse = {"Zero", "Hundred "};
        String answer = "";
        if (num == 0) {
            return aelse[0];
        }
        int l0 = 0;   //千位
        while (num > 0) {
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
                if (l1 != 0) {
                    answer = a0_9[l1] + aelse[1] + answer;
                }
            }
            num /= 1000;
            l0++;
        }
        answer = answer.substring(0, answer.length() - 1);
        return answer;
    }
    
    public int maxArea(int[] height) {//11. Container With Most Water
        int t = 0;
        int max = 0;
        int x0 = 0;
        int x1 = height.length - 1;
        while (x0 != x1) {
            t = (x1 - x0) * Math.min(height[x0], height[x1]);
            max = max > t ? max : t;
            if (height[x0] > height[x1])
                x1--;
            else
                x0++;
        }
        return max;
    }
    
    public List<String> letterCombinations(String digits) {//17. Letter Combinations of a Phone Number
        String[] table = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> list = new ArrayList<String>();
        if (digits.equals(""))
            return list;
        list.add("");
        while (digits.length() > 0) {
            List<String> list1 = new ArrayList<String>();
            int x = digits.charAt(0) - 48;
            for (int j = 0; j < list.size(); j++) {
                for (int i = 0; i < table[x].length(); i++) {
                    String y = list.get(j) + String.valueOf(table[x].charAt(i));
                    list1.add(y);
                }
            }
            list = list1;
            digits = digits.substring(1, digits.length());
        }
        return list;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {//19. Remove Nth Node From End of List
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        if (list.size() < 2 || list.size() < n) {
            return null;
        }
        list.remove(list.size() - n);
        
        ListNode answer = new ListNode(list.get(0));
        ListNode pointer = answer;
        int x = list.size();
        for (int i = 1; i < x; i++) {
            pointer.next = new ListNode(list.get(i));
            pointer = pointer.next;
        }
        return answer;
    }
    
    public ListNode swapPairs(ListNode head) {//24. Swap Nodes in Pairs
        ListNode list = null;
        
        if (head == null)
            return null;
        if (head != null && head.next == null) {
            list = new ListNode(head.val);
        } else if (head.next != null) {
            list = new ListNode(head.next.val);
            list.next = new ListNode(head.val);
            ListNode pointer = list.next;
            if (head.next.next != null) {
                head = head.next.next;
                while (head.next != null) {
                    pointer.next = new ListNode(head.next.val);
                    pointer.next.next = new ListNode(head.val);
                    pointer = pointer.next.next;
                    if (head.next.next == null) {
                        break;
                    }
                    head = head.next.next;
    
                }
                if (head != null && head.next == null) {
                    pointer.next = new ListNode(head.val);
//                    pointer = pointer.next;
                }
            }
        }
        return list;
    }
    
    public int strStr(String haystack, String needle) {//28. Implement strStr()
        if (haystack.length() < needle.length())
            return -1;
        if (haystack.length() == 0 || needle.length() == 0) {
            return 0;
        }
        int answer = -1;
        int length = 0;
        l1:
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0) && (haystack.length() - i) >= needle.length()) {
                answer = i;
                l2:
                for (int j = 0; j < needle.length(); j++) {
                    length++;
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        answer = -1;
                        length = 0;
                        break l2;
                    }
                }
                if (length == needle.length()) {
                    break l1;
                }
            }
        }
        return answer;
    }
    
    int divide(int dividend, int divisor) {//29. Divide Two Integers
//        return divide1(dividend,divisor);//抄
        return divide2(dividend, divisor);//抄
    }
    
    int divide1(int dividend, int divisor) {
        int flag = 0;
        if (dividend < 0 && divisor < 0) flag = 1;
        else if (dividend > 0 && divisor > 0) flag = 1;
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long answer = 0;
        while (a >= b) {
            long c = b;
            for (int i = 0; a >= c; i++, c <<= 1) {
//                System.out.println("1-1 a="+dividend+" ,b="+divisor+" ,c=\"+c+\", i="+i+" ,answer="+answer);
                a -= c;
                answer += 1 << i;
//                System.out.println("1-2 a="+dividend+" ,b="+divisor+" ,c=\"+c+\", i="+i+" ,answer="+answer);
            }
        }
        answer = flag == 1 ? answer : -answer;
        if (answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int) answer;
    }
    
    int divide2(int dividend, int divisor) {
        int flag = 0;
        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) flag = 1;
        long a = Math.abs((long) dividend), b = Math.abs((long) divisor), answer = 0;
        long[] map = new long[33], times = new long[33];
        map[0] = b;
        times[0] = 1;
        int j = 0;
        for (int i = 1; a > map[i - 1]; i++) {
            map[i] = map[i - 1] + map[i - 1];
            times[i] = times[i - 1] + times[i - 1];
            j = i;
        }
        for (int i = j; i >= 0; i--) {
            while (a >= map[i]) {
                a -= map[i];
                answer += times[i];
            }
        }
        answer = flag == 1 ? answer : -answer;
        if (answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int) answer;
    }
    
    public void nextPermutation(int[] nums) {//31. Next Permutation
        /**
         * 从末位开始找与最近的比它小的数交换，并排序交换数后面的数
         * 1.找到最近的比它小的数,如果没找到比它小的，找上一位的最近的比它小的数（在这些中找到比它小最靠右的，比它小一样时，找交换位靠右的)
         * 2.交换两个数的位置
         * 3.排序交换位置后面的数
         */
        //1
        int now = 0;//交换的位置
        int min = 0;//比它小的位置
        int c = Integer.MAX_VALUE;//差值;
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
//                System.out.println("----------1----------");
//                System.out.println("i = " + i + " " + nums[i]);
//                System.out.println("j = " + j + " " + nums[j]);
                if (nums[i] > nums[j]) {
//                    System.out.println("----------2----------");
//                    System.out.println("i = " + i + " " + nums[i]);
//                    System.out.println("j = " + j + " " + nums[j]);
                    int now1 = i;
                    int min1 = j;
//                    System.out.println("min = " + min + " min1 = " + min1);
//                    System.out.println("now = " + now + " now1 = " + now1);
                    if ((min1 > min) || (min1 == min && now1 > now)) {
//                        System.out.println("----------3----------");
//                        System.out.println("i = " + i + " " + nums[i]);
//                        System.out.println("j = " + j + " " + nums[j]);
                        now = now1;
                        min = min1;
                    }
                }
            }
        }
        //2
        int temporary = nums[now];
        nums[now] = nums[min];
        nums[min] = temporary;
        //3
        Arrays.sort(nums, min + 1, nums.length);
        if (min == 0 && now == 0)
            Arrays.sort(nums);
        return;
    }
    
    public int longestValidParentheses(String s) {//32. Longest Valid Parentheses
//        Stack<Integer> paranStack=new Stack<Integer>();
//        int paranStack1=0;
//        int maxLength=0;
//        int lastValidIndx=0;
//        int lastValidIndx1=0;
//
//        for (int indx=0; indx<s.length(); indx++) {
//            if (s.charAt(indx)=='(') //遇到左括号，直接存入。
//                paranStack.push(indx);
////                paranStack1++;
//            else { //遇到右括号，分情况讨论
//                if (paranStack1 == 0) //如果此时栈里左括号已经被消耗完了，没有额外的左括号用来配对当前的右括号了，那么当前的右括号就被单出来了，表明当前子串可以结束了，此时的右括号也成为了下一个group的分界点，此时右括号下标为index，所以下一个group的起始点为index+1,相当于skip掉当前的右括号。
//                    lastValidIndx = indx + 1;
//                else { //如果此时栈不空，可能有两种情况，1）栈正好剩下1个左括号和当前右括号配对 2)栈剩下不止1个左括号，
//                    paranStack.pop();
////                    paranStack1 -= 1;
//                    if (paranStack1 == 0) { //栈pop()之前正好剩下1个左括号，pop()之后，栈空了，此时group长度为indx-lastValidIndx
//                        maxLength=max(maxLength, indx-lastValidIndx+1);
////                        maxLength = maxLength > (indx - lastValidIndx + 1) ? maxLength : (indx - lastValidIndx + 1);
////                        lastValidIndx1=indx+1;
//                    }else {  //栈有pop()之前剩下不止1个左括号，此时额外多出的左括号使得新的group形成。如()(()())中index=4时，stack中有2个左括号
//                        maxLength=max(maxLength, indx-paranStack.top());
////                        maxLength = maxLength > (indx - lastValidIndx-lastValidIndx1 - paranStack1 + 1) ? maxLength : (indx - lastValidIndx-lastValidIndx1 - paranStack1 + 1);
////                        paranStack1-=1;
//                    }
//                }
//            }
//        }
//        return maxLength;
        Stack<Integer> paranStack = new Stack<Integer>();
        int maxLength = 0;
        int lastValidIndx = 0;
        for (int indx = 0; indx < s.length(); indx++) {
            if (s.charAt(indx) == '(') //遇到左括号，直接存入。
                paranStack.push(indx);
            else { //遇到右括号，分情况讨论
                if (paranStack.empty()) //如果此时栈里左括号已经被消耗完了，没有额外的左括号用来配对当前的右括号了，那么当前的右括号就被单出来了，表明当前子串可以结束了，此时的右括号也成为了下一个group的分界点，此时右括号下标为index，所以下一个group的起始点为index+1,相当于skip掉当前的右括号。
                    lastValidIndx = indx + 1;
                else { //如果此时栈不空，可能有两种情况，1）栈正好剩下1个左括号和当前右括号配对 2)栈剩下不止1个左括号，
                    paranStack.pop();
                    if (paranStack.empty())  //栈pop()之前正好剩下1个左括号，pop()之后，栈空了，此时group长度为indx-lastValidIndx
//                            maxLength=max(maxLength, indx-lastValidIndx+1);
                        maxLength = maxLength > (indx - lastValidIndx + 1) ? maxLength : (indx - lastValidIndx + 1);
                    else  //栈有pop()之前剩下不止1个左括号，此时额外多出的左括号使得新的group形成。如()(()())中index=4时，stack中有2个左括号
//                            maxLength=max(maxLength, indx-paranStack.top());
                        maxLength = maxLength > (indx - paranStack.peek()) ? maxLength : (indx - paranStack.peek());
    
                }
            }
        }
        return maxLength;
    }
    
    public List<Integer> spiralOrder(int[][] matrix) {//54. Spiral Matrix
        int xMIN = 0;
        int xMAX = matrix[0].length - 1;
        int yMIN = 0;
        int yMAX = matrix.length - 1;
        int num=0;
        List<Integer> list = new ArrayList<Integer>();
        while ((xMIN <= xMAX) && (yMIN <= yMAX)) {
            switch (num){
                case 0:
                    for (int i = xMIN; i <= xMAX; i++) {//上
                        list.add(matrix[xMIN][i]);
                    }
                    yMIN++;
                    num=1;
                    break;
                case 1:
                    for (int i = yMIN; i <= yMAX; i++) {//右
                        list.add(matrix[i][yMAX]);
                    }
                    xMAX--;
                    num=2;
                    break;
                case 2:
                    for (int i = xMAX; i >= xMIN; i--) {//下
                        list.add(matrix[xMAX + 1][i]);
                    }
                    yMAX--;
                    num=3;
                    break;
                case 3:
                    for (int i = yMAX; i >= yMIN; i--) {//左
                        list.add(matrix[i][yMIN - 1]);
                    }
                    xMIN++;
                    num=0;
                    break;
            }
        }
        return list;
    }
    public boolean canJump(int[] nums) {//39. Jump Game
        int max=0;
        for (int i = 0; i <= max; i++) {
            if (nums[i]+i>max)
                max=nums[i]+i;
            if (max>=nums.length-1){
                return true;
            }
        }
        return false;
    }
    public List<Interval> merge(List<Interval> intervals) {//56. Merge Intervals
        boolean x=true;
        for (int i = 0; i < intervals.size()-1;) {
            for (int j = i+1; j < intervals.size(); j++) {
                int x1=intervals.get(i).start;
                int x2=intervals.get(j).start;
                int y1=intervals.get(i).end;
                int y2=intervals.get(j).end;
                if (((x1<=x2)&& (x2<=y1)) ||((x2<=x1)&& (x1<=y2))) {
                    intervals.get(i).start=x1<x2?x1:x2;
                    intervals.get(i).end=y1>y2?y1:y2;
                    intervals.remove(j);
                    j--;
                    x=false;
                }
            }
            if (x){
                i++;
            }
            x=true;
        }
        return intervals;
    }
    public int searchInsert(int[] nums, int target) {//35. Search Insert Position
        if (target<=nums[0])
            return 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]>=target)
                return i;
        }
        return nums.length;
    }
    public boolean isValidSudoku(char[][] board) {//36. Valid Sudoku
        if (board.length!=9)
            return false;
        for (int i = 0; i < board[i].length-1; i++) {
            if (board[i].length!=9)
                return false;
        }
        for (int i = 0; i < board.length; i++) {
            int[] z1=new int[9];
            int[] z2=new int[9];
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j]>'0'&&board[i][j]<='9'){
                    int x=board[i][j]-'0'-1;
                    if (z1[x]==0){
                        z1[x]=1;
                    }else return false;
                }else if (board[i][j]!='.'){
                    return false;
                }
                if (board[j][i]>'0'&&board[j][i]<='9'){
                    int x=board[j][i]-'0'-1;
                    if (z2[x]==0){
                        z2[x]=1;
                    }else return false;
                }else if (board[j][i]!='.'){
                    return false;
                }
            }
//            System.out.println(z1[0]+" "+z1[1]+" "+z1[2]+" "+z1[3]+" "+z1[4]+" "+z1[5]+" "+z1[6]+" "+z1[7]+" "+z1[8]);
//            System.out.println(z2[0]+" "+z2[1]+" "+z2[2]+" "+z2[3]+" "+z2[4]+" "+z2[5]+" "+z2[6]+" "+z2[7]+" "+z2[8]);
        }
        for (int i = 0; i < board.length; i+=3) {
            for (int j = 0; j < board[i].length; j+=3) {
                int[] z3=new int[9];
                for (int k = i; k < i+3; k++) {
                    for (int l = j; l < j+3; l++) {
//                        System.out.println(i+" "+j+" "+k+" "+l);
                        if (board[k][l]>'0'&&board[k][l]<='9'){
                            int x=board[k][l]-'0'-1;
                            if (z3[x]==0){
                                z3[x]=1;
                            }else return false;
                        }else if (board[k][l]!='.'){
                            return false;
                        }

                    }
                }
//                System.out.println(z3[0]+" "+z3[1]+" "+z3[2]+" "+z3[3]+" "+z3[4]+" "+z3[5]+" "+z3[6]+" "+z3[7]+" "+z3[8]);
            }
        }
        return true;
    }
}

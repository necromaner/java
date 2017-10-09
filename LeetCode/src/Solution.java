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
    
    public int myAtoi(String str) {
        int answer = 0;
        String answer1 = "";
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
                    if(i+1>=str.length()){
                        break;
                    }
                    i++;
                }
                symbolSwitch = false;
            }
            if (str.charAt(i) >= '0'&&str.charAt(i) <= '9') {
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
            }catch (NumberFormatException e){
                return 0;
            }
        } else
            return 0;
    }
}
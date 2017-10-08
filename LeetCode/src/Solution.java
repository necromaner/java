/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-10-05
 * Time: 下午5:57
 */
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
    
    public String longestPalindrome(String s) {
        /*
        1.以i为中心
        2.判断i后面一样的字符，中心点为middle
         */
//        System.out.println("s长度 "+s.length());
        String maxString ="";
        if(s.length()>1000){
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
                    System.out.println("s.charAt(i) != s.charAt(j)   "+s.charAt(i)+" "+s.charAt(j)+" "+i+" "+j);
                    break lableA;
                }
                heart++;
                System.out.println("--中心一样的数量heart = " + heart);
            }
            if (heart % 2 == 0) {
                middle += heart / 2 - 0.5;
                System.out.println("1中心点middle = " + middle);
            } else {
                middle += heart-1;
                System.out.println("2中心点middle = " + middle);
            }
            i += heart-1;
            System.out.println("i = " + i);
            int min = (int) (middle - heart / 2 + 0.5);
            int max = (int) (middle + heart / 2 );
            System.out.println("min = " + min);
            System.out.println("max = " + max);
            lableC:
            while (min > 0 && max < s.length() - 1) {
                if (s.charAt(min - 1) != s.charAt(max + 1)) {//cbbbd
                    break lableC;
                }
                min--;
                max++;
                heart+=2;
                System.out.println("--min = " + min);
                System.out.println("--max = " + max);
                System.out.println("--heart = "+heart);
            }
            System.out.println("maxLong = "+maxLong);
            System.out.println("heart = "+heart);
//            if (maxLong < heart) {
//                maxLong = heart;
//                maxString = "";
//                for (int j = min; j <= max; j++) {
//                    maxString += s.charAt(j);
//                }
//                System.out.println("maxString = "+maxString);
//            }
            System.out.println("--------------------------");
        }
        return maxString;
    }
}

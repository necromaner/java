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
        String maxString="";
        if(s.length()==0){
            return maxString;
        }
        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i+1; j < s.length(); j++) {
                
            }
        }
        return maxString;
    }
}

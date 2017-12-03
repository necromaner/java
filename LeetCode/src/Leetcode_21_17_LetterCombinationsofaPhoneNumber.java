import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-11-26
 * Time: 上午10:07
 */
/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

1       2(abc)  3(def)
4(ghi)  5(jkl)  6(mno)
7(pqrs) 8(tuv)  9(wxyz)
*       0       #

For example:

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].


 */
public class Leetcode_21_17_LetterCombinationsofaPhoneNumber {//完成
    public static void main(String[] args) {
        Solution solution = new Solution();
        String digits="234";
        List<String> letterCombinations=solution.letterCombinations(digits);
        System.out.println(  "digits  is  = "+digits);
        System.out.print("letterCombinations  = ");
        for (int i = 0; i < letterCombinations.size(); i++) {
            System.out.print(letterCombinations.get(i)+" ");
        }
        System.out.println("");
    }
}

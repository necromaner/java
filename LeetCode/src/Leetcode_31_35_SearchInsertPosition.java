/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-03-02
 *
 * @Description: java类作用描述
 * Time: 下午8:51
 */
/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2

Example 2:

Input: [1,3,5,6], 2
Output: 1

Example 3:

Input: [1,3,5,6], 7
Output: 4

Example 1:

Input: [1,3,5,6], 0
Output: 0

 */
public class Leetcode_31_35_SearchInsertPosition {//完成
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={1,3,5,6};
        int target=0;
        System.out.print("Input : [");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i<nums.length-1)
                System.out.print(",");
        }
        System.out.println("], "+target);
        System.out.println("Output: "+solution.searchInsert(nums,target));
    }
}

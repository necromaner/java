/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-03-02
 *
 * @Description: java类作用描述
 * Time: 下午2:41
 */
/*
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
 */
public class Leetcode_29_39_JumpGame {//完成
    public static void main(String[] args) {
        int[] nums={2,3,1,1,4};
        Solution solution=new Solution();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i<nums.length-1){
                System.out.print(",");
            }
        }
        System.out.println("");
        System.out.println("return: "+solution.canJump(nums));
    }
}

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-10-08
 * Time: 下午7:27
 */
public class Leetcode_5_4_MedianofTwoSortedArrays {//完成
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums1 ={1,3};
        int[] nums2 = {2};
        System.out.println("The median is "+solution.findMedianSortedArrays(nums1,nums2));
    }
}

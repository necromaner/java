/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-08-25
 *
 * @Description: java类作用描述
 * Time: 下午2:40
 */
/*
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。

示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。


 */
public class Leetcode_34_66_PlusOne {//完成
    public static void main(String[] args) {
        Solution solution=new Solution();
        Output output=new Output();
        int[] digits={9,9,9};
        
        System.out.println("Input :"+output.oneArrary(digits));
        System.out.println("Output :"+output.oneArrary(solution.plusOne(digits)));
    }
}

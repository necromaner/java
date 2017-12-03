/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-12-03
 * Time: 下午10:37
 */
public class Leetcode_26_31_NextPermutation {//完成
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] num={3,2,1};
        System.out.print("now  = ");
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]+" ");
        }
        System.out.println("");
        solution.nextPermutation(num);
    
        System.out.print("next = ");
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]+" ");
        }
        System.out.println("");
    }
}

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-11-25
 * Time: 下午11:56
 */
public class Leetcode_20_11_ContainerWithMostWater {//完成
    public static void main(String[] args) {
        Solution solution = new Solution();
        int height[]={1,2,3,4,5};
        int maxArea=solution.maxArea(height);
        System.out.print(  "num  is  = ");
        for (int i = 0; i < height.length; i++) {
            System.out.print(height[i]+" ");
        }
        System.out.println("");
        System.out.println("maxArea  = "+maxArea);
    }
}

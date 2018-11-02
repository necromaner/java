/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-08-25
 *
 * @Description: java类作用描述
 * Time: 下午4:01
 */
/*
实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2

示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842...,
     由于返回类型是整数，小数部分将被舍去。


 */
public class Leetcode_36_69_Sqrt_x {
    public static void main(String[] args) {
        Solution36 solution36=new Solution36();
        int x=1;
        System.out.println("input :"+x);
        System.out.println("output :"+solution36.mySqrt(x));
    }
}
class Solution36 {
    public int mySqrt(int x) {
//        if (x<2)
//            return x;
        int low=0;
        int high=(x<46341)?x+1:46341;
        int mid=0;
        while (mid<=high&&mid>=low){
            if(mid==low+(high-low)/2){
                return mid;
            }
            mid=low+(high-low)/2;
            int sqrt=mid*mid;
            if (sqrt==x)
                return mid;
            else if (sqrt>x)
                high=mid;
            else
                low=mid;
        }
        return mid;
    }
    
    public int mySqrt1(int x) {//完成
        int i;
        for (i = 0; i <= x; i++) {
            if ((i*i) > (x-i-i-1))
                break;
        }
        return i;
    }
}
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-02-16
 *
 * @Description: java类作用描述
 * Time: 下午8:07
 */
/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

You should return [1,2,3,6,9,8,7,4,5].
 */
public class Leetcode_28_54_SpiralMatrix {//超时
    public static void main(String[] args) {
//        int[][] matrix={{1, 2, 3, 4},
//                {5, 6, 7, 8},
//                {9,10,11,12}};
        int[][] matrix={{1,2,3},
                        {4,5,6},
                        {7,8,9}};
        Solution solution=new Solution();
        System.out.println(solution.spiralOrder(matrix));
    }
}

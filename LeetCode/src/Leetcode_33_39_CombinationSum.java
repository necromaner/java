import java.util.List;

/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-03-21
 *
 * @Description: java类作用描述
 * Time: 下午6:11
 */
/*
 Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

For example, given candidate set [2, 3, 6, 7] and target 7,
A solution set is:

[
  [7],
  [2, 2, 3]
]

 */
public class Leetcode_33_39_CombinationSum {
    public static void main(String[] args) {
        int[] candidates={7,3,6,2,3,6,7,100};
        int target=7;
        System.out.print("given candidate set [");
        for (int i = 0; i < candidates.length; i++) {
            System.out.print(candidates[i]);
            if (i+1!=candidates.length)
                System.out.print(",");
        }
        System.out.println("] and target "+target);
        Solution solution=new Solution();
        List<List<Integer>> answer=solution.combinationSum(candidates,target);
        System.out.println("A solution set is: ");
        for (int i = 0; i < answer.size(); i++) {
            for (int j = 0; j < answer.get(i).size(); j++) {
                System.out.print(answer.get(i).get(j)+" ");
            }
            System.out.println("");
        }
    }
}

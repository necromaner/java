import java.util.ArrayList;
import java.util.List;

/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-03-02
 *
 * @Description: java类作用描述
 * Time: 下午3:22
 */
public class Leetcode_30_56_MergeIntervals {//完成
    public static void main(String[] args) {
        Solution solution=new Solution();
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));
        intervals.add(new Interval(15,10));
//        intervals.add(new Interval(2,3));
//        intervals.add(new Interval(4,5));
//        intervals.add(new Interval(6,7));
//        intervals.add(new Interval(8,9));
//        intervals.add(new Interval(1,10));
        System.out.print("Given  ");
        for (int i = 0; i < intervals.size(); i++) {
            System.out.print("["+intervals.get(i).start+","+intervals.get(i).end+"]");
            if (i<intervals.size()-1)
                System.out.print(",");
        }
        System.out.println("");
        solution.merge(intervals);
        System.out.print("return ");
        for (int i = 0; i < intervals.size(); i++) {
            System.out.print("["+intervals.get(i).start+","+intervals.get(i).end+"]");
            if (i<intervals.size()-1)
                System.out.print(",");
        }
        System.out.println("");
    }
}

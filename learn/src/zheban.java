/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-12-26
 * Time: 下午3:10
 */
public class zheban {
    public static void main(String[] args) {
        int[] x1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] x2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int y = 3;
        System.out.println(zheban(x2, y));
        System.out.println(zheban1(x2, y, 0, x2.length));
    }
    
    public static int zheban(int[] x, int y) {
        int from = 0;
        int to = x.length;
        while (from <= to) {
            if (x[(to + from) / 2] == y)
                return (to + from) / 2;
            else if (x[(to + from) / 2] < y)
                from = (from + to) / 2;
            else
                to = (from + to) / 2;
        }
        return -1;
    }
    
    public static int zheban1(int[] x, int y, int from, int to) {
        if (from < to) {
            if (x[(to + from) / 2] == y)
                return (to + from) / 2;
            else if (x[(to + from) / 2] < y)
                zheban1(x, y, (from + to) / 2, to);
            else //if (x[(to + from) / 2] > y)
                zheban1(x, y, from, (from + to) / 2);
        }
        return -1;
    }
}

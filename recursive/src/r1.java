/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-10-14
 * Time: 下午3:51
 */
public class r1 {
    public int R1(int x) {
        if (x <= 2)
            if (x == 1 || x == 2) {
                return 1;
            } else
                return 0;
        return R1(x - 1) + R1(x - 2);
    }
    
    public int[] R2(int x) {
        int x2 = R21(x, 0);
        int[] x1 = new int[x2];
        x1 = R22(x, x1, x2 - 1);
        return x1;
    }
    
    private int R21(int x, int y) {
        if (x >= 10) {
            return R21(x / 10, y + 1);
        }
        return y + 1;
    }
    
    private int[] R22(int x, int[] y, int i) {
        if (x < 1) {
            return y;
        }
        y[y.length - i - 1] = x % 10;
        return R22(x / 10, y, i - 1);
    }
    
    public boolean R3(String x3, int min, int max) {
        if (min < max && x3.charAt(min) == x3.charAt(max)) {
            return R3(x3, min + 1, max - 1);
        } else if (min >= max) return true;
        return false;
    }
    
    public int[] R4(int x4,int longs){
        for (int i = 2; i < x4/2; i++) {
        
        }
    }
}

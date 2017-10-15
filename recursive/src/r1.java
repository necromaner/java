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
    public int[] R2(int x){
        int x2=R21(x,0);
        int[] x1=new int[x2];
        x1=R22(x,x1,x2);
        return x1;
    }
    private int R21(int x,int y){
        if (x>=10){
            return R21(x/10,y+1);
        }
        return y+1;
    }
    private int[] R22(int x,int[] y,int i){
    
    }
}

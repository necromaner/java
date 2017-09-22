/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-22
 * Time: 下午3:32
 */
public class text8_6 {
    int[] a=null;
    int[] b=null;
    public int Manhattan(){
        int c;
        int d;
        if (a[0]>b[0]) {
            c = a[0] - b[0];
        }else
            c = b[0]-a[0]  ;
        if (a[1]>b[1]) {
            d = a[1] - b[1];
        }else
            d = b[1]-a[1]  ;
        return c+d;
    }
}

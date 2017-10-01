/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-25
 * Time: 下午8:05
 */
public class text14_2 {
    public int[] aaa(String s8){
        String[] fenge = s8.split(",");
        int[] a=new int[fenge.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(fenge[i]);
            //a[i] = Integer.valueOf( fenge[i] );
        }
        return a;
    }
}

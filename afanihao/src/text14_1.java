/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-25
 * Time: 下午7:54
 */
public class text14_1 {
    public static String join(int[] arr){
        String aa="";
        for (int i = 0; i < arr.length; i++) {
            aa+=arr[i];
            if(i!=arr.length-1)
                aa+=",";
        }
        return aa;
    }
}

/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-08-25
 *
 * @Description: java类作用描述
 * Time: 下午2:55
 */
public class Output {
    public String oneArrary(int[] arrary){
        String output="[";
        for (int i = 0; i < arrary.length; i++) {
            output+=arrary[i];
            if(i+1<arrary.length)
                output+=",";
        }
        output+="]";
        return output;
    }
}

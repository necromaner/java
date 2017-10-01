/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-25
 * Time: 上午11:50
 */
public class text13_1 {

    public int[] data = new int[16];
    
    public text13_1() {
        for (int i = 0; i < data.length; i++) {
            data[i] = -1;
        }
    }
    
    // 取最大值
//    public int getMax()
    public static int getMax(int[] data) {//静态方法不能直接调用非静态变量，可以通过创建类的对象，然后通过对象来访问非静态变量
        int max = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }
    public String toString() {
        return "最大值为 ：";
    }
}

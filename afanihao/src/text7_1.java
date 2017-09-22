/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-21
 * Time: 下午6:12
 */
public class text7_1 {
    public void out() {
        System.out.println(
                "***************************\n" +
                        "***** Java学习指南        **\n" +
                        "***************************");
    }
    
    public double product(double a, double b, double c) {
        return a * b * c;
    }
    
    public double square(double a) {
        return a * a;
    }
    
    public int AbsoluteValue(int a) {
        if (a >= 0)
            return a;
        else
            return -a;
    }
    
    public int sum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++)
            sum += a[i];
        return sum;
    }
    
    public int towsum(int[] a, int[] b) {
        int sum = 0;
        for (int i = 0; i < a.length; i++)
            sum += a[i];
        for (int i = 0; i < b.length; i++)
            sum += b[i];
        return sum;
    }
    
    public int min(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min > a[i])
                min = a[i];
        }
        return min;
    }
    
    public void PerfectSquare() {
        double[] a = null;
        for (int i = 100; i <= 999; i++) {
            if (Math.sqrt(i) % 2 == 0) {
                int j = i;
                System.out.print(j + " ");
            }
        }
    }
    
    public double Fahrenheit(double a) {
        return a * 9 / 5 + 32;
    }
    
    public int[] volume(double[] audio, double noisy_point) {
        int[] result=new int[audio.length];
        for (int i=0;i<audio.length;i++) {
            if (audio[i] > noisy_point)
                audio[i] = noisy_point;
            result[i]= (int) (audio[i]*65535);
        }
        return result;
    }
}

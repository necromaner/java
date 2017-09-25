/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-25
 * Time: 上午11:36
 */
public class text11_9 {
    public double a;
    public double b;
    public double c;
    
    public text11_9() {
    }
    
    public text11_9(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public String toString() {
        return "三解形(" + a + "," + b + "," + c + ")";
    }
}

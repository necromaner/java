/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-24
 * Time: 下午4:20
 */
public class text11_6 extends text11_5 {
    
    public text11_6()
    {
    }
    public text11_6(double a,double b){
        super(a,b,0);
        this.c = Math.sqrt( a*a + b*b);
    }
    public text11_6(double a, double b, double c)
    {
        super(a,b,c);
    }
    public double area()
    {
        return a * b / 2;
    }
    
}

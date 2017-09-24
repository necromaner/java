import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-22
 * Time: 下午5:06
 */
public class text10_2 {
    public double radius;
    public double x;
    public double y;
    
    public text10_2(){
    }
    public text10_2(double radius){
        this.radius=radius;
    }
    public text10_2(double radius,double x,double y) {
        this.radius = radius;
        this.x = x;
        this.y = y;
    }
    public text10_2 ( double radius ,text10_3 p)
    {
        this.x = p.x;
        this.y = p.y;
        this.radius = radius;
    }
    
}

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-22
 * Time: 上午10:04
 */
public class text8_2 {
    public double r=0;
    public final double PI = 3.1415; // final表示常量，其语法见2.4补充教程
    public double perimeter(){
        return 2*this.r*Math.PI;
    }
    public double area(){
        return Math.PI*this.r*this.r;
    }
}

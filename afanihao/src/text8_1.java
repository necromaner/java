/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-22
 * Time: 上午9:44
 */
public class text8_1 {
    public double a=0;
    public double b=0;
    public double c=0;
    public double perimeter(){
        if(this.a+this.b<this.c||this.b+this.c<this.a||this.a+this.c<this.b||this.a<=0||this.b<=0||this.c<=0)
            return -1;
        return this.a+this.b+this.c;
    }
}

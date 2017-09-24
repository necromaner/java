/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-24
 * Time: 下午4:14
 */
public class text11_5 {
        public double a ;
        public double b ;
        public double c ;
	
	public text11_5()
        {
        }
	public text11_5 (double a, double b , double c )
        {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        // 求面积
    public double area()
    {
        double p = (a+b+c)/2;
        double S = Math.sqrt( p * (p-a) * (p-b) * (p-c));
        return S;
    }
}

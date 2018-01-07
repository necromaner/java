/**
 * Description:
 * User: necromaner
 * Date: 2018-01-07
 * Time: 下午2:06
 */
class A{
    public void print(){
        System.out.println("A");
    }
}
class B extends A{
    public void print(){
        System.out.println("B");
    }
}
public class test {
    public static void main(String[] args) {
        A a=new B();
        a.print();
        System.out.println(a instanceof A);
        System.out.println(a instanceof B);
        if (a instanceof B){
            B b=(B)a;
            b.print();
        }
    }
}

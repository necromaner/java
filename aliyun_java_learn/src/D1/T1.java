package D1;

/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-08-25
 *
 * @Description: java类作用描述
 * Time: 上午9:28
 */
abstract class A{
    private String msg="123";
    public void print(){//普通方法
        System.out.println(msg);
    }
    public static A getInstance(){//内部类
        class C extends A{
            public void fun() {
                System.out.println("ccc");
            }
        }
        return new C();
    }
    //{}为方法体，所有抽象方法上是不包含有方法体的
    public abstract void fun();//抽象方法
}
class B extends A{
    public void fun() {
        System.out.println("hello");
    }
}
public class T1 {
    public static void main(String[] args) {
        A a=new B();
        A a1=A.getInstance();
        a.fun();
        a.print();
        a1.fun();
    }
}

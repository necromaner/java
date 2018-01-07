package chouxianglei;

import sun.jvm.hotspot.HelloWorld;

/**
 * Description:
 * User: necromaner
 * Date: 2018-01-07
 * Time: 下午2:37
 */
abstract class A{
    private String msg="qwe";//属性
    public void print(){//普通方法
        System.out.println(msg);
    }
    //{}为方法体，所有抽象方法上是不包含有方法体的。
    public abstract void fun();//抽象方法
    public static A getInstance(){//取得A类对象
        class B extends A{//定义抽象类子类（内部类）
            public void fun() {
                System.out.println("B1");
            }
        }
        return new B();
    }
}
//一个子类只能用extends来继承抽象类，所有依然存在有单继承局限
abstract class B extends A{//定义抽象类的子类
    public void fun(){
        System.out.println("B");
    }
}
class C extends A{
    @Override
    public void fun() {
        System.out.println("C");
    }
}
public class test1 {
    public static void main(String[] args) {
        A a=new A() {
            @Override
            public void fun() {
                System.out.println("A");
            }
        };
        a.fun();
        A a1=new B() {//实例化子类对象
            @Override
            public void fun() {
                super.fun();
            }
        };
        a1.fun();
        A a2=new C();
        a2.fun();
        A a3=A.getInstance();
        a3.fun();
    }
}

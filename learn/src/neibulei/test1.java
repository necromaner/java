package neibulei;

/**
 * Description:
 * User: necromaner
 * Date: 2017-12-29
 * Time: 下午5:28
 */
class Outer {//定义一个外部类
    private String msg = "Hello World !";
    
    //    private class Inner{//定义一个内部类
    class Inner {//定义一个内部类
        
        public void print() {//定义一个普通方法
            System.out.println(msg);//调用msg属性
            System.out.println(Outer.this.msg);//调用msg属性
        }
    }
    
    //在外部类之中定义一个方法，这个方法负责产生内部类对象并且调用print（）方法
    public void fun() {
        Inner in = new Inner();//内部类对象
        in.print();//内部类中提供的print（）方法
    }
}
public class test1 {
    public static void main(String[] args) {
        Outer out=new Outer();//外部类对象
        out.fun();//调用外部类方法
        
        Outer.Inner in=new Outer().new Inner();
        in.print();
    }
}

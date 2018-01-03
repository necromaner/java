package neibulei;

/**
 * Description:
 * User: necromaner
 * Date: 2017-12-31
 * Time: 下午12:57
 */
class Outer1 {//定义一个外部类
    private String msg = "Hello World !";
    public String getMsg() {//通过此方法才可以取到msg内容
        return msg;
    }
    public void fun(){//3、现在由out对象调用了fun()方法
//        Inner1 in =new Inner1();//内部类对象
        Inner2 in =new Inner2(this);//内部类对象//4、this表示当前对象
        in.print();//内部类中提供的print（）方法//7、调用方法
    }
}
//class Inner1{//定义一个内部类
//    public void print(){//定义一个普通方法
//        System.out.println(new Outer1().getMsg());//调用msg属性
//    }
//}
class Inner2{
    private Outer1 out;
    public Inner2(Outer1 out){//5、Inner.out=main.out
        this.out=out;//6、引用传递
    }
    public void print(){//定义一个普通方法//8、执行此方法
        System.out.println(this.out.getMsg());//调用msg属性
    }
}
public class OutDemo {
    public static void main(String[] args) {
        Outer1 out=new Outer1();//外部类对象//1、实例化Outer类对象
        out.fun();//调用外部类方法//调用Outer类方法
    }
    //目的为的访问外部类的私有属性
}

package D1;

/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-08-25
 *
 * @Description: java类作用描述
 * Time: 上午10:47
 */
abstract class A1{
    public A1(){//3.调用父类构造方法
        this.print();//4.调用被子类覆写中的方法
    }
    public abstract void print();
}
class B1 extends A1{
    private int num=100;
    public B1(int num){//2.调用子类实例化对象
//        super();//3.隐含一行语句，实际要想调用父类构造
        this.num=num;//7.为类中属性进行初始化
    }
    public void print(){//5.此时子类对象的属性还没有被初始化
        System.out.println(this.num);//6.内容为其对应数据的默认值
    }
}
public class T3 {
    public static void main(String[] args) {
        new B1(11);//1.实例化子类对象
    }
}


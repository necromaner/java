package neibulei;

/**
 * Description:
 * User: necromaner
 * Date: 2017-12-31
 * Time: 下午2:29
 */
//在方法中定义内部类
class Outer4 {
    private String msg = "Hello World!";
    public void fun(int num){
        class Inner4{
            public void print(){
                System.out.println("msg = "+msg);
                System.out.println("num = "+num);
            }
        }
        new Inner4().print();//产生了内部类并调用了方法
    }
}
public class test3 {
    public static void main(String[] args) {
        Outer4 outer4=new Outer4();
        outer4.fun(12);
    }
    //此代码在jdk1.8是正常的，1.8之前是错误的（此时用的最多的是1.7的，不是1.8的）
    //在1.7及以前，如果一个内部类定义在了方法之中，那么该内部类如果想要访问方法中的参数，那么这个参数前必须使用final定义。而jdk1.8之后为了推广他的函数式编程，所有将这一局限取消了
}

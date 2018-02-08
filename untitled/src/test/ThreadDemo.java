package test;

/**
 * Description:
 * User: necromaner
 * Date: 2018-02-08
 * Time: 下午8:16
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        Thread d1=new Thread();
        test1 t1=new test1("qq");
        test1 t2=new test1("ww");
        t1.run();
        t2.run();
    }
}

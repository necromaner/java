package test;

/**
 * Description:
 * User: necromaner
 * Date: 2018-02-08
 * Time: 下午8:14
 */
public class test1 extends Thread{
    private String name;
    test1(String name){
        this.name=name;
    }
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(name+" --- "+i);
        }
    }
}

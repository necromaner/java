package neibulei;

/**
 * Description:
 * User: necromaner
 * Date: 2017-12-31
 * Time: 下午2:14
 */
//static定义内部类
class Outer3{
    private static String msg="Hello World!";
    static class Inner{//内部类="外部类"
        public void print(){
            //此时只能使用外部类中的static操作
            System.out.println(msg);
        }
    }
}

public class test2 {
    public static void main(String[] args) {
        Outer3.Inner in=new Outer3.Inner();
        in.print();
    }
}

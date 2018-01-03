package fuxie;

/**
 * Description:
 * User: necromaner
 * Date: 2018-01-02
 * Time: 下午3:17
 */
class Person3{
    public String info="-------------";
}
class Student3 extends  Person3{
    //因为此时按照就近取用的原则，肯定找被覆盖的属性名称
    public int info=100;//属性名称相同
    public void printInfo(){
        System.out.println(info);
    }
}
public class test3 {
    public static void main(String[] args) {
        Student3 student=new Student3();
        student.printInfo();
    }
}

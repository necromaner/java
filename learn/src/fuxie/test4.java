package fuxie;

/**
 * Description:
 * User: necromaner
 * Date: 2018-01-02
 * Time: 下午4:05
 */
class Person4{
    public void printInfo(){
        System.out.println("11111111111");
    }
}
class Student4 extends Person4{
    public void printInfo(){
        super.printInfo();
        System.out.println("22222222");
    }
}
public class test4 {
    public static void main(String[] args) {
        Student4 student=new Student4();
        student.printInfo();
    }
}

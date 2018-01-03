package fuxie;

/**
 * Description:
 * User: necromaner
 * Date: 2018-01-02
 * Time: 下午2:31
 */
class Person{
    public void fun(){
        this.printInfo();
    }
    public void printInfo(){
        System.out.println("[Person类]printInfo()方法");
    }
}
class Student extends Person{
    //基本所有情况下子类中的方法名称和父类中的方法名称是完全一样的。
    public void printInfo(){
        System.out.println("[Student类]printInfo()方法");
    }
}
public class test1 {
    public static void main(String[] args) {
        Student student=new Student();
//        student.printInfo();
        student.fun();
    }
}

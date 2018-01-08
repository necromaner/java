package chouxianglei;

/**
 * Description:
 * User: necromaner
 * Date: 2018-01-07
 * Time: 下午4:11
 */
abstract class Person{
    private String name;
    private int age;
    public Person(){
        System.out.println("----------------");
    }
    public abstract String getInfo();//抽象方法
}
class Student extends Person{
    private String school;
    public Student(){
        System.out.println("++++++++++++++++");
    }
    public String getInfo(){
         return null;
    }
}
public class test2 {
    public static void main(String[] args) {
        new Student();
    }
}

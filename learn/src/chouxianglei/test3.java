package chouxianglei;

/**
 * Description:
 * User: necromaner
 * Date: 2018-01-07
 * Time: 下午4:48
 */
abstract class Person1{
    private String name;
    private int age;
    public Person1(String name,int age){
        System.out.println("----------------");
        this.name=name;
        this.age=age;
    }
    
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public abstract String getInfo();//抽象方法
}
class Student1 extends Person1{
    private String school;
    public Student1(String name,int age,String school){
        super(name,age);//子类构造必须明确调用父类构造
        this.school=school;
        System.out.println("++++++++++++++++");
    }

    public String getInfo() {
        return "Student1{" +
                "name='" + super.getName() + '\'' +
                "age='" + super.getAge() + '\'' +
                "school='" + this.school + '\'' +
                '}';
    }
}
public class test3 {
    public static void main(String[] args) {
        Person1 pre= new Student1("a",18,"aa");
        System.out.println(pre.getInfo());
    }
}
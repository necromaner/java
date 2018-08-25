package D1;

/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-08-25
 *
 * @Description: java类作用描述
 * Time: 上午9:55
 */
abstract class Person{
    private String name;
    private int age;
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getName() {
        return name;
    }
    public abstract String getInfo();//抽象方法
}
class Student extends Person{
    private String school;
    public Student(String name,int age,String school){//子类构造必须明确调用父类构造
        super(name,age);
        this.school=school;
    }
    
    @Override
    public String getInfo() {
        return super.getName()+"-"+super.getAge()+"-"+school;
    }
}
public class T2 {
    public static void main(String[] args) {
        Person person=new Student("张三",18,"北大");
        System.out.println(person.getInfo());
    }
}

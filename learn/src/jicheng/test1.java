package jicheng;

/**
 * Description:
 * User: necromaner
 * Date: 2018-01-02
 * Time: 下午1:15
 */
class Person{
    private String name;
    private int age;
    public Person(String name){
        System.out.println("======Penson========");
    }
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
}
class Student extends Person{
    private String school;
    
    public Student(){
        //既然是要进行构造方法调用，那么构造方法的调用一定要放在构造方法的首行
        super("1");//此语句在无参时写不写一样,有参时明确定义要调用的父类构造
        System.out.println("======Student=======");
    }
    public String getSchool() {
        return school;
    }
    
    public void setSchool(String school) {
        this.school = school;
    }
}
public class test1 {
    public static void main(String[] args) {
        Student student=new Student();
        student.setAge(1);
        student.getAge();
    }
}

package fuxie;

/**
 * Description:
 * User: necromaner
 * Date: 2018-01-02
 * Time: 下午2:31
 */
class Person1{
    public void fun(){
        this.printInfo();
    }
    //如果现在父类中的方法使用了private定义，那么就表示该方法只能够被父类所使用，子类无法使用，也就是说子类根本就不知道父类有这样的方法。
    private void printInfo(){
        System.out.println("[Person类]printInfo()方法");
    }
}
class Student1 extends Person1{
    //基本所有情况下子类中的方法名称和父类中的方法名称是完全一样的。
    //这个时候该方法只是子类定义的新方法而已，并没有父类的方法的任何关系。
    public void printInfo(){
        System.out.println("[Student类]printInfo()方法");
    }
}
public class test2 {
    public static void main(String[] args) {
        Student1 student=new Student1();
//        student.printInfo();
        student.fun();
    }
}

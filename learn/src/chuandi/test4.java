package chuandi;

/**
 * Description:
 * User: necromaner
 * Date: 2017-12-28
 * Time: 下午8:04
 */
class Member{
    private String name;
    private int age;
    private Car car;
    private Member child;
    
    public void setCar(Car car) {
        this.car = car;
    }
    
    public Car getCar() {
        return this.car;
    }
    
    public void setChild(Member child) {
        this.child = child;
    }
    
    public Member getChild() {
        return this.child;
    }
    
    public Member(String name, int age){
        this.name=name;
        this.age=age;
    }
    public String getMemberInfo(){
        return "[Member] name = "+this.name+" , age = "+this.age;
    }
}
class Car{
    private String name;
    private double prise;
    private Member member;
    
    public void setMember(Member member) {
        this.member = member;
    }
    
    public Member getMember() {
        return member;
    }
    
    public Car(String name, double prise){
        this.name=name;
        this.prise=prise;
    }
    public String getCarInfo(){
        return "[Car] name = "+this.name+" , prise = "+this.prise;
    }
}
public class test4 {
    public static void main(String[] args) {
        //第一步：根据关系设置相应的数据
        System.out.println("\n1、分别创建各自的实例");
        //1、分别创建各自的实例
        Member mem=new Member("施意",23);
        Car car=new Car("法拉利",5000000.0);
        Member child=new Member("狮子",10);
        Car car1=new Car("玛莎拉蒂",1000000.0);
        System.out.println("\n2、设置对象间的引用关系");
        //2、设置对象间的引用关系
        mem.setCar(car);//一个人有一辆车
        mem.setChild(child);
        child.setCar(car1);
        car.setMember(mem);//一辆车属于一个人
        car1.setMember(child);
        //第二步：根据关系取出数据
        System.out.println("\n3、通过人可以找到车");
        //3、通过人可以找到车
        System.out.println(mem.getMemberInfo());
        System.out.println(mem.getCar().getCarInfo());
        System.out.println("\n4、通过车找人");
        //4、通过车找人
        System.out.println(car.getCarInfo());
        System.out.println(car.getMember().getMemberInfo());
        System.out.println("\n5、通过人找到他的孩子");
        //5、通过人找到他的孩子
        System.out.println(mem.getChild().getMemberInfo());
        System.out.println("\n6、通过人的孩子找到车");
        //6、通过人的孩子找到车
        System.out.println(mem.getChild().getCar().getCarInfo());
        
    }
}

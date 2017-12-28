package chuandi;

/**
 * Description:
 * User: necromaner
 * Date: 2017-12-28
 * Time: 下午9:03
 */
class Member1{
    private String name;
    private Car1 car1;
    private Member1 wife;
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setCar1(Car1 car1) {
        this.car1 = car1;
    }
    
    public Car1 getCar1() {
        return car1;
    }
    
    public Member1 getWife() {
        return wife;
    }
    
    public void setWife(Member1 wife) {
        this.wife = wife;
    }
}
class Car1{
    private String name;
    private Member1 member1;
    private Door door;
    private Colour colour;
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setMember1(Member1 member1) {
        this.member1 = member1;
    }
    
    public Member1 getMember1() {
        return member1;
    }
    
    public Door getDoor() {
        return door;
    }
    
    public void setDoor(Door door) {
        this.door = door;
    }
    
    public Colour getColour() {
        return colour;
    }
    
    public void setColour(Colour colour) {
        this.colour = colour;
    }
}
class Door{
    private String name;
//    private Car1 car1;
    private Colour colour;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
//    public Car1 getCar1() {
//        return car1;
//    }
//
//    public void setCar1(Car1 car1) {
//        this.car1 = car1;
//    }
    
    public Colour getColour() {
        return colour;
    }
    
    public void setColour(Colour colour) {
        this.colour = colour;
    }
}
class Colour{
    private String name;
//    private Car1 car1;
//    private Door door;
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
//    public Car1 getCar1() {
//        return car1;
//    }
//
//    public void setCar1(Car1 car1) {
//        this.car1 = car1;
//    }
//
//    public Door getDoor() {
//        return door;
//    }
//
//    public void setDoor(Door door) {
//        this.door = door;
//    }
}
public class test4_1 {
    public static void main(String[] args) {
        Member1 m=new Member1();
        m.setName("蒋瑞晗");
        Car1 c=new Car1();
        c.setName("兰博基尼");
        Door d1=new Door();
        d1.setName("大");
        Colour c1=new Colour();
        c1.setName("红");
        Colour c2=new Colour();
        c2.setName("蓝");
        m.setCar1(c);
        c.setMember1(m);
        c.setColour(c1);
        c.setDoor(d1);
        d1.setColour(c2);
        System.out.println(m.getCar1().getDoor().getColour().getName());
        System.out.println(c.getMember1().getCar1().getName());
        
    }
}

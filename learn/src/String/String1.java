package String;

/**
 * Description:
 * User: necromaner
 * Date: 2017-12-27
 * Time: 下午12:00
 */
public class String1 {
    public static void main(String[] args) {
//        char[] x={'a','b','c','c','e','s','d','c'};
//        String x2= new String(x,1,5);
//        System.out.println(x2);
        String s="qewegh wegretnh";
        System.out.println(initcap(s));
        
    }
    public static String initcap(String str){
        if (str==null&&"".equals(str)){
            return str;
        }
         if (str.length()>1){
            return str.substring(0,1).toUpperCase()+str.substring(1);
         }
         return str.toUpperCase();
    }
}
class Person{
    private String name;
    private int age;
    public Person(){
        System.out.println("***********");
        getInfo();
    }
    public Person(String name){
        this();
        this.name=name;
    }
    public Person(String name,int age){
        this(name);
        this.age=age;
    }
    
    /**
     * @return
     */
    public String getInfo() {
        return "姓名："+this.name+" 年龄："+this.age;
    }
    
    public static void main(String[] args) {
        Person p1=new Person();
        Person p2=new Person("name");
        Person p3=new Person("name1",19);
        p1.getInfo();
        p2.getInfo();
        p3.getInfo();
    }
}

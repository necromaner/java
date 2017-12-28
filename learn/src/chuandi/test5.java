package chuandi;

/**
 * Description:
 * User: necromaner
 * Date: 2017-12-28
 * Time: 下午9:40
 */
//1、先按照给定的关系将所有的基础字段转化为简单java类
//2、随后要要进行关系设计，该数据表对应有如下的几个关系；
    //一个雇员属于一个部门，需要追加部门引用；
    //一个雇员有一个领导，领导一定是自身关联，自身引用；
    //一个部门有多个雇员，需要一个对象数组来描述多个雇员信息。
//那么此时基本的类定义完成了。
//3、实现开发需求：
class Emp{
    private int empno;//编号
    private String ename;//姓名
    private String job;//职位
    private double sal;//工资
    private double comm;
    private Emp mgr;//描述雇员领导
    private Dept dept;//描述雇员所在部门
    public Emp(){}
    public Emp(int empno, String ename, String job, double sal, double comm){
        this.empno=empno;
        this.ename=ename;
        this.job=job;
        this.sal=sal;
        this.comm=comm;
    }
    
    public Emp getMgr() {
        return mgr;
    }
    
    public void setMgr(Emp mgr) {
        this.mgr = mgr;
    }
    
    public Dept getDept() {
        return dept;
    }
    
    public void setDept(Dept dept) {
        this.dept = dept;
    }
    
    public String getInfo() {
        return "Emp{" +
                "empno=" + empno +
                ", ename='" + ename + '\'' +
                ", job='" + job + '\'' +
                ", sal=" + sal +
                ", comm=" + comm +
                '}';
    }
}
class Dept{
    private int deptno;//部门编号
    private String dname;//部门名称
    private String loc;//地址
    private Emp[] emps;//所有雇员
    public Dept(){}
    public Dept(int deptno,String dname,String loc){
        this.deptno=deptno;
        this.dname=dname;
        this.loc=loc;
    }
    
    public Emp[] getEmps() {
        return emps;
    }
    
    public void setEmps(Emp[] emps) {
        this.emps = emps;
    }
    
    public String getInfo() {
        return "Dept{" +
                "deptno=" + deptno +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
public class test5 {
    public static void main(String[] args) {
        //第一步：设置类对象间的关系
        //1、分别创建各自类的实例化对象
        Dept dept=new Dept(10,"ACCOUNTING","NEW YORK");
        Emp ea=new Emp(001,"SMITH","CLERK",800.0,0.0);
        Emp eb=new Emp(002,"ALLEN","MAMAGER",2450.0,0.0);
        Emp ec=new Emp(003,"KING","PRESIDENT",5000.0,0.0);
        //2、设置雇员领导的关系
        ea.setMgr(eb);
        eb.setMgr(ec);//ec没有领导，因为他是头
        //3、设置雇员和部门的关系
        ea.setDept(dept);
        eb.setDept(dept);
        ec.setDept(dept);
        //4、设置部门和雇员的关系
        dept.setEmps(new Emp[]{ea,eb,ec});
        //第二步：进行数据的取得
        System.out.println(dept.getInfo());//输出部门信息
        for (int i = 0; i < dept.getEmps().length; i++) {
            System.out.println("\t|- "+dept.getEmps()[i].getInfo());
            if (dept.getEmps()[i].getMgr()!=null){
                System.out.println("\t\t|- "+dept.getEmps()[i].getMgr().getInfo());
            }
        }
        System.out.println("===================================\n");
        System.out.println(ea.getMgr().getInfo());
        if (eb.getMgr()!=null){
            System.out.println(eb.getMgr().getInfo());
        }else
            System.out.println("null");
        System.out.println(ea.getDept().getInfo());
        if (eb.getDept()!=null){
            System.out.println(eb.getDept().getInfo());
        }else System.out.println("null");
        
        //这种关系的匹配以及数据的取出操作，是必须掌握的，也是日后开发的基本模式
    }
}

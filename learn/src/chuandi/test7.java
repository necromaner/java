package chuandi;

/**
 * Description:
 * User: necromaner
 * Date: 2017-12-29
 * Time: 下午12:35
 */
/*
要求可以根据一个员工找到他所对应的部门，以及该部门对应的角色，以及每个角色对应的所有权限；
可以根据一个角色找到具备此角色的所有部门，以及该部门下的所有员工；
根据一个权限列出具备有该权限的所有的角色以及每一个角色下对应的所有部门，以及每个部门中的所有员工。
1、进行单独类描述
2、进行关系描述
3、要根据关系进行测试数据的编写以及完成指定的输出。
 */
class Dept1{//部门信息
    private int did;
    private String dname;
    private Emp1[] emps;//一个部门有多个角色
    private Role role;//一个部门有一个角色
    public Dept1(int did,String dname){
        this.did=did;
        this.dname=dname;
    }
    
    public Emp1[] getEmps() {
        return emps;
    }
    
    public void setEmps(Emp1[] emps) {
        this.emps = emps;
    }
    
    public Role getRole() {
        return role;
    }
    
    public void setRole(Role role) {
        this.role = role;
    }
    
    public String getInfo() {
        return "部门{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                '}';
    }
}
class Emp1{//雇员信息
    private int eid;
    private String ename;
    private Dept1 dept;
    public Emp1(int eid,String ename){
        this.eid=eid;
        this.ename=ename;
    }
    
    public Dept1 getDept() {
        return dept;
    }
    
    public void setDept(Dept1 dept) {
        this.dept = dept;
    }
    
    public String getInfo() {
        return "雇员{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                '}';
    }
}
class Role{//角色信息
    private int rid;
    private String title;
    private Dept1[] depts;//多个部门具备此角色
    private Action[] actions;//一个角色拥有多个权限
    public Role(int rid,String title){
        this.rid=rid;
        this.title=title;
    }
    
    public Dept1[] getDepts() {
        return depts;
    }
    
    public void setDepts(Dept1[] depts) {
        this.depts = depts;
    }
    
    public Action[] getActions() {
        return actions;
    }
    
    public void setActions(Action[] actions) {
        this.actions = actions;
    }
    
    public String getInfo() {
        return "角色{" +
                "rid=" + rid +
                ", title='" + title + '\'' +
                '}';
    }
}
class Action{//权限
    private int aid;
    private String title;
    private String flag;
    private Role[] roles;
    public Action(int aid,String title,String flag){
        this.aid=aid;
        this.title=title;
        this.flag=flag;
    }
    
    public Role[] getRoles() {
        return roles;
    }
    
    public void setRoles(Role[] roles) {
        this.roles = roles;
    }
    
    public String getInfo() {
        return "权限{" +
                "aid=" + aid +
                ", title='" + title + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
public class test7 {
    public static void main(String[] args) {
        //第一步：设置数据之间的关系
        //1、创建部门数据
        Dept1 d10=new Dept1(10,"财务部");
        Dept1 d20=new Dept1(10,"市场部");
        //2、创建雇员数据
        Emp1 e1=new Emp1(1,"SMITH");
        Emp1 e2=new Emp1(2,"ALLEN");
        Emp1 e3=new Emp1(3,"FORD");
        Emp1 e4=new Emp1(4,"KING");
        Emp1 e5=new Emp1(5,"SCOTT");
        //3、创建角色数据
        Role r100=new Role(100,"管理者");
        Role r200=new Role(200,"职员层");
        //4、创建权限
        Action a1000=new Action(1000,"雇员入职","emp:add");
        Action a2000=new Action(2000,"雇员晋升","emp:edit");
        Action a3000=new Action(3000,"发布公告","news:add");
        Action a6000=new Action(6000,"查看客户信息","customer:list");
        Action a7000=new Action(7000,"回访记录","customer:add");
        //5、设置角色和权限的关系
        r100.setActions(new Action[]{a1000,a2000,a3000});
        r200.setActions(new Action[]{a6000,a7000});
        //6、设置权限和角色的关系
        a1000.setRoles(new Role[]{r100});
        a2000.setRoles(new Role[]{r100});
        a3000.setRoles(new Role[]{r100});
        a6000.setRoles(new Role[]{r200});
        a7000.setRoles(new Role[]{r200});
        //7、设置部门和角色的关系
        d10.setRole(r100);
        d20.setRole(r200);
        //8、设置角色和部门的关系
        r100.setDepts(new Dept1[]{d10});
        r200.setDepts(new Dept1[]{d20});
        //9、设置雇员和部门的关系
        e1.setDept(d10);
        e2.setDept(d10);
        e3.setDept(d20);
        e4.setDept(d20);
        e5.setDept(d20);
        //10、设置部门和雇员的关系
        d10.setEmps(new Emp1[]{e1,e2});
        d20.setEmps(new Emp1[]{e3,e4,e5});
        //第二步：输出相应数据
        Emp1 e=e1;
        System.out.println("\n1.要求可以根据一个员工找到他所对应的部门，以及该部门对应的角色，以及每个角色对应的所有权限；");
        System.out.println(e.getInfo());
        System.out.println("\t|- "+e.getDept().getInfo());
        System.out.println("\t\t|- "+e.getDept().getRole().getInfo());
        for (int i = 0; i < e.getDept().getRole().getActions().length; i++) {
            if (e.getDept().getEmps()!=null){
                System.out.println("\t\t\t|- "+e.getDept().getRole().getActions()[i].getInfo());
            }
        }
        Role r=r100;
        System.out.println("\n2.可以根据一个角色找到具备此角色的所有部门，以及该部门下的所有员工；");
        System.out.println(r.getInfo());
        for (int i = 0; i < r.getDepts().length; i++) {
            System.out.println("\t|- "+r.getDepts()[i].getInfo());
            for (int j = 0; j < r.getDepts()[i].getEmps().length; j++) {
                System.out.println("\t\t|- "+r.getDepts()[i].getEmps()[j].getInfo());
            }
        }
        Action a=a1000;
        System.out.println("\n3.根据一个权限列出具备有该权限的所有的角色以及每一个角色下对应的所有部门，以及每个部门中的所有员工。");
        System.out.println(a.getInfo());
        for (int i = 0; i < a.getRoles().length; i++) {
            System.out.println("\t|- "+a.getRoles()[i].getInfo());
            for (int j = 0; j < a.getRoles()[i].getDepts().length; j++) {
                System.out.println("\t\t|- "+a.getRoles()[i].getDepts()[j].getInfo());
                for (int k = 0; k < a.getRoles()[i].getDepts()[j].getEmps().length; k++) {
                    System.out.println("\t\t\t|- "+a.getRoles()[i].getDepts()[j].getEmps()[k].getInfo());
                }
            }
        }
        //本程序里面包含了基本上所有可能用到最复杂的逻辑。
    }
}

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-12-15
 * Time: 下午2:47
 */
class Emp{
    private int empon;
    private String ename;
    private String job;
    private double al;
    private double comm;
    public Emp(int empon,String ename,String job,double al,double comm){
        setEmpon(empon);
        setEname(ename);
        setJob(job);
        setAl(al);
        setComm(comm);
    }
    public void setEmpon(int empon) {
        this.empon = empon;
    }
    public void setEname(String ename){
        this.ename=ename;
    }
    public void setJob(String job){
        this.job=job;
    }
    public void setAl(double al){
        this.al=al;
    }
    public void setComm(double comm) {
        this.comm = comm;
    }
    
    public int getEmpon() {
        return empon;
    }
    
    public String getEname() {
        return ename;
    }
    
    public String getJob() {
        return job;
    }
    
    public double getAl() {
        return al;
    }
    
    public double getComm() {
        return comm;
    }
    public String getInfo(){
        return "epon"+empon+"\n"+
                "ename"+ename+"\n"+
                "job"+job+"\n"+
                "al"+al+"\n"+
                "comm"+comm;
    }
}
public class Test1 {
    public static void main(String args[]){
        Emp emp=new Emp(10,"q","w",1.1,2.2);
        System.out.println(emp.getInfo());
    }
}

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-22
 * Time: 下午2:41
 */
public class text8_5 {
    public int id; // 员工工号
    public String name; // 员工姓名
    public int years; // 工年龄
    public String sex;
    private int sex(String sex){
        if(sex=="woman"||sex=="女")
            return 1;
        else
            return 0;
    }
    public int holiday(){
        int holiday=0;
        if(this.years>=20)
            holiday=15;
        else if(this.years>=10)
            holiday=10;
        else if(this.years>=1)
            holiday=5;
        else
            holiday=0;
        return holiday+sex(sex);
    }
}

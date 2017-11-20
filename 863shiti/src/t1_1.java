/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-11-18
 * Time: 下午3:39
 */
public class t1_1 {
    private int l1=0;
    private int l2=0;
    private int l3=0;
    private int l4=0;
    private int l5=0;
    private int y=0;
    public void xx(int x){
        while (x>0){
            y++;
            switch (y){
                case 1:
                    l5=x%10;break;
                case 2:
                    l4=x%10;break;
                case 3:
                    l3=x%10;break;
                case 4:
                    l2=x%10;break;
                case 5:
                    l1=x%10;break;
            }
            x=x/10;
        }
    }
    public void getwei() {
        System.out.println(l1+" "+l2+" "+l3+" "+l4+" "+l5);
    }
    public int getY() {
        return y;
    }
}

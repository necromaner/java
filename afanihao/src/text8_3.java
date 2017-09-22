/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-22
 * Time: 上午10:59
 */
public class text8_3 {
    public String fraction1="";
    public String fraction2="";
    int fenzi;
    int fenmu;
    private int[] fen(String fraction){
        String[] strs1 = fraction.split("/");
        String[] strs=new String[2];
        int[] aaa=new int[2];
        if(strs1.length>2||strs1.length<=0){
            strs[0]="0";
            strs[1]="0";
        }else{
            strs[0]=strs1[0];
            if(strs1.length==2){
                strs[1]=strs1[1];
            }else
                strs[1]="1";
        }
        aaa[0] = Integer.parseInt(strs[0]);
        aaa[1] = Integer.parseInt(strs[1]);
        if(aaa[1]<0){
            aaa[0]=-aaa[0];
            aaa[1]=-aaa[1];
        }
        return aaa;
    }
    public String zuijian(int fenzi,int fenmu){
        int min;
        if(fenzi>fenmu)
            min=fenmu;
        else
            min=fenzi;
        for (int i = 1; i <= min; i++) {
            if(fenzi%i==0&&fenmu%i==0){
                fenzi=fenzi/i;
                fenmu=fenmu/i;
            }
        }
        if(fenmu==1)
            return String.valueOf(fenzi);
        return fenzi+"/"+fenmu;
    }
    public String multiplication(){
        int[] strs11=fen(fraction1);
        int[] strs22=fen(fraction2);
        fenzi=strs11[0]*strs22[0];
        fenmu=strs11[1]*strs22[1];
        if(fenzi==0||fenmu==0)
            return "错误";
        return zuijian(fenzi,fenmu);
    }
    public String addition(){
        int[] strs11=fen(fraction1);
        int[] strs22=fen(fraction2);
        fenzi=strs11[0]*strs22[1]+strs11[1]*strs22[0];
        fenmu=strs11[1]*strs22[1];
        if(fenzi==0||fenmu==0)
            return "错误";
        return zuijian(fenzi,fenmu);
    }
}

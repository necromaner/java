/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-22
 * Time: 上午11:12
 */
public class text {
    public static void main(String[] args) {
    
        String fraction1 = "1/2";
        String fraction2 = "1/2";
        String answer;
    
        int[] aaa=fen(fraction1);
        int[] bbb=fen(fraction2);
//    public String multiplication(){
//        int fenzi;
//        int fenmu;
//        strs11=change(strs1);
//        strs22=change(strs2);
//        fenzi=strs11[0]*strs22[0];
//        fenmu=strs11[1]*strs22[1];
//        answer=fenzi+"/"+fenmu;
//        return answer;
//    }
    
        for (int i = 0; i < aaa.length; i++) {
            System.out.print(aaa[i]*bbb[i]+" ");
        }
    }
    
    
    private static int[] fen(String fraction){
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
        aaa[0] = Integer.parseInt(strs1[0]);
        aaa[1] = Integer.parseInt(strs1[1]);
        return aaa;
    }
}

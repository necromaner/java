/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-10-01
 * Time: 下午6:51
 */


import java.util.Random;

public class text14_4 {
    public int[] jiang;
    public void choujiang(int min,int max,int renshu){
        if(renshu>=1){
            jiang=new int[renshu];
            Random random = new Random();
            jiang[0]=random.nextInt(max)%(max-min+1) + min;
            int cishu=1;
            boolean x=true;
            while (cishu<renshu){
                jiang[cishu]=random.nextInt(max)%(max-min+1) + min;
                for (int i = 0; i < cishu; i++) {
                    if(jiang[cishu]==jiang[i]){
                        x=false;
                        break;
                    }
                }
                if(x){
                    cishu++;
                }
                
            }
        }
        else
        {
            System.out.println("错误");
        }

    }
    public void xinchoujiang(int min,int max,int renshu){
        jiang=new int[renshu];
        Random random = new Random();
        if(renshu<1||renshu>max-min+1){
            System.out.println("错误");
            return;
        }
        int[] ren=new int[max-min+1];
        for (int i = 0; i < ren.length; i++) {
            ren[i]=min+i;
        }
        for (int i = 0; i < renshu; i++) {
            int s=random.nextInt(ren.length-1);
            jiang[i]=ren[s];
            ren[s]=ren[ren.length-1];
            int[] rencopy=ren;
            
            ren=new int[max-min+1-i-1];
            for (int j = 0; j < ren.length; j++) {
                ren[j]=rencopy[j];
            }
//            System.out.print("ren: ");
//            for (int j = 0; j < ren.length; j++) {
//                System.out.print(ren[j]+" ");
//            }
//            System.out.println("");
            
        }
    }
}

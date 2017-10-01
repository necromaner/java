import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-10-01
 * Time: 下午9:01
 */
public class text14_5 {
    public int min;
    public int max;
    public int[] xihao;
    public String[] pukexihao;
    public text14_5(){
        this.min=0;
        this.max=53;
        System.out.println("打乱"+min+"到"+max+"之间的数");
    }
    public text14_5(int x){
        this.min=0;
        this.max=x-1;
        System.out.println("打乱"+min+"到"+max+"之间的数");
    }
    public text14_5(int min,int max){
        this.min=min;
        this.max=max;
        System.out.println("打乱"+min+"到"+max+"之间的数");
    }
    
    public void xipai(){
        xihao=new int[max-min+1];
        Random random = new Random();
        
        int[] ren=new int[max-min+1];
        for (int i = 0; i < ren.length; i++) {
            ren[i]=min+i;
        }
        for (int i = 0; i < xihao.length-1; i++) {
            int s=random.nextInt(ren.length-1);
            xihao[i]=ren[s];
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
        xihao[xihao.length-1]=ren[0];
    }
    public void pukexipai(){
        pukexihao=new String[max-min+1];
        Random random = new Random();
        
        String[] ren=new String[max-min+1];
        for (int i = 0; i < ren.length; i++) {
            //ren[i]=min+i;
        }
        int xx=0;
        for (int i = 0; i < 4; i++) {
            String x="";
            switch (i){
                case 0:
                    x="方片";break;
                case 1:
                    x="梅花";break;
                case 2:
                    x="红桃";break;
                case 3:
                    x="黑桃";break;
            }
            for (int j = 0; j < 13; j++) {
                
                String y="";
                switch (j){
                    case 0:
                        y="1 ";break;
                    case 1:
                        y="2 ";break;
                    case 2:
                        y="3 ";break;
                    case 3:
                        y="4 ";break;
                    case 4:
                        y="5 ";break;
                    case 5:
                        y="6 ";break;
                    case 6:
                        y="7 ";break;
                    case 7:
                        y="8 ";break;
                    case 8:
                        y="9 ";break;
                    case 9:
                        y="10";break;
                    case 10:
                        y="J ";break;
                    case 11:
                        y="Q ";break;
                    case 12:
                        y="K ";break;
                }
                ren[xx]=x+y;
                xx++;
            }
        }
        ren[52]="小王  ";
        ren[53]="大王  ";
        for (int i = 0; i < pukexihao.length-1; i++) {
            int s=random.nextInt(ren.length-1);
            pukexihao[i]=ren[s];
            ren[s]=ren[ren.length-1];
            String[] rencopy=ren;
            ren=new String[max-min+1-i-1];
            for (int j = 0; j < ren.length; j++) {
                ren[j]=rencopy[j];
            }
//            System.out.print("ren: ");
//            for (int j = 0; j < ren.length; j++) {
//                System.out.print(ren[j]+" ");
//            }
//            System.out.println("");
//            System.out.print("pukexihao: ");
//            for (int j = 0; j < pukexihao.length; j++) {
//                System.out.print(pukexihao[j]+" ");
//            }
//            System.out.println("");
        }
        pukexihao[pukexihao.length-1]=ren[0];
    }
}

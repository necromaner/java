/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-12-26
 * Time: 下午2:52
 */
public class qw {
    public static void main(String[] args) {
        int[][] x = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        
        output(x);
        conversion(x);
        output(x);
        
    }
    
    public static void output(int[][] x) {
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print(x[i][j]);
                if (j != x[i].length - 1)
                    System.out.print(" ");
            }
            System.out.println("");
        }
    }
    public  static  void conversion(int[][] x){
        for (int i = 0; i < x.length; i++) {
            for (int j = i+1; j < x[i].length; j++) {
                int temp=x[i][j];
                x[i][j]=x[j][i];
                x[j][i]=temp;
            }
        }
    }

    
}

package String;

/**
 * Description:
 * User: necromaner
 * Date: 2017-12-27
 * Time: 下午12:00
 */
public class String1 {
    public static void main(String[] args) {
//        char[] x={'a','b','c','c','e','s','d','c'};
//        String x2= new String(x,1,5);
//        System.out.println(x2);
        String s="qewegh wegretnh";
        System.out.println(initcap(s));
        
    }
    public static String initcap(String str){
        if (str==null&&"".equals(str)){
            return str;
        }
         if (str.length()>1){
            return str.substring(0,1).toUpperCase()+str.substring(1);
         }
         return str.toUpperCase();
    }
}

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-21
 * Time: 下午6:08
 */
public class text7 {
    public static void main(String[] args) {
        System.out.println(
                "写一个方法，显示以下欢迎文字：\n" +
                "***************************\n" +
                "***** Java学习指南        **\n" +
                "***************************");
        text7_1 text7_1=new text7_1();
        text7_1.out();
    
        System.out.println("\n\n写一个方法，求一个3个数的乘积。\n" +
                "然后用这个方法，求 29.2   19   39 的乘积。");
        double a=29.2;
        double b=19;
        double c=39;
        System.out.println("29.2   19   39 的乘积为 "+text7_1.product(a,b,c));
    
        System.out.println("\n\n写一个方法，实现以下功能：\n" +
                " 输入一个数 a ，求它的平方\n" +
                "然后用这个方法，求 193.819  的平方");
        double d=193.819;
        System.out.println("193.819  的平方为  "+text7_1.square(d));
    
        System.out.println("\n\n写一个方法，求一个数的绝对值。\n" +
                "然后用这个方法求  -192的绝对值。\n" +
                "注意：先写类，然后在类里添加方法。");
        int e=-192;
        System.out.println("-192的绝对值为  "+text7_1.AbsoluteValue(e));
    
        System.out.println("\n\n给定一个数组，求数组里所有元素的和。\n" +
                "步骤：先写类，然后在类里添加方法。");
        int[] f={10,20,30,40};
        System.out.println("和为  "+text7_1.sum(f));
    
        System.out.println("\n\n有两个数组，求它们中的所有数的和。\n" +
                "int[] arr = { 12, 39, 90, 13};\n" +
                "int[] arr2 = { 4, 0, 3};");
        int[] arr = { 12, 39, 90, 13};
        int[] arr2 = { 4, 0, 3};
        System.out.println("和为  "+text7_1.towsum(arr,arr2));
    
        System.out.println("\n\n给定一个数组，求里面的最小值。\n" +
                "int[] arr = { 12, 39, 90, 13};");
        System.out.println("12, 39, 90, 13中最小为  ："+text7_1.min(arr));
    
        System.out.println("\n\n找出 100~999 之间所有的 “完全平方数”\n" +
                "例如，\n" +
                "1 = 1 x1\n" +
                "4 = 2 x 2\n" +
                "9 = 3 x 3\n" +
                "16 = 4 x 4\n" +
                "所以 1 4 9 16都是完全平方数");
        System.out.print("完全平方：");
        text7_1.PerfectSquare();
    
        System.out.println("\n\n温度的表示有两种：摄氏度和华氏度。\n" +
                "转换公式： 摄氏度×9/5+32=华氏度\n" +
                "写一个方法，将摄氏度转成华氏度。");
        System.out.println("0摄氏度="+text7_1.Fahrenheit(0)+"华氏度");
    
        System.out.println("\n\n声音数据在两种表示\n" +
                "一种是用小数表示，用0到1.0 之间的一个小数，表示声音的采样值。\n" +
                "另一种是用整数表示，用0到65535之间的整数，表示采用值。\n" +
                "现有一下声音数据是以小数采样的。请把它转成整数采样。同时把音量噪点 ( > 0.7 ) 去掉");
        double[] audio = { 0.21, 0.22, 0.22, 0.24 };
        int[] converted=text7_1.volume(audio,0.7);
        System.out.print("0.21, 0.22, 0.22, 0.24 转化为：");
        for (int i = 0; i < converted.length; i++) {
            System.out.print(converted[i]+" ");
        }
    }
}

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-24
 * Time: 下午3:52
 */
public class text11 {
    public static void main(String[] args) {
        System.out.println("某在线课堂上有免费课程和收费课程。\n" +
                "免费课程有以下信息：\n" +
                "课程ID\n" +
                "课程名字\n" +
                "讲师姓名\n" +
                "收费课程有以下信息：\n" +
                "课程ID\n" +
                "课程名字\n" +
                "讲师姓名\n" +
                "费用\n" +
                "QQ群号\n" +
                "辅导老师姓名\n" +
                "请写两个类来描述它们。");
        text11_1 text11_1=new text11_1();
        text11_1.ID="001";
        text11_1.title="abc";
        text11_1.name="A_teacher";
        System.out.println("课程ID:"+text11_1.ID+" 课程名字:"+text11_1.title+" 讲师姓名:"+text11_1.name+"  费用:"+text11_1.price);
        text11_2 text11_2=new text11_2();
        System.out.println("费用:"+text11_2.price);
    
        System.out.println("\n\nx86的系统：可以运行32位的应用程序。runProgram32()\n" +
                "\n" +
                "x64的系统：即可以运行32位的应用程序，也可以运行64位的应用程序。runProgram64()\n" +
                "\n" +
                "用类来表示这种关系。");
        text11_3 x86=new text11_3();
        text11_4 x64=new text11_4();
        x86.runProgram32("text11_3.java");
        x64.runProgram32("text11_4.java");
        x64.runProgram64("text11_4.java");
    
    
        System.out.println("\n\n三角形 Triangle\n" +
                "三条边长：a,b,c\n" +
                "面积：\n" +
                "（公式） S =  sqrt (  p *  (p-a)  * (p-b) * (p-c) )\n" +
                "其中，\n" +
                "  p = (a + b + c) /2    即周长的一半\n" +
                "  sqrt : 求平方根\n" +
                "--------------------------------------------\n" +
                "直角三角形 RightTriangle\n" +
                "直角三角形的面积比较容易求得： a * b / 2\n" +
                "试写出上面的两个类\n" +
                "提示：Math.sqrt ( x )  可以求出x的平方根\n" +
                "例如: double x = Math.sqrt ( 4.0 );");
        text11_5 Triangle=new text11_5(3,4,5);
        text11_6 RightTriangle=new text11_6(4,5);
        System.out.println("Triangle "+Triangle.area());
        System.out.println("RightTriangle "+RightTriangle.area());
    
        System.out.println("\n\n长方形 Rect\n" +
                "两条边长 a, b\n" +
                "面积求法：S = a * b （公式）\n" +
                "正方形 Square可以看成是一种特殊形式的长方形。\n" +
                "试给Rect 和 Square添加合适的构造方法。");
        text11_7 Rect=new text11_7(4,5);
        text11_8 Square=new text11_8(10);
        System.out.println("长方形面积："+Rect.area());
        System.out.println("正方形面积："+Square.area());
    
        System.out.println("\n\n给前面的 Triangle类添加toString()方法，并输出出来。");
    }
}

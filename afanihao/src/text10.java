import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-22
 * Time: 下午4:30
 */
public class text10 {
    public static void main(String[] args) {
        System.out.println("一个三角形，初始化时指定3条边的边长。");
        text10_1 t11=new text10_1();
        text10_1 t12=new text10_1(6);
        text10_1 t13=new text10_1(2,30,40);
        System.out.println("t11  "+t11.a+"    "+t11.b+"    "+t11.c);
        System.out.println("t12  "+t12.a+"    "+t12.b+"    "+t12.c);
        System.out.println("t13  "+t13.a+"    "+t13.b+"   "+t13.c);
    
        System.out.println("\n\n一个圆 Circle\n" +
                "圆心位置 x, y\n" +
                "半径长度 radius\n" +
                "请给它添加几个构造方法");
        text10_2 t21=new text10_2();
        text10_2 t22=new text10_2(3);
        text10_3 t23=new text10_3(1,2);
        text10_3 t25=new text10_3();
        text10_2 t24=new text10_2(1,2,3);
        System.out.println("t21  "+t21.radius+" "+t21.x+" "+t21.y);
        System.out.println("t21  "+t22.radius+" "+t22.x+" "+t22.y);
        System.out.println("t21  "+t23.radius+" "+t23.x+" "+t23.y);
        System.out.println("t21  "+t24.radius+" "+t24.x+" "+t24.y);
        
    }
}

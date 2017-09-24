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
    
        text10_3 center = new text10_3(1,1);
        text10_2 t26 = new text10_2 (2.4, center); // 传Point作为参数
        System.out.println("t21  "+t21.radius+" "+t21.x+" "+t21.y);
        System.out.println("t22  "+t22.radius+" "+t22.x+" "+t22.y);
        System.out.println("t23  "+" "+t23.x+" "+t23.y);
        System.out.println("t25  "+" "+t25.x+" "+t25.y);
        System.out.println("t24  "+t24.radius+" "+t24.x+" "+t24.y);
        System.out.println("t26  "+t26.radius+" "+t26.x+" "+t26.y);
        System.out.println("有一个类，\n" +
                "public class Example\n" +
                "{\n" +
                "\tprivate int[] data = new int[16];\n" +
                "}\n" +
                "请给它写一个构造方法，请数组data的值全初始化为 -1");
        text10_4 text10_4=new text10_4();
        System.out.print("data=");
        for (int i = 0; i <text10_4.datatext.length ; i++) {
            System.out.print(text10_4.datatext[i]+" ");
            System.out.println("\n\n\n一个点 Point\n" +
                    "属性: 横坐标x, 纵坐标y\n" +
                    "一条线 Line\n" +
                    "属性：起点p1, 终点p2\n" +
                    "试写出Point 和 Line类的定义，并为其添加几个构造方法");
            text10_5 t51=new text10_5();
            text10_5 t52=new text10_5(1,2);
            text10_6 t61=new text10_6();
            text10_6 t62=new text10_6(1,2);
        }
    }
}

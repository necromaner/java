/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-12
 * Time: 下午8:15
 */
public class text6 {
    public static void main(String[] args) {
        System.out.println("添加一个类，描述一部电影的信息: 片名，主演，上映年份，票房\n" +
                "创建一个对象\n" +
                "片名： 战狼2\n" +
                "主演：吴京\n" +
                "上映： 2017\n" +
                "票房:  45亿\n");
        text6_1 movie=new text6_1();
        movie.name="战狼2";
        movie.actor="吴京";
        movie.year=2017;
        movie.sale=45;
        System.out.println("片名："+ movie.name+ "\n主演："+movie.actor+"\n上映："+movie.year+" \n票房:"+movie.sale+"亿");
        System.out.println("\n有一个三角形 Triangle，三边长分别为a, b, c (默认边长设为1）\n" +
                "写一类描述它。");
        text6_2 Triangle=new text6_2();
        Triangle.a=1.5;
        System.out.println("三角形: " + Triangle.a + "," + Triangle.b + "," + Triangle.c);
        System.out.println("\n新加一个类，描述长方形。\n" +
                "\n" +
                "创建一个 a x b 的长方形对象，并求它的面积。");
        text6_3 rectangle=new text6_3();
        rectangle.height=2;
        rectangle.width=3;
        int area = rectangle.width * rectangle.height;
        System.out.println("高："+rectangle.height+"  宽"+rectangle.width+"  面积"+area);
    
        System.out.println("\n设计一个类，描述以下信息。\n" +
                "每个学生的 姓名、学号、期末考试成绩（语、数、英语）。\n" +
                "创建一个对象：\n" +
                "  学号 201701 \n" +
                "  姓名 小明  \n" +
                "  成绩 98 87 90");
        text6_4 student=new text6_4();
        student.student_number=201701;
        student.name="小明";
        student.score[0]=98;
        student.score[1]=87;
        student.score[2]=90;
    
        System.out.println("\n每一个网站有以下信息：\n" +
                "   域名：  afanihao.cn\n" +
                "   名称：  阿发你好\n" +
                "   备案号： 23091023\n" +
                "   公网IP： 123.56.150.87\n" +
                "   联系人：\n" +
                "         姓名：邵发\n" +
                "         电话：138000011111\n" +
                "         住址：XXXXXXXX\n" +
                "设计一个类描述一下上述信息。");
        text6_5 site = new text6_5();
    
        site.domain = "afanihao.cn";
        site.name = "阿发你好";
        site.code = "23091023";
        site.IP = "123.56.150.87";
    
        site.contact.name = "邵发";
        site.contact.cellphone ="13800001111";
        site.contact.address = "XXXXXXXXXX";
    }
}

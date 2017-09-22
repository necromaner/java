/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-22
 * Time: 上午9:42
 */
public class text8 {
    public static void main(String[] args) {
        System.out.println("类： 三角形\n" +
                "属性： 3条边长\n" +
                "方法： 添加一个方法，求期周长。");
        text8_1 text8_1=new text8_1();
        text8_1.a=2;
        text8_1.b=2;
        text8_1.c=2;
        System.out.println("边长为"+text8_1.a+" "+text8_1.b+" "+text8_1.c+" "+"的周长为："+text8_1.perimeter());
    
    
        System.out.println("\n\n类： 一个圆形\n" +
                "属性： 半径长度\n" +
                "方法： 添加一个方法，求其周长\n" +
                "             添加一个方法，求其面积");
        text8_2 text8_2=new text8_2();
        text8_2.r=0.5;
        System.out.println("半径为"+text8_2.r+" "+"的周长为："+text8_2.perimeter());
        System.out.println("半径为"+text8_2.r+" "+"的面积为："+text8_2.area());
    
        System.out.println("\n\n写一个类表示分数。分数由分子和分母组成。\n" +
                "写一个方法，实现分数相乘。\n" +
                "写一个方法，显示分数的值。\n" +
                "利用这个类：求分数 1/3 和 2/5 的乘积，并显示最终结果。");
        text8_3 text8_3=new text8_3();
        text8_3.fraction1="1/3";
        text8_3.fraction2="2/5";
        System.out.println("分数"+text8_3.fraction1+"乘"+text8_3.fraction2+"的结果为"+text8_3.multiplication());
        System.out.println("分数"+text8_3.fraction1+"加"+text8_3.fraction2+"的结果为"+text8_3.addition());
    
        System.out.println("\n\n有一个彩灯，可以以3色显示。\n" +
                "按一下按钮，显示为红色。再按一下，显示绿色，再按一下，显示黄色。。 循环显示  红 -> 绿 -> 黄 -> 红 -> 绿 -> 黄 \n" +
                "请设计一个类。");
        text8_4 text8_4=new text8_4();
        text8_4.window();
    
        System.out.println("\n\n企业员工\n" +
                "有以下属性：\n" +
                "工号\n" +
                "姓名\n" +
                "性别\n" +
                "工龄\n" +
                "添加一个方法，计算其年假。\n" +
                "* 职工累计工作已满1年不满10年的，年休假5天；已满10年不满20年的，年休假10天；已满20年的，年休假15天。 \n" +
                "* 女性员工，多享受一天年假。");
        text8_5 text8_5=new text8_5();
        text8_5.id=001;
        text8_5.name="xiaoqiang";
        text8_5.sex="女";
        text8_5.years=20;
        System.out.println("工号:"+text8_5.id+"  姓名:"+text8_5.name+"  性别:"+text8_5.sex+"  工龄:"+text8_5.years+"其年假为："+text8_5.holiday());
    
        System.out.println("\n\n计算机画图时，有点的概念，每个点由它的横坐标x 和 纵坐标 y 描述。\n" +
                "写一个类。\n" +
                "求两个点之间的曼哈顿距离 = 横向距离 + 纵向距离\n" +
                "例如，一个点(0,0) 和另一个点（1，1）的曼哈顿距离为2");
        text8_6 text8_6=new text8_6();
        text8_6.a= new int[]{0, 0};
        text8_6.b= new int[]{1, 1};
        System.out.println("一个点(0,0) 和另一个点（1，1）的曼哈顿距离为:"+text8_6.Manhattan());
        
    }
}

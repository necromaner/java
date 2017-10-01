/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-25
 * Time: 下午2:21
 */
public class text14 {
    public static void main(String[] args) {
        System.out.println("String s1 = \"hello\";\n" +
                "\t\tString s2 = \"中国\";\n" +
                "\t\tString s3 = s1 + s2;\n" +
                "则s3的长度是多少？");
        String s1 = "hello";//长度5
        String s2 = "中国";//长度2
        String s3 = s1 + s2;//长度7
        System.out.println("s1长度： " + s1.length());
        System.out.println("s2长度： " + s2.length());
        System.out.println("s3长度： " + s3.length());
    
    
        System.out.println("\n\n" +
                "Java中字符串中子串的查找共有四种方法，如下：\n" +
                "1、int indexOf(String str) ：返回第一次出现的指定子字符串在此字符串中的索引。 \n" +
                "2、int indexOf(String str, int startIndex)：从指定的索引处开始，返回第一次出现的指定子字符串在此字符串中的索引。 \n" +
                "3、int lastIndexOf(String str) ：返回在此字符串中最右边出现的指定子字符串的索引。 \n" +
                "4、int lastIndexOf(String str, int startIndex) ：从指定的索引处开始向后搜索，返回在此字符串中最后一次出现的指定子字符串的索引。\n\n"+
        "substring(参数)是java中截取字符串的一个方法\n" +
                "有两种传参方式\n" +
                "一种是public String substring(int beginIndex)\n" +
                "返回一个新的字符串，它是此字符串的一个子字符串。该子字符串从指定索引处的字符开始，直到此字符串末尾。\n" +
                "另一种是public String substring(int beginIndex, int endIndex)\n" +
                "返回一个新字符串，它是此字符串的一个子字符串。该子字符串从指定的 beginIndex 处开始，直到索引 endIndex - 1 处的字符。因此，该子字符串的长度为 endIndex-beginIndex。 \n" +
                "详情请参考API  java.lang.String");
        System.out.println("\n\n提取下面一个字符串中的书的名字。已知书名以《》来分隔。\n" +
                "代码：\n" +
                "    String s1 = \"本教程的本套书本名为《Java学习指南1》《Java学习指南2》《Java学习指南3》《Java学习指南4》《Java学习指南5》，与本教程同步学习\";");
        
        String s4 = "本教程的本套书本名为《Java学习指南》，与本教程同步学习";
//    
//        int start = s4.indexOf("《");
//        if (start >= 0) {
//            int end = s4.indexOf("》", start);
//            if (end >= 0) {
//                String name = s4.substring(start, end + 1);
//                System.out.println("书名为：" + name);
//            }
//        }
    
        String s5 = "本教程的本套书本名为《Java学习指南1》《Java学习指南2》《Java学习指南3》《Java学习指南4》《Java学习指南5》，与本教程同步学习";
        int x=0;
        String[] name = new String[x+1];
        String[] old=new String[x+1];
        int start=s5.indexOf("《");
        while(start>=0){
            int end=s5.indexOf("》",start);
            if(end>=0){
                old = name;
                name = new String[x+1];
                for (int i = 0; i <old.length ; i++) {
                    name[i]=old[i];
                }
                name[x]=s5.substring(start,end+1);
                x++;
            }
            start=s5.indexOf("《",end);
        }
        for (int i = 0; i <name.length ; i++) {
            System.out.println("书名为：" + name[i]);
        }
        System.out.println("\n\n有一个字符串，\n" +
                "    String s1 = \"大家好，我是邵发，今天我们开始学习一门新的课程：C/C++学习指南(快速入门)\";\n" +
                "\n" +
                "请计算出该字符串里“我”字出现的次数");
        String s6 = "大家好，我是邵发，今天我们开始我学习一门新的课程：C/C++学习指南(快速入门)";
        int xx=0;
        int cha=0;//定位
        while (cha<s6.length()){
            int aa=s6.indexOf("我",cha);
            if( aa < 0)
                break;
            xx++;
            cha = aa + 1;
        }
        System.out.println("“我”字出现的次数为："+xx);
    
        System.out.println("\n\n有一个字符串，里面有多句话，\n" +
                "   String s1 = \"大家好，我是邵发，今天我们开始学习一门新的课程：C/C++学习指南(快速入门)\";\n" +
                "请计算里面有多少句话。\n" +
                "注：逗号、句号、叹号、问号、冒号都算量个分句。");
        String s7 = "大家好，我是邵发，今天我们开始学习一门新的课程：C/C++学习指南(快速入门).";
        String marks = ",.!?:，。！？："; // 句子的分隔符 (含中文标点和英文标点)
    
        int count = 1; // 子句数目
        for(int i=0; i<s7.length(); i++)
        {
            char ch = s7.charAt(i);
            if( marks.indexOf( ch) >= 0)
            {
                count ++;
            }
        }
        for (int i = 0; i < marks.length(); i++) {
            if(s7.charAt(s7.length()-1)==marks.charAt(i)){
                count--;
            }
        }
        System.out.println("句子数目: " + count);
    
        System.out.println("\n\n给定一个int数组，请它把转成一个逗号分隔的字符串\n" +
                "例如，\n" +
                "    int[] arr = { 12, 43, 34, 25 };\n" +
                "则生成字符串为： 12,43,34,25\n" +
                "示例：\n" +
                "public static String join(int[] arr)\n" +
                "{\n" +
                "    。。。。。。。。\n" +
                "}");
        int[] arr = { 12, 43, 34, 25 };
        text14_1 text14_1=new text14_1();
        System.out.println("则生成字符串为："+text14_1.join(arr));
    
        System.out.println("\n\n一个逗号分隔的字符串，例如 \n" +
                "  String s1 = \"12,43,34,25\";\n" +
                "现在写一个方法，根据这个字符串生成一个int[]");
    
        text14_2 text14_2=new text14_2();
        String s8 = "12,43,34,25";
        int[] aaa=text14_2.aaa(s8);
        System.out.print("转化的字符串为：");
        for (int i = 0; i < aaa.length ;i++) {
            System.out.print(aaa[i]+" ");
        }
        System.out.println("\n\n一个系统的登录密码为123456\n" +
                "写一个程序，让用户输入密码，如果密码不对，提示其再次输入。一共允许尝试3次。\n");
        String password="123456";
        int maxcishu=3;
        
        text14_3 text14_3=new text14_3();
        text14_3.window(password,maxcishu);
    
        System.out.println("\n\n在某公司员工年会上，要从87个员工中抽取3个一等奖。试写出算法。\n" +
                "令每个员工先领一个号码（1，2，...，87），抽中的上来领奖。\n");
        
        int min=1;
        int max=87;
        int renshu=3;
        text14_4 text14_4=new text14_4();
        System.out.print("中奖人为：");
        text14_4.xinchoujiang(min,max,renshu);
        for (int i = 0; i < text14_4.jiang.length; i++) {
            System.out.print(text14_4.jiang[i]+"号 ");
        }
    
        System.out.println("\n\n\n洗牌算法：有54张扑克牌，当每局开始之前，需要将它们随机打乱。\n" +
                "试写一个算法，将54张版的顺序打乱。\n" +
                "提示：假设将54张牌编号为0,1,2, .., 53 ，只需要输出一个随机的序列即可");
    
        text14_5 text14_5=new text14_5();
        System.out.print("洗好顺序：");
        text14_5.pukexipai();
//        for (int i = 0; i < text14_5.xihao.length; i++) {
//            System.out.print(text14_5.xihao[i]+" ");
//        }
        for (int i = 0; i < text14_5.pukexihao.length; i++) {
            System.out.print(text14_5.pukexihao[i]+" ");
        }
    
        System.out.println("\n\n创建一个自动出题程序，可以自动生成一些简单的加、减、乘算式\n" +
                "例如，\n" +
                "12 + 98 = ?\n" +
                "或 43 - 34 = ?\n" +
                "让用户输入答案，如果输入错误，则提示错误");
        text14_6 text14_6=new text14_6();
        text14_6.ti();
    }
}

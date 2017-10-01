/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-25
 * Time: 上午11:49
 */
public class text13 {
    public static void main(String[] args) {
        System.out.println("有一个类Example\n" +
                "里面有一个方法 getMax 用于求最大值。\n" +
                "问题：\n" +
                "（1）能否把getMax 声明为静态方法？  \n" +
                "（2）请改造 getMax 的写法，使之可以作为静态方法\n" +
                "public class Example\n" +
                "{\n" +
                "\tprivate int[] data = new int[16];\n" +
                "\tpublic Example()\n" +
                "\t{\n" +
                "\t\tfor(int i=0; i<data.length; i++)\n" +
                "\t\t{\n" +
                "\t\t\tdata[i] = -1;  \n" +
                "\t\t}\n" +
                "\t}\n" +
                "\t// 取最大值\n" +
                "\tpublic int getMax()\n" +
                "\t{\n" +
                "\t\tint max = 0;\n" +
                "\t\tfor(int i=0; i<data.length; i++)\n" +
                "\t\t{\n" +
                "\t\t\tif( data[i] > max)\n" +
                "\t\t\t{\n" +
                "\t\t\t\tmax = data[i];\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t\treturn max;\n" +
                "\t}\n" +
                "}");
        text13_1 text13_1=new text13_1();
        text13_1.data= new int[]{1, 3, 4, 5, 76, 76, 5, 12, 23, 5, 7, 8};
        System.out.println(text13_1+""+text13_1.getMax(text13_1.data));
        System.out.println("静态方法在JVM刚加载的时候就编译过了...在程序的运行过程中随时可以调用...不需要去实例化某个对象然后再去调用...可以直接用类名去调用...不过你想一下,在JVM刚加载的进修就编译过了..也就是说它一直存在着...也就是说它一直占用这内存中的地址空间...所以说也是比较占资源的噢!\n" +
                "\n" +
                "相对于静态方法而言,动态方法占的内存资源就少些...因为它是什么时候使用什么时候实例化...也就是说在不使用的时候它是不会占用资源的...相对与静态方法的缺点是它每次使用的时候都要进行实例化...也就是说比较麻烦一些了...\n" +
                "\n" +
                "各有各的优点与缺点...看情况..你觉得什么时候使用哪种方法方便就使用哪种!假如你要频繁地调用某一方法当然最好就不要老是实例化对象喽...不过一个方法你很少用..你要是用静态方法就太浪费空间资源了..你学得呢???");
        System.out.println("\n\n利用Math类的静态方法\n" +
                "求 \n" +
                "（1）   12的4次方的值\n" +
                "（2）   12.9308 的平方根");
        System.out.println("12的4次方的值:"+Math.pow(12, 4));
        System.out.println("12.9308 的平方根:"+Math.sqrt(12.9308));
    }
}

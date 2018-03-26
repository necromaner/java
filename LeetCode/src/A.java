/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-03-26
 *
 * @Description: java类作用描述
 * Time: 上午11:44
 */
public class A {
    public static void main(String[] args) {
        System.out.println(new A()==new A());
        String str1=new String("HelloWorld");
        String str2=new String("HelloWorld");
        System.out.println(str1==str2);
    }
}

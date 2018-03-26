package FirstDay_3_26;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-03-26
 *
 * @Description: java类作用描述
 * Time: 下午8:03
 */
/*
Java Enumeration接口

Enumeration接口中定义了一些方法，通过这些方法可以枚举（一次获得一个）对象集合中的元素。

这种传统接口已被迭代器取代，虽然Enumeration 还未被遗弃，但在现代代码中已经被很少使用了。尽管如此，它还是使用在诸如Vector和Properties这些传统类所定义的方法中，除此之外，还用在一些API类，并且在应用程序中也广泛被使用。 下表总结了一些Enumeration声明的方法：
序号 	方法描述
1 	boolean hasMoreElements( )
 测试此枚举是否包含更多的元素。
2 	Object nextElement( )
如果此枚举对象至少还有一个可提供的元素，则返回此枚举的下一个元素。
 */
public class T1_Enumeration {
    public static void main(String args[]){
        Enumeration<String> days;
        Vector<String> dayName=new Vector<String>();
        dayName.add("Sunday");
        dayName.add("Monday");
        dayName.add("Tuesday");
        dayName.add("Wednesday");
        dayName.add("Thursday");
        dayName.add("Friday");
        dayName.add("Saturday");
        
        System.out.println(dayName.size());
        //elements():返回此向量的组件的枚举。返回此向量的组件的枚举。返回的 Enumeration 对象将生成此向量中的所有项。生成的第一项为索引 0 处的项，然后是索引 1 处的项，依此类推。
        days=dayName.elements();
        while (days.hasMoreElements()){
            System.out.println(days.nextElement());
        }
        System.out.println(dayName);
        
        List<String> newDayName=new ArrayList<String>();
        newDayName.add("Sunday");
        newDayName.add("Monday");
        newDayName.add("Tuesday");
        newDayName.add("Wednesday");
        newDayName.add("Thursday");
        newDayName.add("Friday");
        newDayName.add("Saturday");
        System.out.println(newDayName.size());
        System.out.println(newDayName);
        for (int i = 0; i < newDayName.size(); i++) {
            System.out.print(newDayName.get(i)+" ");
        }
    }
}

package FirstDay_3_26;

import java.util.HashMap;
import java.util.Map;

/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-03-27
 *
 * @Description: java类作用描述
 * Time: 上午8:53
 */
/*
Dictionary 类是一个抽象类，用来存储键/值对，作用和Map类相似。

给出键和值，你就可以将值存储在Dictionary对象中。一旦该值被存储，就可以通过它的键来获取它。所以和Map一样， Dictionary 也可以作为一个键/值对列表。

Dictionary定义的抽象方法如下表所示：
序号 	方法描述
1 	Enumeration elements( )
返回此 dictionary 中值的枚举。
2 	Object get(Object key)
返回此 dictionary 中该键所映射到的值。
3 	boolean isEmpty( )
测试此 dictionary 是否不存在从键到值的映射。
4 	Enumeration keys( )
返回此 dictionary 中的键的枚举。
5 	Object put(Object key, Object value)
将指定 key 映射到此 dictionary 中指定 value。
6 	Object remove(Object key)
从此 dictionary 中移除 key （及其相应的 value）。
7 	int size( )
返回此 dictionary 中条目（不同键）的数量。

Dictionary类已经过时了。在实际开发中，你可以实现Map接口来获取键/值的存储功能。
 */
/*
Java Map 接口

Map接口中键和值一一映射. 可以通过键来获取值。

    给定一个键和一个值，你可以将该值存储在一个Map对象. 之后，你可以通过键来访问对应的值。
    当访问的值不存在的时候，方法就会抛出一个NoSuchElementException异常.
    当对象的类型和Map里元素类型不兼容的时候，就会抛出一个 ClassCastException异常。
    当在不允许使用Null对象的Map中使用Null对象，会抛出一个NullPointerException 异常。
    当尝试修改一个只读的Map时，会抛出一个UnsupportedOperationException异常。

序号 	方法描述
1 	void clear( )
 从此映射中移除所有映射关系（可选操作）。
2 	boolean containsKey(Object k)
如果此映射包含指定键的映射关系，则返回 true。
3 	boolean containsValue(Object v)
如果此映射将一个或多个键映射到指定值，则返回 true。
4 	Set entrySet( )
返回此映射中包含的映射关系的 Set 视图。
5 	boolean equals(Object obj)
比较指定的对象与此映射是否相等。
6 	Object get(Object k)
返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null。
7 	int hashCode( )
返回此映射的哈希码值。
8 	boolean isEmpty( )
如果此映射未包含键-值映射关系，则返回 true。
9 	Set keySet( )
返回此映射中包含的键的 Set 视图。
10 	Object put(Object k, Object v)
将指定的值与此映射中的指定键关联（可选操作）。
11 	void putAll(Map m)
从指定映射中将所有映射关系复制到此映射中（可选操作）。
12 	Object remove(Object k)
如果存在一个键的映射关系，则将其从此映射中移除（可选操作）。
13 	int size( )
返回此映射中的键-值映射关系数。
14 	Collection values( )
返回此映射中包含的值的 Collection 视图。
 */
public class T5_Dictionary {
    public static void main(String[] args) {
        Map map=new HashMap();
        map.put("Zara", "8");
        map.put("Mahnaz", "31");
        map.put("Ayan", "12");
        map.put("Daisy", "14");
        System.out.println(map);
//        1 	void clear( )
//        从此映射中移除所有映射关系（可选操作）。
        Map map1=new HashMap();
        map1.put("Zara", "8");
        System.out.println(map1);
        map1.clear();
        System.out.println(map1);
//        2 	boolean containsKey(Object k)
//        如果此映射包含指定键的映射关系，则返回 true。
        System.out.println(map.containsKey("Zara"));
        System.out.println(map.containsKey("8"));
//        3 	boolean containsValue(Object v)
//        如果此映射将一个或多个键映射到指定值，则返回 true。
        System.out.println(map.containsValue("Zara"));
        System.out.println(map.containsValue("8"));
//        4 	Set entrySet( )
//        返回此映射中包含的映射关系的 Set 视图。
        System.out.println("entrySet( ) "+map.entrySet());
//        5 	boolean equals(Object obj)
//        比较指定的对象与此映射是否相等。
        System.out.println(map+" "+map1);
        System.out.println(map.equals(map1));
        map1.put("Mahnaz", "31");
        map1.put("Ayan", "12");
        map1.put("Daisy", "14");
        map1.put("Zara", "8");
        System.out.println(map+" "+map1);
        System.out.println(map.equals(map1));
//        6 	Object get(Object k)
//        返回指定键所映射的值；如果此映射不包含该键的映射关系，则返回 null。
        System.out.println(map.get(1));
        System.out.println(map.get("Mahnaz"));
//        7 	int hashCode( )
//        返回此映射的哈希码值。
        System.out.println(map.hashCode());
//        8 	boolean isEmpty( )
//        如果此映射未包含键-值映射关系，则返回 true。
        map1.clear();
        System.out.println(map1.isEmpty());//无键为true
        System.out.println(map.isEmpty());//无键为true
//        9 	Set keySet( )
//        返回此映射中包含的键的 Set 视图。
        System.out.println("map.keySet()  "+map.keySet());//获取所有的key
//        10 	Object put(Object k, Object v)
//        将指定的值与此映射中的指定键关联（可选操作）。
//        11 	void putAll(Map m)
//        从指定映射中将所有映射关系复制到此映射中（可选操作）。
        Map map2=new HashMap();
        map2.put("qq",666);
        map2.putAll(map);
        System.out.println(map2);
//        12 	Object remove(Object k)
//        如果存在一个键的映射关系，则将其从此映射中移除（可选操作）。
        System.out.println(map2.remove("qq"));//移除键为qq，返回对应的值
        System.out.println(map2);
//        13 	int size( )
//        返回此映射中的键-值映射关系数。
        System.out.println(map.size());//长度
//        14 	Collection values( )
//        返回此映射中包含的值的 Collection 视图。
        System.out.println(map.values());//所有的值
    
    }
}

package FirstDay_3_26;

import java.util.BitSet;
import java.util.Scanner;

/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-03-26
 *
 * @Description: java类作用描述
 * Time: 下午8:35
 */
/*
Java Bitset类

一个Bitset类创建一种特殊类型的数组来保存位值。BitSet中数组大小会随需要增加。这和位向量（vector of bits）比较类似。

这是一个传统的类，但它在Java 2中被完全重新设计。

BitSet定义了两个构造方法。

第一个构造方法创建一个默认的对象：

BitSet()

第二个方法允许用户指定初始大小。所有位初始化为0。

BitSet(int size)

BitSet中实现了Cloneable接口中定义的方法如下表所列：
序号 	方法描述
1 	void and(BitSet set)
对此目标位 set 和参数位 set 执行逻辑与操作。
2 	void andNot(BitSet set)
清除此 BitSet 中所有的位，其相应的位在指定的 BitSet 中已设置。
3 	int cardinality( )
返回此 BitSet 中设置为 true 的位数。
4 	void clear( )
将此 BitSet 中的所有位设置为 false。
5 	void clear(int index)
将索引指定处的位设置为 false。
6 	void clear(int startIndex, int endIndex)
将指定的 fromIndex（包括）到指定的 toIndex（不包括）范围内的位设置为 false。
7 	Object clone( )
复制此 BitSet，生成一个与之相等的新 BitSet。
8 	boolean equals(Object bitSet)
将此对象与指定的对象进行比较。
9 	void flip(int index)
将指定索引处的位设置为其当前值的补码。
10 	void flip(int startIndex, int endIndex)
将指定的 fromIndex（包括）到指定的 toIndex（不包括）范围内的每个位设置为其当前值的补码。
11 	boolean get(int index)
返回指定索引处的位值。
12 	BitSet get(int startIndex, int endIndex)
返回一个新的 BitSet，它由此 BitSet 中从 fromIndex（包括）到 toIndex（不包括）范围内的位组成。
13 	int hashCode( )
返回此位 set 的哈希码值。
14 	boolean intersects(BitSet bitSet)
如果指定的 BitSet 中有设置为 true 的位，并且在此 BitSet 中也将其设置为 true，则返回 ture。
15 	boolean isEmpty( )
如果此 BitSet 中没有包含任何设置为 true 的位，则返回 ture。
16 	int length( )
返回此 BitSet 的"逻辑大小"：BitSet 中最高设置位的索引加 1。
17 	int nextClearBit(int startIndex)
返回第一个设置为 false 的位的索引，这发生在指定的起始索引或之后的索引上。
18 	int nextSetBit(int startIndex)
返回第一个设置为 true 的位的索引，这发生在指定的起始索引或之后的索引上。
19 	void or(BitSet bitSet)
对此位 set 和位 set 参数执行逻辑或操作。
20 	void set(int index)
将指定索引处的位设置为 true。
21 	void set(int index, boolean v)
 将指定索引处的位设置为指定的值。
22 	void set(int startIndex, int endIndex)
将指定的 fromIndex（包括）到指定的 toIndex（不包括）范围内的位设置为 true。
23 	void set(int startIndex, int endIndex, boolean v)
将指定的 fromIndex（包括）到指定的 toIndex（不包括）范围内的位设置为指定的值。
24 	int size( )
返回此 BitSet 表示位值时实际使用空间的位数。
25 	String toString( )
返回此位 set 的字符串表示形式。
26 	void xor(BitSet bitSet)
对此位 set 和位 set 参数执行逻辑异或操作。
 */
public class T2_Bitset {
    public static void main(String[] args) {
        BitSet bitSet1=new BitSet(1);
        BitSet bitSet2=new BitSet(16);
        for(int i=0; i<16; i++) {
            if((i%2) == 0) bitSet1.set(i);
            if((i%5) != 0) bitSet2.set(i);
        }
        System.out.println("bitSet1 : "+bitSet1);
        System.out.println("bitSet2 : "+bitSet2);
        Scanner sb = new Scanner(System.in);
        System.out.print("输入执行项目：");
        int x= Integer.parseInt(sb.next());
        
        switch (x){
            case 1:
                System.out.println("1.1 void and(BitSet set)");
                bitSet1.and(bitSet2);//bitSet1和bitSet2的交集，且
                System.out.println(bitSet1);
                break;
            case 2:
                System.out.println("1.2 void or(BitSet set)");
                bitSet1.or(bitSet2);//bitSet1和bitSet2的并集，或
                System.out.println(bitSet1);
                break;
            case 3:
                System.out.println("1.3 void xor(BitSet set)");
                bitSet1.xor(bitSet2);//bitSet1和bitSet2的补集，非
                System.out.println(bitSet1);
                break;
            case 4:
                System.out.println("2.1 void andNot(BitSet set)");
                bitSet1.andNot(bitSet2);//bitSet1有、bitSet2没有的
                System.out.println(bitSet1);
                break;
            case 5:
                System.out.println("3 int cardinality( )");
                System.out.println(bitSet1.cardinality());//返回bitSet1的长度
                break;
            case 6:
                System.out.println("4 void clear( )");
                bitSet1.clear();//删除所有
                System.out.println(bitSet1);
                break;
            case 7:
                System.out.println("5 void clear(int index)");
                bitSet1.clear(2);//删除2（2位置变为flace)
                System.out.println(bitSet1);
                break;
            case 8:
                System.out.println("6 void clear(int startIndex, int endIndex)");
                bitSet1.clear(2,9);//删除从2到8（2到8位置变为flace）不包括9
                System.out.println(bitSet1);
                break;
            case 9:
                System.out.println("7 Object clone( )");
                BitSet bitSet3= (BitSet) bitSet1.clone();//复制
                System.out.println(bitSet3);
                break;
            case 10:
                System.out.println("8 boolean equals(Object bitSet)");
                BitSet bitSet4= (BitSet) bitSet1.clone();//复制
                System.out.println(bitSet1.equals(bitSet4));//判断相等
                break;
            case 11:
                System.out.println("9 void flip(int index)");
                bitSet1.flip(1);//1位反转（true->flace||flace->true)
                System.out.println(bitSet1);
                break;
            case 12:
                System.out.println("10 void flip(int startIndex, int endIndex)");
                bitSet1.flip(1,7);//1到6位反转（true->flace||flace->true)不包括7
                System.out.println(bitSet1);
                break;
            case 13:
                System.out.println("11 boolean get(int index)");
                System.out.println(bitSet1.get(1));
                break;
            case 14:
                System.out.println("12 BitSet get(int startIndex, int endIndex)");
                BitSet bitSet5=bitSet1.get(2,8);//不明白
                break;
            case 15:
                System.out.println("13 int hashCode( )");
                System.out.println(bitSet1.hashCode());
                break;
            case 16:
                System.out.println("14 boolean intersects(BitSet bitSet)");
                System.out.println(bitSet1.intersects(bitSet2));//有一样为true
                
                break;
            case 17:
                System.out.println("15 boolean isEmpty( )");
                System.out.println(bitSet1.isEmpty());
                bitSet1.clear();
                System.out.println(bitSet1.isEmpty());//无true时为true
                break;
            case 18:
                System.out.println("16 int length( )");
                System.out.println(bitSet1.length());
                break;
            case 19:
                System.out.println("17 int nextClearBit(int startIndex)");
                System.out.println(bitSet1.nextClearBit(3));//从3开始第一个flace位置
                break;
            case 20:
                System.out.println("18 int nextSetBit(int startIndex)");
                System.out.println(bitSet1.nextSetBit(3));//从3开始第一个true位置
                break;
            case 21:
                System.out.println("20 void set(int index)");
                bitSet1.set(1);//设置1位为ture
                System.out.println(bitSet1);
                break;
            case 22:
                System.out.println("21 void set(int index, boolean v)");
                bitSet1.set(1,true);//设置1位为ture
                System.out.println(bitSet1);
                break;
            case 23:
                System.out.println("22 void set(int startIndex, int endIndex)");
                bitSet1.set(1,7);//1到6位设置为true,不包括7
                System.out.println(bitSet1);
                break;
            case 24:
                System.out.println("23 void set(int startIndex, int endIndex, boolean v)");
                bitSet1.set(1,7,false);//1到6位设置为flace,不包括7
                System.out.println(bitSet1);
                break;
            case 25:
                System.out.println("24 int size( )");
                System.out.println(bitSet1+" "+bitSet1.size());//返回此 BitSet 表示位值时实际使用空间的位数。
                System.out.println(bitSet2+" "+bitSet2.size());//64=16*4
                break;
            case 26:
                System.out.println("25 String toString( )");
                System.out.println(bitSet1.toString());
                break;
            default:
                    System.out.println("");
        }
    }
}

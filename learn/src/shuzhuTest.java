/**
 * Description:
 * User: necromaner
 * Date: 2018-01-03
 * Time: 下午1:24
 */
/*
现在要求定义一个数组（整形数据）的操作类，在这个类中有如下几个要求：
	该数组的大小与类创建对象的时候动态决定；
	可以通过类向数组中进行数据的保存，保存的时候需要考虑到数组的大小问题；
	如果发现数组空间不足，则可以进行数组长度的动态扩充；
	可以取得数组的全部数据(增加顺序)。
而后在这一基础之上要求继续扩展两个派生类：
	可以进行数组的排序处理；
	可以进行数组的反转处理。
 */
/*
如果要进行排序的处理操作，那么肯定在取得了全部数据的时候里面的内容应该是排序好的，同时在该类操作的过程之中应该继续具备：数据追加、数组扩充、取得全部数据（父类中的getDate（）方法最为一个获取数据的标准。这个方法应该继续保留）。
 */
/*
反转子类的最大特点在于，取得的数据是其保存顺序的相反内容。整体的实现风格实际上和排序数组子类是一样的。
 */
class Array{//定义一个专门进行数组的操作类
    private int foot=0;//进行数组数据的脚标操作
    private int data[];//定义一个整型数组，大小由外部决定
    public Array(int len){//如果要想使用Array类必须设置数组大小
        if (len>0)//一个正常的数组大小
            this.data=new int[len];//开辟新数组
        else
            this.data=new int[1];//开辟1个空间
    }
    //动态扩展，如果此处传入了一个3，则表示在已有的基础上数组长度追加3
    public void inc(int num){
        int[] newData=new int[this.data.length+num];
//        for (int i = 0; i < this.data.length; i++) {
//            newData[i]=this.data[i];
//        }
        System.arraycopy(this.data,0,newData,0,this.data.length);
        this.data=newData;//改变原始数组指向
    }
    //该方法主要的功能是向数组里面进行数据的保存
    public boolean add(int num){
        if (this.foot>=this.data.length){//没空间类
            return false;
        }
        //先进行数组的数据保存，而后foot的内容加1
        this.data[this.foot ++]=num;
        return true;
    }
    public int[] getData(){//取得全部数组数据
        return this.data;//返回数组内容
    }
}
//这个可以直接继承父类中的所有已经存在的操作方法
class SortArray extends Array{
    //父类之中现在并没有无参构造方法，所以此时的子类必须明确的调用父类中的构造方法
    public SortArray(int num){
        super(num);//父类中支持数组创建了
    }
    //父类中的取得数据的方法名称很标准，但是功能不足，又希望继续使用这个方法名称，那么就需要对方法进行扩充，扩充就是方法覆写的核心作用。
    public int[] getData(){
        java.util.Arrays.sort(super.getData());
        return super.getData();
    }
}
class RecerseArray extends Array{
    public RecerseArray(int num){
        super(num);
    }
    public int[] getData(){
        int center=super.getData().length/2;
        int head=0;
        int tail=super.getData().length-1;
        for (int i = 0; i < center; i++) {
            int temp=super.getData()[i];
            super.getData()[i]=super.getData()[super.getData().length-1-i];
            super.getData()[super.getData().length-1-i]=temp;
        }
        return super.getData();
    }
}
public class shuzhuTest {
    public static void main(String[] args) {
        Array array=new Array(5);
        System.out.println(array.add(77));
        System.out.println(array.add(4));
        System.out.println(array.add(66));
        System.out.println(array.add(6));
        System.out.println(array.add(99));
        System.out.println(array.add(8));
        int result[]=array.getData();
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i+1<result.length)
                System.out.print("、");
            else
                System.out.println("");
        }
        array.inc(3);
    
        System.out.println(array.add(90));
        System.out.println(array.add(10));
        System.out.println(array.add(67));
        System.out.println(array.add(12));
        int result1[]=array.getData();
        for (int i = 0; i < result1.length; i++) {
            System.out.print(result1[i]);
            if (i+1<result1.length)
                System.out.print("、");
            else
                System.out.println("");
        }
        SortArray sortArray=new SortArray(array.getData().length);
        System.out.println(sortArray.add(90));
        System.out.println(sortArray.add(10));
        System.out.println(sortArray.add(67));
        System.out.println(sortArray.add(12));
        int result2[]=sortArray.getData();
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i]);
            if (i+1<result2.length)
                System.out.print("、");
            else
                System.out.println("");
        }
        RecerseArray recerseArray=new RecerseArray(4);
        System.out.println(recerseArray.add(90));
        System.out.println(recerseArray.add(10));
        System.out.println(recerseArray.add(67));
        System.out.println(recerseArray.add(12));
        int result3[]=recerseArray.getData();
        for (int i = 0; i < result3.length; i++) {
            System.out.print(result3[i]);
            if (i+1<result3.length)
                System.out.print("、");
            else
                System.out.println("");
        }
    }
}

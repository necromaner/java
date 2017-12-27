package chuandi;
//String是引用类型，不应该按照基本数据类型那样进行分析，应该按照引用类型进行分析
public class test2{
    public static void main(String[] args) {
        String str="hello";
        fun(str);
        System.out.println(str);
        
    }
    public static void fun(String temp){
        temp="world";
    }

}

package FirstDay_3_26;

import java.util.Stack;

/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-03-27
 *
 * @Description: java类作用描述
 * Time: 上午8:28
 */
/*
栈是Vector的一个子类，它实现了一个标准的后进先出的栈。

堆栈只定义了默认构造函数，用来创建一个空栈。 堆栈除了包括由Vector定义的所有方法，也定义了自己的一些方法。

Stack()

除了由Vector定义的所有方法，自己也定义了一些方法：
序号 	方法描述
1 	boolean empty()
测试堆栈是否为空。
2 	Object peek( )
查看堆栈顶部的对象，但不从堆栈中移除它。
3 	Object pop( )
移除堆栈顶部的对象，并作为此函数的值返回该对象。
4 	Object push(Object element)
把项压入堆栈顶部。
5 	int search(Object element)
返回对象在堆栈中的位置，以 1 为基数。
 */
public class T4_Stack {
    static void StackPush(Stack<Integer> stack,Integer num){
        stack.push(num);
        System.out.println("push: "+num);
        System.out.println("stack: "+stack);
    }
    static void StackPop(Stack<Integer> stack){
        System.out.println("stack:"+stack);
        if (!stack.empty()){
            System.out.println("peek:"+stack.peek());
//            Integer a = (Integer) stack.pop();
//            System.out.println(a);
            stack.pop();
            System.out.println(stack);
        }else System.out.println("error");
    }
    public static void main(String[] args) {
        Stack<Integer> stack=new Stack<>();
        System.out.println(stack.empty()+"-"+stack);//空为true
        StackPush(stack,12);
        StackPush(stack,32);
        StackPush(stack,52);
        StackPop(stack);
        StackPop(stack);
        StackPop(stack);
        StackPop(stack);
        StackPush(stack,12);
        StackPush(stack,32);
        StackPush(stack,52);
        System.out.println(stack.search(32));//length
    }
}

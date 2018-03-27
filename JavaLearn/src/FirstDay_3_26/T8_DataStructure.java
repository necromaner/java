package FirstDay_3_26;

/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-03-27
 *
 * @Description: java类作用描述
 * Time: 上午11:37
 */
/*
https://blog.csdn.net/zhangerqing/article/details/8796518
 */
public class T8_DataStructure {
    public static void main(String[] args) {
        System.out.println("基础数据结构:");
        int a[];//栈
        int[] b;
//        int []c;
        a = new int[10];//堆
        int c[] = {2, 3, 6, 10, 99};
        int[] d = new int[10];
        int e[] = new int[10];
        System.out.println("数组:");
//        我们可以通过下标来检索数组。下面我举个简单的例子，来说明下数组的用法。
        String name[];
        name = new String[5];
        name[0] = "egg";
        name[1] = "erqing";
        name[2] = "baby";
        for (int i = 0; i < name.length; i++) {
            if (name[i] != null)
                System.out.print(name[i]);
            else break;
            if (i < name.length - 1)
                if (name[i + 1] != null)
                    System.out.print("---");
        }
        System.out.println("");
        for (String i:name) {
            System.out.print(i+"   ");
        }
        System.out.println("");
//        这是最简单的数组声明、创建、赋值、遍历的例子，下面写个增删的例子。
        int value[] = new int[10];
        for (int i = 0; i < 10; i++) {
            value[i] = i;
        }
    
        // traverse(value);
        // insert(value, 666, 5);
        traverse(value);
        System.out.println(traverse1(value));
        value=delete(value, 2);
        traverse(value);
        value=delete(value, 2,3);
        traverse(value);
        value=insert(value,5,3);
        traverse(value);
    
        System.out.println("单链表:");
        LinkedList linkedList=new LinkedList();
        linkedList.addHead(1);
        linkedList.addTail(2);
        linkedList.addTail(3);
        linkedList.addTail(4);
        linkedList.addTail(9);
        linkedList.addTail(8);
        linkedList.traverse();
        linkedList.addFromHead(10);
        linkedList.traverse();
        linkedList.addFromTail(20);
        linkedList.traverse();
        linkedList.removeFromHead();
        linkedList.traverse();
        linkedList.removeFromTail();
        linkedList.traverse();
        linkedList.insert(3,100);
        linkedList.traverse();
        linkedList.remove(4);
        linkedList.traverse();
        System.out.println(linkedList.indexOf(100));
        System.out.println(linkedList.contains(4));
    
        System.out.println("队列:");
        /*
        队列是一个常用的数据结构，是一种先进先出（First In First Out, FIFO）的结构，也就是说只能在表头进行删除，在表尾进行添加，下面我们实现一个简单的队列。
        队列只能在表头进行删除，在表尾进行增加，这种结构的特点，适用于排队系统。
         */
        Queue queue=new Queue();
        queue.add("a");
        queue.add("b");
        queue.add("c");
        queue.add("d");
        queue.add("e");
        System.out.println(queue.element());
        queue.remove();
        System.out.println(queue.element());
        System.out.println(queue);
        System.out.println("栈:");
        /*
        栈是一种后进先出（Last In First Out，LIFO）的数据结构，我们采用单链表实现一个栈。
         */
        Stack stack=new Stack();
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);
        stack.push(55);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);
        
        System.out.println(stack.search(22));
    }
    public static int[] insert(int[] old,int value,int index){//插入
        int[] n=new int[old.length+1];
        for (int i = 0; i < n.length; i++) {
            if (i<index)
                n[i]=old[i];
            else if (i==index)
                n[i]=value;
            else
                n[i]=old[i-1];
        }
        return n;
    }
//    public static int[] insert(int[] old, int value, int index) {
//        for (int k = old.length - 1; k > index; k--)
//            old[k] = old[k - 1];
//        old[index] = value;
//        return old;
//    }


    public static void traverse(int data[]) {//输出
        for (int j = 0; j < data.length; j++) {
            System.out.print(data[j]);
            if (j<data.length-1)
                System.out.print("-");
        }
        System.out.println();
    }
    
    public static String traverse1(int data[]) {
        StringBuffer sb=new StringBuffer("[");
        for (int i:data) {
            sb.append(i+", ");
        }
        return sb.delete(sb.length()-2,sb.length()).append("]").toString();
    }
    ////    public static void traverse(int data[]) {
//        for (int j = 0; j < data.length; j++)
//            System.out.print(data[j] + " ");
//        System.out.println();
//    }
    
    public static int[] delete(int[] old, int index) {//删除一个元素
        int[] n=new int[old.length-1];
        for (int i = 0; i < n.length; i++) {
            if (i<index)
                n[i]=old[i];
            else
                n[i]=old[i+1];
        }
        return n;
    }
    public static int[] delete(int[] old, int index,int l) {//删除多个元素
        if (l<1)
            return old;
        int[] n=new int[old.length-l];
        for (int i = 0; i < n.length; i++) {
            if (i<index)
                n[i]=old[i];
            else
                n[i]=old[i+l];
        }
        return n;
    }
//    public static int[] delete(int[] old, int index) {
//        for (int h = index; h < old.length - 1; h++) {
//            old[h] = old[h + 1];
//        }
//        old[old.length - 1] = 0;
//        return old;
//    }
}

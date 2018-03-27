package FirstDay_3_26;
import java.util.Arrays;
/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-03-27
 *
 * @Description: java类作用描述
 * Time: 下午2:17
 */
public class Queue<T> {
    private int DEFAULT_SIZE = 10;
    
    private int capacity;//长度
    
    private Object[] elementData;
    
    private int front = 0;//前面
    private int rear = 0;//后面
    //重载
    public Queue()
    {
        capacity = DEFAULT_SIZE;//默认10个长度
        elementData = new Object[capacity];//构造函数初始化一个类
    }
    
    public Queue(T element)
    {
        this();//无参
        elementData[0] = element;
        rear++;
    }
    
    public Queue(T element , int initSize)
    {
        this.capacity = initSize;
        elementData = new Object[capacity];
        elementData[0] = element;
        rear++;
    }
    
    public int size()//长度
    {
        return rear - front;
    }
    
    public void add(T element)
    {
        if (rear > capacity - 1)
        {
            throw new IndexOutOfBoundsException("the queue is full!");
        }
        elementData[rear++] = element;
    }
    
    public T remove()//移除最前面的
    {
        if (empty())//空执行
        {
            throw new IndexOutOfBoundsException("queue is empty");
        }
        
        @SuppressWarnings("unchecked")
        T oldValue = (T)elementData[front];
        
        elementData[front++] = null;//前面设置为null,前索引再加1
        return oldValue;
    }
    
    @SuppressWarnings("unchecked")
    public T element()//返回第一个元素，空则打印queue is empty
    {
        if (empty())
        {
            throw new IndexOutOfBoundsException("queue is empty");
        }
        return (T)elementData[front];
    }
    
    public boolean empty()//空为ture,不空为false
    {
        return rear == front;
    }
    
    public void clear()
    {
        
        Arrays.fill(elementData , null);
        front = 0;
        rear = 0;
    }
    public String toString()//返回该对象的字符串表示
    {
        if (empty())
        {
            return "[]";
        }
        else
        {
            //String适用于不经常改变的，String 是不可变的对象
            //StringBuilder适合经常改变的
            StringBuilder sb = new StringBuilder("[");
            for (int i = front  ; i < rear ; i++ )
            {
                sb.append(elementData[i].toString() + ", ");//此toString()为Object类里的方法
            }
            int len = sb.length();
            return sb.delete(len - 2 , len).append("]").toString();//删除最后两位（"， "）再添加"]"
        }
    }
    public static void main(String[] args){
        Queue<String> queue = new Queue<String>("ABC", 20);
        queue.add("DEF");
        queue.add("egg");
        System.out.println(queue.empty());
        System.out.println(queue.size());
        System.out.println(queue.element());
        queue.clear();
        System.out.println(queue.empty());
        System.out.println(queue.size());
    }
}

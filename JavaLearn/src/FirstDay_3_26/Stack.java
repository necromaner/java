package FirstDay_3_26;

/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-03-27
 *
 * @Description: java类作用描述
 * Time: 下午2:57
 */
public class Stack<T> {
    static class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
        
        Node(T data) {
            this(data, null);
        }
    }
    
    @SuppressWarnings("rawtypes")
    static LinkedList list = new LinkedList();
    
    @SuppressWarnings("unchecked")
    public T push(T item) {
        list.addFromHead(item);//头前添加
        return item;
    }
    
    public void pop() {//删除头
        list.removeFromHead();
    }
    
    public boolean empty() {//判断是否为空
        return list.isEmpty();
    }
    
    public int search(T t) {//找对应位置
        return list.indexOf(t);
    }
    
    @Override
    public String toString() {
        return list.toString();
    }
    
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        System.out.println(stack.empty());
        stack.push("abc");
        stack.push("def");
        stack.push("egg");
        stack.pop();
        System.out.println(stack.search("def"));
    }
}

package FirstDay_3_26;

/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-03-27
 *
 * @Description: java类作用描述
 * Time: 下午12:17
 */
public class LinkedList<T> {
    
    /**
     * class node
     * @author egg
     * @param <T>
     */
    private static class Node<T> {
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
    
    // data
    private Node<T> head, tail;
    
    public LinkedList() {
        head = tail = null;
    }
    
    /**
     * judge the list is empty
     */
    public boolean isEmpty() {//判断是否为空，空->ture
        return head == null;
    }
    
    /**
     * add head node
     */
    public void addHead(T item) {//添加头节点
        head = new Node<T>(item);
        if (tail == null)
            tail = head;
    }
    
    /**
     * add the tail pointer
     */
    public void addTail(T item) {//添加尾指针,有头后面加，没头加头
        if (!isEmpty()) {
            tail.next = new Node<T>(item);
            tail = tail.next;
        } else {
            head = tail = new Node<T>(item);
        }
    }
    /**
     * print the list
     */
    public void traverse() {//打印
        if (isEmpty()) {
            System.out.println("null");
        } else {
//            for (Node<T> p = head; p != null; p = p.next)
//                System.out.println(p.data);
            for (Node<T> p = head; p != null; p = p.next){
                System.out.print(p.data);
                if (p.next!=null)
                    System.out.print("-");
            }
            System.out.println("");
        }
    }
    
    /**
     * insert node from head
     */
    public void addFromHead(T item) {//头前插入
        Node<T> newNode = new Node<T>(item);
        newNode.next = head;
        head = newNode;
    }
    
    /**
     * insert node from tail
     */
    public void addFromTail(T item) {//尾后插入
        Node<T> newNode = new Node<T>(item);
        Node<T> p = head;
        while (p.next != null)
            p = p.next;
        p.next = newNode;
        newNode.next = null;//释放内存
    }
    
    /**
     * delete node from head
     */
    public void removeFromHead() {//删除头
        if (!isEmpty())
            head = head.next;
        else
            System.out.println("The list have been emptied!");
    }
    
    /**
     * delete frem tail, lower effect
     */
    public void removeFromTail() {//删除尾部
        Node<T> prev = null, curr = head;
        while (curr.next != null) {
            prev = curr;
            curr = curr.next;
            if (curr.next == null)
                prev.next = null;
        }
    }
    
    /**
     * insert a new node
     * @param appointedItem
     * @param item
     * @return
     */
    public boolean insert(T appointedItem, T item) {//插入(位置，内容）
        Node<T> prev = head, curr = head.next, newNode;
        newNode = new Node<T>(item);
        if (!isEmpty()) {
            while ((curr != null) && (!appointedItem.equals(curr.data))) {//不为空且appointedItem值不等于位置的索引值,找到插入点
                prev = curr;
                curr = curr.next;
            }
            newNode.next = curr;
            prev.next = newNode;
            return true;
        }
        return false;
    }
    
    public void remove(T item) {//移除指定内容
        Node<T> curr = head, prev = null;
        boolean found = false;
        while (curr != null && !found) {
            if (item.equals(curr.data)) {//找到删除的位置
                if (prev == null)//是头执行删除头的
                    removeFromHead();
                else
                    prev.next = curr.next;
                found = true;
            } else {
                prev = curr;//前一位
                curr = curr.next;//当前位
            }
        }
    }
    
    
    public int indexOf(T item) {//找对应位置
        int index = 0;
        Node<T> p;
        for (p = head; p != null; p = p.next) {
            if (item.equals(p.data))
                return index;
            index++;
        }
        return -1;
    }
    
    /**
     * judge the list contains one data
     */
    public boolean contains(T item) {//判断是否有这个内容
        return indexOf(item) != -1;
    }
}
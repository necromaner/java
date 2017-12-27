package chuandi;

/**
 * Description:
 * User: necromaner
 * Date: 2017-12-27
 * Time: 下午6:03
 */
class Message{
    private int num;
    
    public void setNum(int num) {
        this.num = num;
    }
    
    public int getNum() {
        return num;
    }
}
public class test1 {
    public static void main(String[] args) {
        Message msg=new Message();
        msg.setNum(100);
        fun(msg);
        System.out.println(msg.getNum());
    }
    public static void fun(Message temp){
        temp.setNum(30);
    }
    
}

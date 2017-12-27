package chuandi;

/**
 * Description:
 * User: necromaner
 * Date: 2017-12-27
 * Time: 下午6:04
 */
class Message1{
    private String note;
    public void setNote(String note) {
        this.note = note;
    }
    public String getNote() {
        return this.note;
    }
}
public class test3 {
    public static void main(String[] args) {
        Message1 msg=new Message1();
        msg.setNote("hello");
        fun(msg);
        System.out.println(msg.getNote());
    }
    public static void fun(Message1 temp){
        temp.setNote("world");
    }
}

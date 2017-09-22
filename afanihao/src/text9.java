/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-09-22
 * Time: 下午4:08
 */
public class text9 {
    public static void main(String[] args) {
        System.out.println("public是什么意思? private是什么意思？");
        System.out.println("public: 公开的。表示这个属性或方法可以被外部访问\n" +
                "private: 拥有的。表示这个属性或方法不能被外部访问。");
    
    
        System.out.println("\n\n什么情况下应该设为private ?  ");
        System.out.println("默认所有的属性和方法都应该设为 private。\n" +
                "当外部需要调用它时，把它改成 public。\n" +
                "\n");
    
    
        System.out.println("\n\n一本书，有以下属性：\n" +
                "书名\n" +
                "作者\n" +
                "ISBN\n" +
                "出版社\n" +
                "请给它的所有的属性添加Getter 和 Setter");
        text9_1 text9_1=new text9_1();
        text9_1.setTitle("小书");
        text9_1.setAuthor("小人");
        text9_1.setISBN("666");
        text9_1.setPress("小出版社");
        System.out.println("书名:"+text9_1.getTitle()+"  作者:"+text9_1.getAuthor()+"  ISBN:"+text9_1.getISBN()+"  出版社:"+text9_1.getPress());
    
    
        System.out.println("\n\n什么叫封装？");
        System.out.println("封装就是：\n" +
                "把不该让用户看到的用 private 修饰\n" +
                "把应该让用户看到的用 public  修饰");
    }
}

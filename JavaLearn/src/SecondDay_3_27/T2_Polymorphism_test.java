package SecondDay_3_27;

/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-03-28
 *
 * @Description: java类作用描述
 * Time: 下午4:54
 */
/*
花木兰替父从军
大家都知道花木兰替父从军的例子，花木兰替父亲花弧从军。那么这时候花木兰是子类，花弧是父类。花弧有自己的成员属性年龄，姓名，性别。花木兰也有这些属性，但是很明显二者的属性完全不一样。花弧有自己的非静态成员方法‘骑马杀敌’，同样花木兰也遗传了父亲一样的方法‘骑马杀敌’。花弧还有一个静态方法‘自我介绍’，每个人都可以问花弧姓甚名谁。同时花木兰还有一个自己特有的非静态成员方法‘涂脂抹粉’。但是，现在花木兰替父从军，女扮男装。这时候相当于父类的引用（花弧这个名字）指向了子类对象（花木兰这个人），那么在其他类（其他的人）中访问子类对象（花木兰这个人）的成员属性（姓名，年龄，性别）时，其实看到的都是花木兰她父亲的名字（花弧）、年龄（60岁）、性别（男）。当访问子类对象（花木兰这个人）的非静态成员方法（骑马打仗）时，其实都是看到花木兰自己运用十八般武艺在骑马打仗。当访问花木兰的静态方法时（自我介绍），花木兰自己都是用她父亲的名字信息在向别人作自我介绍。并且这时候花木兰不能使用自己特有的成员方法‘涂脂抹粉’。-----多态中的向上转型
 那么终于一将功成万骨枯，打仗旗开得胜了，花木兰告别了战争生活。有一天，遇到了自己心爱的男人，这时候爱情的力量将父类对象的引用（花弧这个名字）强制转换为子类对象本来的引用（花木兰这个名字），那么花木兰又从新成为了她自己，这时候她完全是她自己了。名字是花木兰，年龄是28，性别是女，打仗依然那样生猛女汉子，自我介绍则堂堂正正地告诉别人我叫花木兰。OMG！终于，终于可以使用自己特有的成员方法‘涂脂抹粉’了。从此，花木兰完全回到了替父从军前的那个花木兰了。并且和自己心爱的男人幸福的过完了一生。-----多态中的向下转型
 */
public class T2_Polymorphism_test {
    public static void main(String[] args) {
        Father huahu=new Daughter();
        System.out.println("姓名："+huahu.name);
        System.out.println("年龄："+huahu.age);
        System.out.println("性别："+huahu.sex);
        huahu.onHorsebackKilling();
        huahu.toIntroduceMyself();
        Daughter huamulan=(Daughter)huahu;
        System.out.println("姓名："+huamulan.name);
        System.out.println("年龄："+huamulan.age);
        System.out.println("性别："+huamulan.sex);
        huamulan.onHorsebackKilling();
        huamulan.toIntroduceMyself();
        
    }
}
class Father{
    String name="花弧";
    int age=60;
    String sex="男";
    public void onHorsebackKilling(){
        System.out.println("雄壮的杀人");
    }
    public static void toIntroduceMyself(){
        System.out.println("我是花弧");
    }
}
class Daughter extends Father{
    String name="花木兰";
    int age=18;
    String sex="女";
    public void onHorsebackKilling(){
        System.out.println("纤细的杀人");
    }
    public static void toIntroduceMyself(){
        System.out.println("我是花木兰");
    }
    public void whitewash(){
        System.out.println("涂脂抹粉");
    }
}
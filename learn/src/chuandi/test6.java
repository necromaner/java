package chuandi;

/**
 * Description:
 * User: necromaner
 * Date: 2017-12-28
 * Time: 下午10:48
 */
/*
定义一个学生选课的操作表：三张数据表：
    学生表：学生编号、姓名、年龄；
    课程表：课程编号、课程名称、学分；
    学生—课程关系表：学生编号、课程编号、成绩。
要求：可以实现如下的信息输出：
    可以找到一门课程，以及参加此课程的所有的学生信息，和他的成绩
    可以根据一个学生，找到所参加的所有课程和每门课程的成绩
    
1、定义出基本类，暂时不考虑所有的关系。
2、一个学生有多门课，一门课程有多个学生，所有应该互相保存有各自的对象数组
3、学生和每门课程之间都会有一个成绩。现在发现关系表里面不光有关系字段还有一个普通字段，那么应该再建立一个类。
4、要进行操作的实现
 */
class Student{
    private int stuid;
    private String name;
    private int age;
//    private Course[] courses;
    private StudentCourse[] studentCourses;
    public Student(){}
    public Student(int stuid,String name,int age){
        this.stuid=stuid;
        this.name=name;
        this.age=age;
    }
    
//    public Course[] getCourses() {
//        return courses;
//    }
//
//    public void setCourses(Course[] courses) {
//        this.courses = courses;
//    }
    
    public StudentCourse[] getStudentCourses() {
        return studentCourses;
    }
    
    public void setStudentCourses(StudentCourse[] studentCourses) {
        this.studentCourses = studentCourses;
    }
    
    public String getInfo() {
        return "Student{" +
                "stuid=" + stuid +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class Course{
    private int cid;
    private String name;
    private int credit;
//    private Student[] students;
    private StudentCourse[] studentCourses;
    public Course(){}
    public Course(int cid,String name,int credit){
        this.cid=cid;
        this.name=name;
        this.credit=credit;
    }
    
//    public Student[] getStudents() {
//        return students;
//    }
//
//    public void setStudents(Student[] students) {
//        this.students = students;
//    }
    
    public StudentCourse[] getStudentCourses() {
        return studentCourses;
    }
    
    public void setStudentCourses(StudentCourse[] studentCourses) {
        this.studentCourses = studentCourses;
    }
    
    public String getInfo() {
        return "Course{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                '}';
    }
}
class StudentCourse{
    private Student student;
    private Course course;
    private double score;
    public StudentCourse(){}
    
    public Student getStudent() {
        return student;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public double getScore() {
        return score;
    }
    
    public StudentCourse(Student student, Course course, double score){
        this.student=student;
        this.course=course;
        this.score=score;
        
    }
}
public class test6 {
    public static void main(String[] args) {
        //第一步：根据结构j进行关系的设置
        //1、创建各自的独立对象
        Student stu1=new Student(1,"1号",18);
        Student stu2=new Student(2,"2号",28);
        Student stu3=new Student(3,"3号",38);
        Course ca=new Course(001,"课程1",1);
        Course cb=new Course(002,"课程2",2);
        Course cc=new Course(003,"课程3",3);
        //2、设置学生和课程的关系，这里面需要准备出成绩
        stu1.setStudentCourses(new StudentCourse[]{
                new StudentCourse(stu1,ca,90),
                new StudentCourse(stu1,cb,99.1),
                new StudentCourse(stu1,cc,100.0),
        });
        stu2.setStudentCourses(new StudentCourse[]{
                new StudentCourse(stu2,ca,60),
                new StudentCourse(stu2,cb,50),
        });
        stu3.setStudentCourses(new StudentCourse[]{
                new StudentCourse(stu3,ca,100),
                new StudentCourse(stu3,cc,0),
        });
        //3、设置课程和学生的关系
        ca.setStudentCourses(new StudentCourse[]{
                new StudentCourse(stu1,ca,90),
                new StudentCourse(stu2,ca,60),
                new StudentCourse(stu3,ca,100),
        });
        cb.setStudentCourses(new StudentCourse[]{
                new StudentCourse(stu1,cb,99.1),
                new StudentCourse(stu2,cb,50),
        });
        cc.setStudentCourses(new StudentCourse[]{
                new StudentCourse(stu1,cc,100.0),
                new StudentCourse(stu3,cc,0),
        });
        //第二步：根据结构取出数据
        //1、可以找到一门课程，以及参加此课程的所有的学生信息，和他的成绩
        System.out.println(ca.getInfo());
        for (int i = 0; i < ca.getStudentCourses().length; i++) {
            System.out.print(ca.getStudentCourses()[i].getStudent().getInfo());
            System.out.println("  成绩 ：  "+ca.getStudentCourses()[i].getScore());
        }
        System.out.println("========================================================================");
        //2、可以根据一个学生，找到所参加的所有课程和每门课程的成绩
        System.out.println(stu1.getInfo());
        for (int i = 0; i < stu1.getStudentCourses().length; i++) {
            System.out.print(stu1.getStudentCourses()[i].getCourse().getInfo());
            System.out.println(" 成绩 ：   "+stu1.getStudentCourses()[i].getScore());
        }
    }
    //这些关系的开发模式必须灵活编写，随便转换。
}

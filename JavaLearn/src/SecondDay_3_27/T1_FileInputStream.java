package SecondDay_3_27;

import java.io.*;
import java.util.Random;

/**
 * java类简单作用描述
 * Description:
 * User: necromaner
 * Date: 2018-03-27
 *
 * @Description: java类作用描述
 * Time: 下午9:06
 */
/*
该流用于从文件读取数据，它的对象可以用关键字 new 来创建。

有多种构造方法可用来创建对象。

可以使用字符串类型的文件名来创建一个输入流对象来读取文件：
InputStream f = new FileInputStream("C:/java/hello");

也可以使用一个文件对象来创建一个输入流对象来读取文件。我们首先得使用 File() 方法来创建一个文件对象：
File f = new File("C:/java/hello");
InputStream out = new FileInputStream(f);

创建了InputStream对象，就可以使用下面的方法来读取流或者进行其他的流操作。
序号 	方法及描述
1 	public void close() throws IOException{}
关闭此文件输入流并释放与此流有关的所有系统资源。抛出IOException异常。
2 	protected void finalize()throws IOException {}
这个方法清除与该文件的连接。确保在不再引用文件输入流时调用其 close 方法。抛出IOException异常。
3 	public int read(int r)throws IOException{}
这个方法从 InputStream 对象读取指定字节的数据。返回为整数值。返回下一字节数据，如果已经到结尾则返回-1。
4 	public int read(byte[] r) throws IOException{}
这个方法从输入流读取r.length长度的字节。返回读取的字节数。如果是文件结尾则返回-1。
5 	public int available() throws IOException{}
返回下一次对此输入流调用的方法可以不受阻塞地从此输入流读取的字节数。返回一个整数值。
 */
public class T1_FileInputStream {
    public static void main(String[] args) throws IOException {
//        File f = new File("/Users/necromaner/java/text/test.txt");
//        FileOutputStream fop = new FileOutputStream(f);
//        // 构建FileOutputStream对象,文件不存在会自动新建
//        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
//        // 构建OutputStreamWriter对象,参数可以指定编码,默认为操作系统默认编码,windows上是gbk
//        writer.append("中文输入");
//        // 写入到缓冲区
//        writer.append("\r\n");
//        //换行
//        writer.append("English");
//        // 刷新缓存冲,写入到文件,如果下面已经没有写入的内容了,直接close也会写入
//        writer.close();
//        //关闭写入流,同时会把缓冲区内容写入文件,所以上面的注释掉
//        fop.close();
//        // 关闭输出流,释放系统资源
//        FileInputStream fip = new FileInputStream(f);
//        // 构建FileInputStream对象
//        InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
//        // 构建InputStreamReader对象,编码与写入相同
//        StringBuffer sb = new StringBuffer();
//        while (reader.ready()) {
//            sb.append((char) reader.read());
//            // 转成char加到StringBuffer对象中
//        }
//        System.out.println(sb.toString());
//        reader.close();
//        // 关闭读取流
//        fip.close();
//        // 关闭输入流,释放系统资源
        
        Random rand = new Random();
        int x1=rand.nextInt(100) + 1;
        int x2=rand.nextInt(100) + 1;

        File f = new File("/Users/necromaner/java/text/test.txt");
    
        FileInputStream fip = new FileInputStream(f);
        InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
        StringBuffer sb = new StringBuffer();
        while (reader.ready()) {
            sb.append((char) reader.read());
        }
        
        
        FileOutputStream fop = new FileOutputStream(f);
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
    
        writer.append(sb.toString());
        
        writer.append(x1+" + "+x2+" = "+(x1+x2));
        writer.append("\r\n");
        writer.close();
        fop.close();
    }
}

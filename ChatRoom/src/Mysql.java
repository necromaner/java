import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * 功能：
 * 注册
 * 登录
 * 修改昵称
 * 退出
 * 查看登录状态
 *
 * 协议：
 * SIGNIN=-=账号=-=密码=-=昵称=-=address
 * SIGNUP=-=账号=-=密码=-=address
 * NAME=-=昵称
 *
 *
 */

public class Mysql {

    public Mysql() {
    }
    /**
     * 格式：
     *  SIGNIN=-=账号=-=密码=-=昵称=-=address
     * 注册：
     *  成功：
     *      返回：注册成功!  账号：XXX 密码：XXX  昵称：XXX
     *  失败：
     *      格式错误
     *          返回：注册失败！ 格式错误！
     *      account同名
     *          返回：注册失败！ 账号已存在！
     *      未知错误
     *          返回：发生未知问题
     */
    public String SIGNIN(String[] s)throws ClassNotFoundException,SQLException {//注册
        //1.加载驱动器
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatroom?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "root");
        String sql;
        String[] s1 = null;
        PreparedStatement ps;
        s1 = s[1].split("=-=");
        if (s1.length == 4) {
            sql ="SELECT * FROM connect WHERE account=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,s1[0]);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return "注册失败！ 账号已存在！";
            }
        } else {
            return "注册失败！ 格式错误！";
        }
    
        sql = "insert into connect(account,password,name,address,login)values(?,?,?,?,?)";
        //3.sql预编译
        ps = conn.prepareStatement(sql);
        ps.setString(1, s1[0]);
        ps.setString(2, s1[1]);
        ps.setString(3, s1[2]);
        ps.setString(4, s1[3]);
        ps.setInt(5, 0);
    
        int cnt=ps.executeUpdate();
        if (ps != null) {
            ps.close();
            ps = null;
        }
        if (conn != null) {
            conn.close();
            conn = null;
        }
        if (cnt!=0){
            return "注册成功!  账号："+s1[0]+" 密码："+s1[1]+"  昵称："+s1[2];
        }
        return "发生未知问题";
    }
    /**
     * 格式：
     *  SIGNUP=-=账号=-=密码=-=address
     * 登录：
     *  成功：
     *      未登录
     *          返回：登录成功
     *      已登录
     *          返回：已登录
     *  失败：
     *      格式错误
     *          返回：登录失败！ 格式错误！
     *      未找到一样的账号和密码
     *          返回：登录失败！ 请检查账号密码！
     *      未知错误
     *          返回：发生未知问题
     */
    public String SIGNUP(String[] s)throws ClassNotFoundException,SQLException {//登录
        //1.加载驱动器
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatroom?useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "root");
        String sql;
        String[] s1 = null;
        PreparedStatement ps;
        s1 = s[1].split("=-=");
        if (s1.length == 3) {
            sql ="SELECT * FROM connect WHERE account=? AND password=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,s1[0]);
            ps.setString(2,s1[1]);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()){
                return "登录失败！ 请检查账号密码！";
            }else if (rs.getInt("login")==1&&s1[2].equals(rs.getString("address"))){
                return "已登录";
            }
        } else {
            return "登录失败！ 格式错误！";
        }
        
        long l = System.currentTimeMillis();
        Date date = new Date(l);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        sql = "UPDATE connect set address=? , login=1 ,lasttime=? where account=?";
//        sql = "UPDATE connect set address=？ , login=? where account=?";
        //3.sql预编译
        ps = conn.prepareStatement(sql);
        ps.setString(1, s1[2]);
        ps.setString(2,dateFormat.format(date) );
        ps.setString(3,s1[0]);
        
        int cnt=ps.executeUpdate();
        if (ps != null) {
            ps.close();
            ps = null;
        }
        if (conn != null) {
            conn.close();
            conn = null;
        }
        if (cnt!=0){
            return "登录成功";
        }
        return "发生未知问题";
    }
    
    public void QueryInfo()throws ClassNotFoundException,SQLException{//查询
        //1.加载驱动器
        Class.forName("com.mysql.jdbc.Driver");
        //2.获取连接
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/chatroom?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","root");
        String sql="select * from connect";
        //3.sql预编译
        PreparedStatement ps=conn.prepareStatement(sql);
        //4.执行查询
        ResultSet  rs =ps.executeQuery();
        //rs.next判断是否有数据
        while (rs.next()){
            String account=rs.getString("account");
            String password=rs.getString("password");
            String address =rs.getString("address");
            String name =rs.getString("name");
            Timestamp lasttime =rs.getTimestamp("lasttime");
            int login =rs.getInt("login");
            System.out.println(account+" - "+password+" - "+address+" - "+name+" - "+lasttime+" - "+login);
        }
        if (rs!=null){
            rs.close();
            rs=null;
        }
        if (ps!=null){
            ps.close();
            ps=null;
        }
        if (conn!=null){
            conn.close();
            conn=null;
        }
    }
    
}


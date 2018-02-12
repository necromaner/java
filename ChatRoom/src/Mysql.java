import java.sql.*;

/**
 * Description:
 * User: necromaner
 * Date: 2018-02-07
 * Time: 下午4:58
 */
public class Mysql {
    public static void main(String[] args)throws ClassNotFoundException,SQLException {
        queryInfo();
    }
    public static void queryInfo()throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/chatroom?useUnicode=true&characterEncoding=utf-8&useSSL=false","root","root");
        String sql="select * from connect";
    }
    
}


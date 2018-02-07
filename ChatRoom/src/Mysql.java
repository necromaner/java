import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/localhost","root","root");
        String sql="select * from connect";
    }
    
}


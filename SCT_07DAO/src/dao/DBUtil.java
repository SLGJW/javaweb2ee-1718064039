package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
    	Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","cxy123456");
        return con;
    }

    public static void close(Connection con) throws SQLException{
        if(con!=null){
            con.close();
        }
    }

    /*public static void main(String[] args) throws ClassNotFoundException, SQLException{
        System.out.println(DBUtil.getConnection());
    }*/
}

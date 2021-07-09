//
//public class JdbcUtils {
//    
//}


//package jdbcdemo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JdbcUtils {
    
    public static String DB_NAME="db1";
    public static final String DB_URL="jdbc:mysql://localhost:3306/"+DB_NAME+"?allowPublicKeyRetrieval=true&useSSL=false";
    public static final String DB_USER="root";
    public static final String DB_PASSWORD="root";
    
    public static Connection conn;
    public static Statement stmt;
    
    public static void connectDB() throws ClassNotFoundException,SQLException
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn=DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        stmt=conn.createStatement();
    }
    
    public static void close() throws SQLException
    {
        conn.close();
        stmt.close();
    }
    
    public static int insert(String insertQry)throws SQLException
    {
        int result=0;
        if(insertQry!=null)
        {
            result=stmt.executeUpdate(insertQry);
        }
        return result;
    }
    
    public static int delete(String deleteQry)throws SQLException
    {
        int result=0;
        if(deleteQry!=null)
        {
            result=stmt.executeUpdate(deleteQry);
        }
        return result;
    }
    
    public static int update(String updateQry)throws SQLException
    {
        int result=0;
        if(updateQry!=null)
        {
            result=stmt.executeUpdate(updateQry);
        }
        return result;
    }
    
    
    
    public static ResultSet fetch(String selectQry) throws SQLException
    {
        ResultSet rs=null;
        if(selectQry!=null)
        {
            rs=stmt.executeQuery(selectQry);
        }
        return rs;
        
    }
    
}


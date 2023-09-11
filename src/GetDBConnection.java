import java.sql.*;
public class GetDBConnection {
    public static Connection connectDB(String DBName,String id,String password) {
        try{  //加载JDBC-MySQL8.0连接器:
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        }
        catch(Exception e){}
        Connection con = null;
        String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=Loan_Management2;user=test;password=123456";

        try{
            con = DriverManager.getConnection(url,id,password); //连接
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return con;
    }
}

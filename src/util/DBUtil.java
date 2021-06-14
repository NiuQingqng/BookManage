package util;

import java.sql.*;

//通用的数据库操作方法
public class DBUtil {

    private static Connection conn;
    private static PreparedStatement pstmt;
    private static ResultSet rs=null;
    static boolean result=false;

    //获取链接对象
    public static void getConnection(){
        String ClassName="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://127.0.0.1:3306/books?serverTimezone=UTC";
        String username="root";
        String password="123456";
        try {
            Class.forName(ClassName);
            conn = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //创建PrepareStatement
    public static void createPreparedStatement(String sql,Object[] params){
        try {
            getConnection();    //本类中创建Connection的方法
            pstmt=conn.prepareStatement(sql);
            if(params!=null){
                for(int i=0;i<params.length;i++){
                    pstmt.setObject(i+1,params[i]);
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //通用的增删改，需要sql语句和参数列表
    public static boolean executeUpdate(String sql,Object[] params){
        try {
            createPreparedStatement(sql,params);    //本类中创建PreparedStatement的方法
            int rows = pstmt.executeUpdate();
            if(rows>0){
                result=true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeAll();
        }
        return result;
    }
    //通用的查,因为不同类型对象的处理方法不一样，所以返回ResultSet在原方法中处理，需要sql语句和参数列表
    public static ResultSet executeQuery(String sql,Object[] params){
        try {
            createPreparedStatement(sql,params);
            rs=pstmt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    //关闭全部对象
    public static void closeAll(){
        try {
            if(rs!=null) rs.close();
            if(pstmt!=null) pstmt.close();
            if(conn!=null) conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //关闭外部ResultSet对象
    public static void closeResultSet(ResultSet rs){
        if(rs!=null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}

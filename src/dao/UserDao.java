package dao;

import entity.User;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {

    //根据学号判断此人是否存在
    public boolean userIsExist(String uno){//true:此人存在，false 不存在
        if(queryUserByUno(uno)==null){
            return false;      //不存在
        }else {
            return true;     //此人存在
        }
    }

    //根据账号密码和类型判断用户在是否合法，用于登录
    public boolean userIsExistByUnoUpwdUtype(String uno, String upasswd, int type){
        String sql ="select * from user where uno=? and upasswd=? and isadmin=?";
        Object[] params ={uno,upasswd,type};
        ResultSet rs = DBUtil.executeQuery(sql,params);
        try {
            if(rs.next()){
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeAll();
        }
        return false;
    }
    //根据学号查询用户
    public User queryUserByUno(String uno){
        User user =null;
        String sql ="select * from user where uno=?";
        Object[] params ={uno};
        ResultSet rs = DBUtil.executeQuery(sql,params);
        try {
            if(rs.next()){
                user=new User();
                user.setUno(rs.getString("uno"));
                user.setUname(rs.getString("uname"));
                user.setUpasswd(rs.getString("upasswd"));
                user.setUsex(rs.getString("usex"));
                user.setUgrade(rs.getInt("gradeyear"));
                user.setIsadmin(rs.getInt("isadmin"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeAll();
        }
        return user;
    }

    public ArrayList<User> queryAllUser(){
        ArrayList<User> users = new ArrayList<>();
        String sql = "select * from user where isadmin=0";
        ResultSet rs=DBUtil.executeQuery(sql,null);
        try {
            while (rs.next()) {
                User user=new User();
                user.setUno(rs.getString("uno"));
                user.setUname(rs.getString("uname"));
                user.setUpasswd(rs.getString("upasswd"));
                user.setUsex(rs.getString("usex"));
                user.setUgrade(rs.getInt("gradeyear"));
                user.setIsadmin(rs.getInt("isadmin"));
                users.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeAll();
        }
        return users;
    }


    //增加用户资料
    public boolean addUser(User user){
        String sql ="insert into user (uno,uname,upasswd,usex,gradeyear) values(?,?,?,?,?)";
        Object[] params={user.getUno(),user.getUname(),user.getUpasswd(),user.getUsex(),user.getUgrade()};
        return DBUtil.executeUpdate(sql,params);
    }
    //删除用户资料
    public boolean delectUserByUno(String uno){
        String sql ="delete from user where uno=?";
        Object[] params={uno};
        return DBUtil.executeUpdate(sql,params);

    }
    //修改用户资料
    public boolean updateUserByUno(User user){
        String sql ="update user set uname=?,upasswd=?,usex=?,gradeyear=? where uno=?";
        Object[] params={user.getUname(),user.getUpasswd(),user.getUsex(),user.getUgrade(),user.getUno()};
        return DBUtil.executeUpdate(sql,params);
    }

    //用户操作---------------------修改密码
    public boolean userUpdatePasswd(String upasswd,String uno){
        String sql = "update user set upasswd=? where uno=?";
        Object[] params={upasswd,uno};
        return DBUtil.executeUpdate(sql,params);
    }
}

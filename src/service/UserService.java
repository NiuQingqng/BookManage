package service;

import dao.UserDao;
import entity.User;

import java.util.ArrayList;

public class UserService {
    UserDao userDao =new UserDao();
    //登录，包括管理员和用户
    public User userLogin(String uno, String upasswd, int type){
        User user =null;
        if (userDao.userIsExistByUnoUpwdUtype(uno,upasswd,type)){
            user=userDao.queryUserByUno(uno);
        }
        return user;
    }
    //用户操作，修改密码
    public boolean userUpdatePasswd(String upasswd,String uno){
        return userDao.userUpdatePasswd(upasswd,uno);
    }
    //添加用户
    public boolean addUser(User user){
        boolean result=false;
        if(userDao.userIsExist(user.getUno())){
            System.out.println("用户已存在");
            return false;
        }else {
            return userDao.addUser(user);
        }
    }
    //删除用户
    public boolean delectUserByUno(String uno){
        if(userDao.userIsExist(uno)){
            return userDao.delectUserByUno(uno);
        }else {
            System.out.println("此用户不存在");
            return false;
        }
    }
    //修改用户
    public boolean updateUserByUno(User user){
        if(userDao.userIsExist(user.getUno())){
            return userDao.updateUserByUno(user);
        }else {
            System.out.println("此用户不存在");
            return false;
        }
    }
    //查询用户
    public User queryUserByUno(String uno){
        return userDao.queryUserByUno(uno);
    }
    //查询全部用户
    public ArrayList<User> queryAllUser(){
        return userDao.queryAllUser();
    }
}

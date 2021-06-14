package servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LoginCtrl")
public class LoginCtrl extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String typestr=request.getParameter("type");  //用户身份判断码
        int type= Integer.parseInt(typestr);
        String no=request.getParameter("username");
        String passwd=request.getParameter("passwd");
        UserService userService = new UserService();
        User user=userService.userLogin(no,passwd,type);
        if(type==1){
            if(user!=null&&user.getIsadmin()==1){
                HttpSession session = request.getSession();
                session.setAttribute("admin",user);
                request.getRequestDispatcher("/adminpage/index_admin.jsp").forward(request, response);
            }else{
                request.setAttribute("tipCode","111");//用户密码错误
                request.getRequestDispatcher("/tip.jsp").forward(request,response);
            }
        }else if(type==0){
            if(user!=null&&user.getIsadmin()==0){
                HttpSession session = request.getSession();
                session.setAttribute("user",user);
                request.getRequestDispatcher("/userpage/index_user.jsp").forward(request, response);
            }else{
                request.setAttribute("tipCode","101");//用户密码错误
                request.getRequestDispatcher("/tip.jsp").forward(request,response);
            }
        }
    }
}

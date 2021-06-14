package servlet.adminservlet.usermanage;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/QueryAllUserServlet")
public class QueryAllUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        User user=new User();
        ArrayList<User> users = new ArrayList<>();
        UserService userService = new UserService();
        users=userService.queryAllUser();

        //需要修改
        if(users!=null){
            request.setAttribute("users",users);
            request.getRequestDispatcher("/adminpage/user_manage/all_user.jsp").forward(request,response);
        }else{
            request.setAttribute("tipCode","1299");//查询发生错误--adminindex
            request.getRequestDispatcher("/tip.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

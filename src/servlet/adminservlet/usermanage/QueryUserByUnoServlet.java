package servlet.adminservlet.usermanage;

import entity.Book;
import entity.User;
import service.BookService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/QueryUserByUnoServlet")
public class QueryUserByUnoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uno= request.getParameter("uno");

        User user=new User();
        UserService userService = new UserService();
        user=userService.queryUserByUno(uno);
        if(user!=null){
            request.setAttribute("user",user);
            request.getRequestDispatcher("/adminpage/user_manage/user_info.jsp").forward(request,response);
        }else{
            request.setAttribute("tipCode","1221");//找不到用户--alluser
            request.getRequestDispatcher("/tip.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

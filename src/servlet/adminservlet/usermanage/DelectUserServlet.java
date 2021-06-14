package servlet.adminservlet.usermanage;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DelectUserServlet")
public class DelectUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uno= request.getParameter("uno");

        UserService userService = new UserService();
        boolean result=userService.delectUserByUno(uno);

        if(result) {
            request.setAttribute("tipCode","1210");//删除用户成功--alluser
            request.getRequestDispatcher("/tip.jsp").forward(request,response);
        }else {
            request.setAttribute("tipCode","1211");//删除用户失败--alluser
            request.getRequestDispatcher("/tip.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

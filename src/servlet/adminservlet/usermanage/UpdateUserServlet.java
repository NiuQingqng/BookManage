package servlet.adminservlet.usermanage;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String uno= request.getParameter("uno");
        String uname= request.getParameter("uname");
        String upasswd= request.getParameter("upasswd");
        String usex= request.getParameter("usex");
        String ugradestr = request.getParameter("ugrade");
        int ugrade = Integer.parseInt(ugradestr);
        User user = new User(uno,uname,upasswd,usex,ugrade);
        UserService userService = new UserService();
        boolean result= userService.updateUserByUno(user);
        if(result) {
            //System.out.println("成功");
            request.setAttribute("tipCode","1230");//修改用户成功--alluser
            request.getRequestDispatcher("/tip.jsp").forward(request,response);
        }else {
            request.setAttribute("tipCode","1231");//修改用户失败--alluser
            request.getRequestDispatcher("/tip.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

package servlet.userservlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/UserUpdatePasswd")
public class UserUpdatePasswd extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdatePasswd() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String old_passwd=request.getParameter("old_passwd");
        String new_passwd_1=request.getParameter("new_passwd_1");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        UserService userService=new UserService();
        if (user.getUpasswd().equals(old_passwd)){
            boolean result = userService.userUpdatePasswd(new_passwd_1,user.getUno());
            if(result==true){
                request.setAttribute("tipCode","200");//修改密码成功
            }else{
                request.setAttribute("tipCode","202"); //修改失败
            }
        }else{
            request.setAttribute("tipCode","201");//原密码错误
        }
        request.getRequestDispatcher("/tip.jsp").forward(request,response);
    }
}

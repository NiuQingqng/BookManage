package servlet.userservlet;

import entity.User;
import service.BorrowService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/BorrBookServlet")
public class BorrBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String bno = request.getParameter("bno");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        BorrowService borrowService = new BorrowService();
        boolean result = borrowService.borrBookByBorrowno(user.getUno(),bno);

        //需要修改
        if (result == true) {
            request.setAttribute("tipCode", "500");
        } else {
            request.setAttribute("tipCode", "501");
        }
        request.getRequestDispatcher("/tip.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

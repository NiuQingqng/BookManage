package servlet.adminservlet.othermanage;

import service.BorrowService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteBorrowByBorrownoServlet")
public class DeleteBorrowByBorrownoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String borrowno= request.getParameter("id");
        String type= request.getParameter("type");
        BorrowService borrowService = new BorrowService();
        boolean result = borrowService.delectBorrowByBorrowno(borrowno);
        if(result) {
            request.setAttribute("tipCode","1300");//删除借阅记录成功--allborrow
            request.getRequestDispatcher("/tip.jsp").forward(request,response);
        }else {
            request.setAttribute("tipCode","1301");//删除借阅记录失败--allborrow
            request.getRequestDispatcher("/tip.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

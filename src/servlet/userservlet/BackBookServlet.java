package servlet.userservlet;

import service.BorrowService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/BackBookServlet")
public class BackBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BackBookServlet() {
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
        String borrownostr = request.getParameter("id");
        int borrowno =Integer.parseInt(borrownostr);
        BorrowService borrowService = new BorrowService();
        boolean result = borrowService.backBookByBorrowno(borrowno);
        if (result == true) {
            request.setAttribute("tipCode", "300");//修改密码成功
        } else {
            request.setAttribute("tipCode", "301"); //修改失败
        }
        request.getRequestDispatcher("/tip.jsp").forward(request, response);
    }
}

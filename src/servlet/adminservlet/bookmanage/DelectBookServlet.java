package servlet.adminservlet.bookmanage;

import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DelectBookServlet")
public class DelectBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String bno= request.getParameter("bno");

        BookService bookService = new BookService();
        boolean result=bookService.delectBookByBno(bno);
        if(result) {
            request.setAttribute("tipCode","1110");//删除图书成功--allbook
            request.getRequestDispatcher("/tip.jsp").forward(request,response);
        }else {
            request.setAttribute("tipCode","1111");//删除图书失败--allbook
            request.getRequestDispatcher("/tip.jsp").forward(request,response);
        }
    }
}

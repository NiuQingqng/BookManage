package servlet.adminservlet.bookmanage;

import entity.Book;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/QueryBookByBnoServlet")
public class QueryBookByBnoServlet extends HttpServlet {
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

        Book book=new Book();
        BookService bookService = new BookService();
        book=bookService.queryBookByBno(bno);
        if(book!=null){
            request.setAttribute("book",book);
            request.getRequestDispatcher("/adminpage/book_manage/book_info.jsp").forward(request,response);
        }else{
            request.setAttribute("tipCode","1121");//找不到图书--allbook
            request.getRequestDispatcher("/tip.jsp").forward(request,response);
        }
    }
}

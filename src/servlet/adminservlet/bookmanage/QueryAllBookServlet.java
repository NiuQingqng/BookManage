package servlet.adminservlet.bookmanage;

import entity.Book;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/QueryAllBookServlet")
public class QueryAllBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        Book book=new Book();
        ArrayList<Book> books = new ArrayList<>();
        BookService bookService = new BookService();
        books=bookService.queryAllBook();
        if(books!=null){
            request.setAttribute("books",books);
            request.getRequestDispatcher("/adminpage/book_manage/all_book.jsp").forward(request,response);
        }else{
            request.setAttribute("tipCode","1199");//查询发生错误--adminindex
            request.getRequestDispatcher("/tip.jsp").forward(request,response);
        }
    }
}




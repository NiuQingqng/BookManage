package servlet.adminservlet.bookmanage;

import entity.Book;
import service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
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
        String bname= request.getParameter("bname");
        //String cno= request.getParameter("cno");
        String bautuor= request.getParameter("bautuor");
        String bpublisher= request.getParameter("bpublisher");
        String bprice_str= request.getParameter("bprice");
        String bISBN= request.getParameter("bISBN");
        String bstatus= request.getParameter("bstatus");
        String blocaltion= request.getParameter("blocaltion");
        int bprice=Integer.parseInt(bprice_str);

        Book book=new Book(bno, bname, "c1007", bautuor, bpublisher, bprice, bISBN, bstatus,blocaltion);
        BookService bookService = new BookService();
        boolean result=bookService.updateBookByBno(book);
        if(result) {
            //System.out.println("成功");
            request.setAttribute("tipCode","1130");//修改图书成功--allbook
            request.getRequestDispatcher("/tip.jsp").forward(request,response);
        }else {
            request.setAttribute("tipCode","1131");//修改图书失败--allbook
            request.getRequestDispatcher("/tip.jsp").forward(request,response);
        }
    }
}

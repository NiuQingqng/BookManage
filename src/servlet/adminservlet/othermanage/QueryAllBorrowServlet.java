package servlet.adminservlet.othermanage;

import entity.Book;
import entity.Borrow;
import service.BookService;
import service.BorrowService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/QueryAllBorrowServlet")
public class QueryAllBorrowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        Borrow borrow=new Borrow();
        ArrayList<Borrow> borrows = new ArrayList<>();
        BorrowService borrowService = new BorrowService();
        borrows=borrowService.queryAllBorrow();
        if(borrows!=null){
            request.setAttribute("borrows",borrows);
            request.getRequestDispatcher("/adminpage/other_manage/all_borrow.jsp").forward(request,response);
        }else{
            request.setAttribute("tipCode","1199");//查询发生错误--adminindex
            request.getRequestDispatcher("/tip.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}

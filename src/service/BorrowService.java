package service;

import dao.BookDao;
import dao.BorrowDao;
import entity.Book;
import entity.Borrow;
import java.util.ArrayList;

public class BorrowService {
    BorrowDao borrowDao=new BorrowDao();
    BookDao bookDao = new BookDao();
    //还书---用户操作
    public boolean backBookByBorrowno(int borrowno){
        Borrow borrow = borrowDao.queryBorrowByBorrowno(borrowno);
        Book book = bookDao.queryBookByBno(borrow.getBno());
        book.setBstatus("未借");
        if(bookDao.updateBookByBno(book)){
            if(borrowDao.backBookByBorrowno(borrowno)){
                return true;
            }else {
                book.setBstatus("已借");
                bookDao.updateBookByBno(book);
                return false;
            }
        }else {
            return false;
        }
    }

    //借书---用户操作
    public boolean borrBookByBorrowno(String uno,String bno){
        Book book = bookDao.queryBookByBno(bno);
        book.setBstatus("已借");
        if(bookDao.updateBookByBno(book)){
            if(borrowDao.borrBookByBorrowno(uno,bno)){
                return true;
            }else {
                book.setBstatus("未借");
                bookDao.updateBookByBno(book);
                return false;
            }
        }else {
            return false;
        }
    }

    //查询借阅---用户操作，根据学号和状态查询借阅
    public ArrayList<Borrow> queryBorrowByStatus(String uno, int status){
        return borrowDao.queryBorrowByStatus(uno,status);
    }

    //查询借阅---管理员操作
    public ArrayList<Borrow> queryAllBorrow(){
        return borrowDao.queryAllBorrow();
    }

    //删除借阅记录
    public boolean delectBorrowByBorrowno(String borrowno){
        return borrowDao.delectBorrowByBorrowno(borrowno);
    }
}

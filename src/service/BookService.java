package service;

import dao.BookDao;
import entity.Book;
import java.util.ArrayList;

public class BookService {
    BookDao bookDao = new BookDao();
    //添加图书
    public boolean addBook(Book book){
        boolean result=false;
        if(bookDao.bookIsExist(book.getBno())){
            System.out.println("书籍已存在");
            return false;
        }else {
            return bookDao.addBook(book);
        }
    }
    //删除图书
    public boolean delectBookByBno(String bno){
        if(bookDao.bookIsExist(bno)){
            return bookDao.delectBookByBno(bno);
        }else {
            System.out.println("书籍不存在");
            return false;
        }
    }
    //修改图书
    public boolean updateBookByBno(Book book){
        if(bookDao.bookIsExist(book.getBno())){
            return bookDao.updateBookByBno(book);
        }else {
            System.out.println("书籍不存在");
            return false;
        }
    }
    //查询图书
    public Book queryBookByBno(String bno){
        return bookDao.queryBookByBno(bno);
    }
    //查询图书根据书名模糊
    public ArrayList<Book> queryBookByBname(String bname){
        return bookDao.queryBookByBname(bname);
    }
    //查询全部图书
    public ArrayList<Book> queryAllBook(){
        return bookDao.queryAllBook();
    }
}

package dao;

import util.DBUtil;
import entity.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDao {

    //根据书号判断此书是否存在
    public boolean bookIsExist(String bno){//true:此书存在，false 不存在
        if(queryBookByBno(bno)==null){  //本类中根据书号查书的方法
            return false;      //不存在
        }else {
            return true;     //此书存在
        }
    }
    //根据书号查书
    public Book queryBookByBno(String bno){
        ArrayList<Book> books ;
        Book book ;
        String sql ="select * from book where bno=?";
        Object[] params ={bno};
        books=queryBooks(sql,params);   //本类中查书的通用方法，返回值是图书列表
        if(books.size()==0||books==null){
            return null;
        }else {
            //因为书号可以唯一确定一本书，所以如果有结果，则只有一本
            book=books.get(0);
            return book;
        }
    }
    //查询图书根据书名模糊查找
    public ArrayList<Book> queryBookByBname(String bname){
        ArrayList<Book> books;
        String sql = "select * from book where bname like ?";
        Object[] params ={"%"+bname+"%"};
        books = queryBooks(sql,params); //本类中查书的通用方法，返回值是图书列表
        return books;
    }
    //全部图书
    public ArrayList<Book> queryAllBook(){
        ArrayList<Book> books = new ArrayList<>();
        String sql = "select * from book";
        books = queryBooks(sql,null);//本类中查书的通用方法，返回值是图书列表
        return books;
    }
    //查书的通用方法
    public ArrayList<Book> queryBooks(String sql,Object[] params){
        ArrayList<Book> books = new ArrayList<>();
        Book book =null;
        ResultSet rs=DBUtil.executeQuery(sql,params);
        try {
            while (rs.next()) {
                book=new Book(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9));
                books.add(book);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeAll();
        }
        return books;
    }

    //增加图书
    public boolean addBook(Book book){
        String sql ="insert into book (bno,bname,cno,bautuor,bpublisher,bprice,bISBN,blocaltion) values(?,?,?,?,?,?,?,?)";
        Object[] params={book.getBno(),book.getBname(),book.getCno(),book.getBautuor()
                ,book.getBpublisher(),book.getBprice(),book.getbISBN(),book.getBlocaltion()};
        return DBUtil.executeUpdate(sql,params);
    }
    //删除图书
    public boolean delectBookByBno(String bno){
        String sql ="delete from book where bno=?";
        Object[] params={bno};
        return DBUtil.executeUpdate(sql,params);

    }
    //修改图书
    public boolean updateBookByBno(Book book){
        String sql ="update book set bname=?,cno=?,bautuor=?,bpublisher=?,bprice=?,bISBN=?,bstatus=?,blocaltion=? where bno=?";
        Object[] params={book.getBname(),book.getCno(),book.getBautuor(),book.getBpublisher()
                ,book.getBprice(),book.getbISBN(),book.getBstatus(),book.getBlocaltion(),book.getBno()};
        return DBUtil.executeUpdate(sql,params);
    }
}
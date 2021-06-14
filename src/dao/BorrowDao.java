package dao;

import entity.Borrow;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BorrowDao {

    //删除借阅记录
    public boolean delectBorrowByBorrowno(String borrowno){
        String sql ="delete from borrow where borrow_no=?";
        Object[] params={borrowno};
        return DBUtil.executeUpdate(sql,params);
    }

    //查询借阅详细信息，根据借阅记录编号
    public Borrow queryBorrowByBorrowno(int borrowno){
        Borrow borrow=null;
        String sql = "SELECT * FROM borrow,book where borrow.bno=book.bno and borrow_no=?";
        Object[] params={borrowno};
        ResultSet rs = DBUtil.executeQuery(sql,params);
        try {
            if (rs.next()){
                borrow = new Borrow(
                        rs.getString("borrow_no"),
                        rs.getString("uno"),
                        rs.getString("bno"),
                        rs.getString("bname"),
                        rs.getDate("start_time"),
                        rs.getDate("end_time"),
                        rs.getInt("status")
                );
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeAll();
        }
        return borrow;
    }
    //查询借阅---用户操作
    public ArrayList<Borrow> queryBorrowByStatus(String uno, int status){
        String sql = "SELECT * FROM borrow,book where uno=? and borrow.bno=book.bno and borrow.status=?;";
        Object[] params={uno,status};
        ResultSet rs = DBUtil.executeQuery(sql,params);
        ArrayList<Borrow> borrowlist = new ArrayList<>();
        try {
            while (rs.next()){
                Borrow borrow = new Borrow(
                    rs.getString("borrow_no"),
                    rs.getString("uno"),
                    rs.getString("bno"),
                    rs.getString("bname"),
                    rs.getDate("start_time"),
                    rs.getDate("end_time"),
                    rs.getInt("status")
                );
                borrowlist.add(borrow);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeAll();
        }
        return borrowlist;
    }

    //查询借阅---管理员操作
    public ArrayList<Borrow> queryAllBorrow(){
        String sql = "SELECT * FROM borrow,book where borrow.bno=book.bno;";
        ResultSet rs = DBUtil.executeQuery(sql,null);
        ArrayList<Borrow> borrowlist = new ArrayList<>();
        try {
            while (rs.next()){
                Borrow borrow = new Borrow(
                        rs.getString("borrow_no"),
                        rs.getString("uno"),
                        rs.getString("bno"),
                        rs.getString("bname"),
                        rs.getDate("start_time"),
                        rs.getDate("end_time"),
                        rs.getInt("status")
                );
                borrowlist.add(borrow);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeAll();
        }
        return borrowlist;
    }

    //还书---用户操作
    public boolean backBookByBorrowno(int borrowno){
        String sql = "update borrow set status=1,end_time=current_time() where borrow_no=?";
        Object[] params={borrowno};
        return DBUtil.executeUpdate(sql,params);
    }
    //借书---用户操作
    public boolean borrBookByBorrowno(String uno,String bno){
        String sql = "insert into borrow (uno,bno) values(?,?)";
        Object[] params={uno,bno};
        return DBUtil.executeUpdate(sql,params);
    }
}

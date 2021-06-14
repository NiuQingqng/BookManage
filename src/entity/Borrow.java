package entity;

import java.util.Date;

public class Borrow {
    private String borrowno;
    private String uno;
    private String bno;
    private String bname;
    private Date starttime;
    private Date endtime;
    private int status;

    public Borrow(){

    }
    public Borrow(String borrowno, String uno, String bno, String bname, Date starttime, Date endtime, int status) {
        this.borrowno = borrowno;
        this.uno = uno;
        this.bno = bno;
        this.bname = bname;
        this.starttime = starttime;
        this.endtime = endtime;
        this.status = status;
    }

    public String getBorrowno() {
        return borrowno;
    }

    public void setBorrowno(String borrowno) {
        this.borrowno = borrowno;
    }

    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }

    public String getBno() {
        return bno;
    }

    public void setBno(String bno) {
        this.bno = bno;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

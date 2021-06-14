package entity;

public class Book {
    private String bno;
    private String bname;
    private String cno;   //书类别号
    private String bautuor;
    private String bpublisher;
    private int bprice;
    private String bISBN;
    private String bstatus;
    private String blocaltion;

    public Book(){}

    public Book(String bno,
                String bname,
                String cno,
                String bautuor,
                String bpublisher,
                int bprice,
                String bISBN,
                String blocaltion) {
        this.bno = bno;
        this.bname = bname;
        this.cno = cno;
        this.bautuor = bautuor;
        this.bpublisher = bpublisher;
        this.bprice = bprice;
        this.bISBN = bISBN;
        this.blocaltion = blocaltion;
    }
    public Book(String bno,
                String bname,
                String cno,
                String bautuor,
                String bpublisher,
                int bprice,
                String bISBN,
                String bstatus,
                String blocaltion) {
        this.bno = bno;
        this.bname = bname;
        this.cno = cno;
        this.bautuor = bautuor;
        this.bpublisher = bpublisher;
        this.bprice = bprice;
        this.bISBN = bISBN;
        this.bstatus = bstatus;
        this.blocaltion = blocaltion;
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

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getBautuor() {
        return bautuor;
    }

    public void setBautuor(String bautuor) {
        this.bautuor = bautuor;
    }

    public String getBpublisher() {
        return bpublisher;
    }

    public void setBpublisher(String bpublisher) {
        this.bpublisher = bpublisher;
    }

    public int getBprice() {
        return bprice;
    }

    public void setBprice(int bprice) {
        this.bprice = bprice;
    }

    public String getbISBN() {
        return bISBN;
    }

    public void setbISBN(String bISBN) {
        this.bISBN = bISBN;
    }

    public String getBstatus() {
        return bstatus;
    }

    public void setBstatus(String bstatus) {
        this.bstatus = bstatus;
    }

    public String getBlocaltion() {
        return blocaltion;
    }

    public void setBlocaltion(String blocaltion) {
        this.blocaltion = blocaltion;
    }
}

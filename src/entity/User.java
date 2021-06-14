package entity;

public class User {
    private String uno;
    private String uname;
    private String upasswd;
    private String usex;
    private int ugrade;
    private int isadmin;

    public User(){
    }
    public User(String uno, String uname, String upasswd, String usex, int ugrade) {
        this.uno = uno;
        this.uname = uname;
        this.upasswd = upasswd;
        this.usex = usex;
        this.ugrade = ugrade;
    }

    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpasswd() {
        return upasswd;
    }

    public void setUpasswd(String upasswd) {
        this.upasswd = upasswd;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    public int getUgrade() {
        return ugrade;
    }

    public void setUgrade(int ugrade) {
        this.ugrade = ugrade;
    }

    public int getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(int isadmin) {
        this.isadmin = isadmin;
    }
}

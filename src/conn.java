import java.sql.*;

public class conn {
    Connection c;
    Statement s;

    public conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem?useSSL=false", "root",
                    "9876223028Kk");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new conn();
    }
}

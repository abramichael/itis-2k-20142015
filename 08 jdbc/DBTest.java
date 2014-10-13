import java.sql.*;

/**
 * Created by ma on 13.10.14.
 */
public class DBTest {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://127.0.0.1:5432/classwork",
                "postgres",
                "postgres"
        );
        PreparedStatement s = conn.prepareStatement("select name from teachers");
        ResultSet rs = s.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }
    }
}

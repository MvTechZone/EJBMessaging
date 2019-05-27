import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class Database extends Component {
    private static final String DATABASE = "java_mdb";
    private static final String USER = "TechGuy";
    private static final String PASSWORD = "dev@techguy";
    private static final String CONN = "jdbc:mysql://localhost:3306/" + DATABASE;

    static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONN, USER, PASSWORD);
    }
}

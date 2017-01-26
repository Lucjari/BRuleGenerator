package Database;
import java.sql.*;

/**
 * Created by Martijn on 24-1-2017.
 */
public class Jdbc {

    private static Jdbc instance = new Jdbc();
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";


    private Jdbc() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection(String DB_URL, String USER, String PASS) {
        Connection connection = null;
        try {
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }

    public static Connection getToolConnection() {
        String DB_URL = "jdbc:oracle:thin:@//ondora02.hu.nl:8521/cursus02.hu.nl";
        String USER = "tosad_2016_2b_team4";
        String PASS = "tosad_2016_2b_team4";

        return instance.createConnection(DB_URL, USER, PASS);
    }

    public static Connection getTargetConnection(String DB_URL, String USER, String PASS) {
        return instance.createConnection(DB_URL, USER, PASS);
    }
}
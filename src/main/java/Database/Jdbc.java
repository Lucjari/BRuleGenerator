package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

class Jdbc {

    private static Jdbc instance = new Jdbc();
    private static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";


    private Jdbc() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection(String DB_URL, String USER, String PASS) throws SQLException{
        Connection connection;
        try {
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
            throw new SQLException(e);
        }
        return connection;
    }

    static Connection getToolConnection() throws SQLException{
        String DB_URL = "jdbc:oracle:thin:@//ondora02.hu.nl:8521/cursus02.hu.nl";
        String USER = "tosad_2016_2b_team4";
        String PASS = "tosad_2016_2b_team4";

        return instance.createConnection(DB_URL, USER, PASS);
    }

    static Connection getTargetConnection(Map<String, String> DBCredentials) throws SQLException{
        String DB_URL = DBCredentials.get("DB_URL");
        String USER = DBCredentials.get("USER");
        String PASS = DBCredentials.get("PASS");
        return instance.createConnection(DB_URL, USER, PASS);
    }
}
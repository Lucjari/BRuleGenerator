package Database;
import java.sql.*;

/**
 * Created by Martijn on 24-1-2017.
 */
public class Jdbc {
//STEP 1. Import required packages

    // JDBC driver name and database URL
    private static Jdbc instance = new Jdbc();
    static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    static final String DB_URL = "jdbc:oracle:thin:@//ondora02.hu.nl:8521/cursus02.hu.nl";

    //  Database credentials
    static final String USER = "tosad_2016_2b_team4";
    static final String PASS = "tosad_2016_2b_team4";

    private Jdbc() {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection createConnection() {
        Connection connection = null;
//        Statement stmt = null;
        try {
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
        }
        return connection;
    }

    public static Connection getConnection() {
        return instance.createConnection();
    }
}





//
//                //STEP 4: Execute a query
//                System.out.println("Creating statement...");
//                stmt = conn.createStatement();
//                String sql;
//                sql = "SELECT TEMPLATE_ID, TEMPLATE_VALUE, LANGUAGE_LANGUAGE_ID, BRTYPE_BUSINESSTYPE_ID FROM TEMPLATE";
//                ResultSet rs = stmt.executeQuery(sql);
//
//                //STEP 5: Extract data from result set
//                while(rs.next()){
//                    //Retrieve by column name
//                    int templateid  = rs.getInt("TEMPLATE_ID");
//                    String templatevalue = rs.getString("TEMPLATE_VALUE");
//                    int languageid = rs.getInt("LANGUAGE_LANGUAGE_ID");
//                    int brtype = rs.getInt("BRTYPE_BUSINESSTYPE_ID");
//
//                    //Display values
//                    System.out.print("ID: " + templateid);
//                    System.out.print(", Value: " + templatevalue);
//                    System.out.print(", Language: " + languageid);
//                    System.out.println(", Type: " + brtype);
//                }
//                //STEP 6: Clean-up environment
//                rs.close();
//                stmt.close();
//                conn.close();
//            }catch(SQLException se){
//                //Handle errors for JDBC
//                se.printStackTrace();
//            }catch(Exception e){
//                //Handle errors for Class.forName
//                e.printStackTrace();
//            }finally{
//                //finally block used to close resources
//                try{
//                    if(stmt!=null)
//                        stmt.close();
//                }catch(SQLException se2){
//                }// nothing we can do
//                try{
//                    if(conn!=null)
//                        conn.close();
//                }catch(SQLException se){
//                    se.printStackTrace();
//                }//end finally try
//            }//end try
//            System.out.println("Goodbye!");
//        }//end main
//    }//end FirstExample
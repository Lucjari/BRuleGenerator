package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


//Deze DAO klasse stuurt de query van de gegenereerde businessrule naar de target database om uit te voeren
class BRImplementDAO {
    private Connection connection;
    private Statement statement;

    void sendBusinessRule(String businessRule, String DB_URL, String USER, String PASS) throws SQLException {
        try{
            connection = Jdbc.getTargetConnection(DB_URL, USER, PASS);
            statement = connection.createStatement();

            statement.executeQuery(businessRule);
        }

        finally{
            if (statement != null){
                statement.close();}
            if (connection != null){
                connection.close();
                System.out.println("Connection to database closed.");}
        }
    }
}

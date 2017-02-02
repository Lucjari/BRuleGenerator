package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;


//Deze DAO klasse stuurt de query van de gegenereerde businessrule naar de target database om uit te voeren
class BRImplementDAO {
    private Connection connection;
    private Statement generatedTemplateStatement;

    void sendBusinessRule(String businessRule, Map<String, String> DBCredentials) throws SQLException {

        try{
            connection = Jdbc.getTargetConnection(DBCredentials);
            generatedTemplateStatement = connection.createStatement();

            //Uitvoeren van de trigger / constraint op de target database
            generatedTemplateStatement.executeQuery(businessRule);


        }

        finally{
            if (generatedTemplateStatement != null){
                generatedTemplateStatement.close();}
            if (connection != null){
                connection.close();
                System.out.println("Connection to database closed.");}
        }
    }


}

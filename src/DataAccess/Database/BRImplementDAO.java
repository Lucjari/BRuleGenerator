package DataAccess.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;


//This DAO inserts, updates or deletes triggers / constraints to / from target DataAccess.Database
class BRImplementDAO {
    private Connection connection;
    private Statement generatedTemplateStatement;
    private PreparedStatement deleteStatement;

    //apply trigger or constraint to target database
    void sendBusinessRule(String businessRule, Map<String, String> DBCredentials) throws SQLException {

        try{
            connection = Jdbc.getTargetConnection(DBCredentials);
            generatedTemplateStatement = connection.createStatement();

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

    //delete trigger or constraint from target database
    void deleteBusinessRule(Map<String, String> BRDefinition, Map<String, String> DBCredentials) throws SQLException {

        try{
            connection = Jdbc.getTargetConnection(DBCredentials);

            if (BRDefinition.get("TRIGGER_STATEMENT").equals("TRIGGER")){
                deleteStatement = connection.prepareStatement("DROP TRIGGER " + BRDefinition.get("NAME"));
            }
            else if (BRDefinition.get("TRIGGER_STATEMENT").equals("CONSTRAINT")){
                deleteStatement = connection.prepareStatement("ALTER TABLE" + BRDefinition.get("TARGET_TABLE") +" DROP CONSTRAINT " + BRDefinition.get("NAME"));
            }

            deleteStatement.executeQuery();
        }
        finally{
            if (deleteStatement != null){
                deleteStatement.close();
            }
            if (connection != null){
                connection.close();
                System.out.println("Connection to database closed.");
            }
        }
    }

}

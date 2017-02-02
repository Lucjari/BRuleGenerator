package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

//Deze DAO stuurt business rule definitions naar de target database
public class BRDImplementDAO {
    private Connection connection;
    private PreparedStatement brDefinitionStatement;

    void BRDtoTarget(Map<String, String> DBCredentials, Map<String, String> BRDefinition, String Action) throws SQLException {


        //Businessrule definition in de target database zetten of updaten
        try {
            connection = Jdbc.getTargetConnection(DBCredentials);
            brDefinitionStatement = null;

            if (Action.equals("INSERT")) {
                brDefinitionStatement = connection.prepareStatement("INSERT INTO GRULE (RULE_ID, DESCRIPTION, NAME, TARGET_TABLE, TARGET_COLUMN, TRIGGER_EVENT, OPERATOR, VALUE, VALUE2, COMPARE_TABLE, COMPARE_COLUMN, TRIGGER_ON, TRIGGER_STATEMENT, ISACTIVE, GRULETYPE_RULETYPE_ID, GLANGUAGE_LANG_ID) VALUES ('" + BRDefinition.get("RULE_ID") + "',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            } else if (Action.equals("UPDATE")) {
                brDefinitionStatement = connection.prepareStatement("UPDATE GRULE SET DESCRIPTION = ?, NAME = ?, TARGET_TABLE = ?, TARGET_COLUMN = ?, TRIGGER_EVENT = ?, OPERATOR = ?, VALUE = ?, VALUE2 = ?, COMPARE_TABLE = ?, COMPARE_COLUMN = ?, TRIGGER_ON = ?, TRIGGER_STATEMENT = ?, ISACTIVE = ?, GRULETYPE_RULETYPE_ID = ?, GLANGUAGE_LANG_ID = ? WHERE NAME= '" + BRDefinition.get("NAME") + "'");
            }
            brDefinitionStatement.setString(1, BRDefinition.get("DESCRIPTION"));
            brDefinitionStatement.setString(2, BRDefinition.get("NAME"));
            brDefinitionStatement.setString(3, BRDefinition.get("TARGET_TABLE"));
            brDefinitionStatement.setString(4, BRDefinition.get("TARGET_COLUMN"));
            brDefinitionStatement.setString(5, BRDefinition.get("TRIGGER_EVENT"));
            brDefinitionStatement.setString(6, BRDefinition.get("OPERATOR"));
            brDefinitionStatement.setString(7, BRDefinition.get("VALUE"));
            brDefinitionStatement.setString(8, BRDefinition.get("VALUE2"));
            brDefinitionStatement.setString(9, BRDefinition.get("COMPARE_TABLE"));
            brDefinitionStatement.setString(10, BRDefinition.get("COMPARE_COLUMN"));
            brDefinitionStatement.setString(11, BRDefinition.get("TRIGGER_ON"));
            brDefinitionStatement.setString(12, BRDefinition.get("TRIGGER_STATEMENT"));
            brDefinitionStatement.setInt(13, 1);
            brDefinitionStatement.setInt(14, Integer.parseInt(BRDefinition.get("GCUSTOMER_CUS_ID")));
            brDefinitionStatement.setInt(15, Integer.parseInt(BRDefinition.get("GLANGUAGE_LANG_ID")));


            brDefinitionStatement.executeQuery();
        } finally {
            if (brDefinitionStatement != null){
                brDefinitionStatement.close();            }
            if (connection != null) {
                connection.close();
                System.out.println("Connection to database closed.");
            }
        }

    }
}

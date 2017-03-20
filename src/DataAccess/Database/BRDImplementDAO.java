package DataAccess.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

//This DAO inserts, updates or deletes businessrule definition to / from target database
class BRDImplementDAO {
    private Connection connection;
    private PreparedStatement BRDStatement;
    private PreparedStatement BRDDeleteStatement;

    void BRDtoTarget(Map<String, String> DBCredentials, Map<String, String> BRDefinition, String Action) throws SQLException {

        try {
            connection = Jdbc.getTargetConnection(DBCredentials);

            if (Action.equals("INSERT")) {
                BRDStatement = connection.prepareStatement("INSERT INTO GRULE (RULE_ID, DESCRIPTION, NAME, TARGET_TABLE, TARGET_COLUMN, TRIGGER_EVENT, OPERATOR, VALUE, VALUE2, COMPARE_TABLE, COMPARE_COLUMN, TRIGGER_ON, TRIGGER_STATEMENT, ISACTIVE, GCUSTOMER_CUS_ID, GRULETYPE_RULETYPE_ID, GLANGUAGE_LANG_ID) VALUES ('" + BRDefinition.get("RULE_ID") + "',?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            } else if (Action.equals("UPDATE")) {
                BRDStatement = connection.prepareStatement("UPDATE GRULE SET DESCRIPTION = ?, NAME = ?, TARGET_TABLE = ?, TARGET_COLUMN = ?, TRIGGER_EVENT = ?, OPERATOR = ?, VALUE = ?, VALUE2 = ?, COMPARE_TABLE = ?, COMPARE_COLUMN = ?, TRIGGER_ON = ?, TRIGGER_STATEMENT = ?, ISACTIVE = ?, GCUSTOMER_CUS_ID = ?, GRULETYPE_RULETYPE_ID = ?, GLANGUAGE_LANG_ID = ? WHERE NAME= '" + BRDefinition.get("NAME") + "'");
            }
            BRDStatement.setString(1, BRDefinition.get("DESCRIPTION"));
            BRDStatement.setString(2, BRDefinition.get("NAME"));
            BRDStatement.setString(3, BRDefinition.get("TARGET_TABLE"));
            BRDStatement.setString(4, BRDefinition.get("TARGET_COLUMN"));
            BRDStatement.setString(5, BRDefinition.get("TRIGGER_EVENT"));
            BRDStatement.setString(6, BRDefinition.get("OPERATOR"));
            BRDStatement.setString(7, BRDefinition.get("VALUE"));
            BRDStatement.setString(8, BRDefinition.get("VALUE2"));
            BRDStatement.setString(9, BRDefinition.get("COMPARE_TABLE"));
            BRDStatement.setString(10, BRDefinition.get("COMPARE_COLUMN"));
            BRDStatement.setString(11, BRDefinition.get("TRIGGER_ON"));
            BRDStatement.setString(12, BRDefinition.get("TRIGGER_STATEMENT"));
            BRDStatement.setInt(13, 1);
            BRDStatement.setInt(14, Integer.parseInt(BRDefinition.get("GCUSTOMER_CUS_ID")));
            BRDStatement.setInt(15, Integer.parseInt(BRDefinition.get("GRULETYPE_RULETYPE_ID")));
            BRDStatement.setInt(16, Integer.parseInt(BRDefinition.get("GLANGUAGE_LANG_ID")));


            BRDStatement.executeQuery();
        } finally {
            if (BRDStatement != null) {
                BRDStatement.close();
            }
            if (connection != null) {
                connection.close();
                System.out.println("Connection to database closed.");
            }
        }

    }

    void deleteBRDTarget(Map<String, String> DBCredentials, Map<String, String> BRDefinition) throws SQLException {
        try {
            connection = Jdbc.getTargetConnection(DBCredentials);
            BRDDeleteStatement = connection.prepareStatement("DELETE FROM GRULE WHERE NAME = '" + BRDefinition.get("NAME") + "'");
            BRDDeleteStatement.executeQuery();
        } finally {
            if (BRDDeleteStatement != null) {
                BRDDeleteStatement.close();
            }
            if (connection != null) {
                connection.close();
                System.out.println("Connection to database closed.");
            }
        }

    }
}

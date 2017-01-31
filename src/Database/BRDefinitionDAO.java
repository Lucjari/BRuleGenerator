package Database;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;


//Deze DAO klasse haalt de businessrule definities uit de tooldatabase die overeenkomen met de te genereren businessrule
class BRDefinitionDAO {
    private Connection connection;
    private Statement statement;

    Map getBusinessRuleDefinition(int brID) throws SQLException {
        String query = "SELECT * FROM GRULE WHERE RULE_ID = " + brID;
        ResultSet rs = null;
        Map<String, String> BRDef = new HashMap<>();

        try{
            connection = Jdbc.getToolConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = rsmd.getColumnName(i);
                    if (rs.getString(i) != null) {
                        BRDef.put(columnName, rs.getString(i));
                    }
                }
            }

            return BRDef;

        } catch (SQLException e) {
            System.out.println("ERROR: Unable to Connect to Database.");
            throw new SQLException(e);
    }
        finally {
            if (rs != null){
                rs.close();}
            if (statement != null){
                statement.close();}
            if (connection != null){
                connection.close();
            System.out.println("Connection to database closed.");}


    }

    }
}

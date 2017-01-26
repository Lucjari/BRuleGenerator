package Database;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kvanwijngaarden on 18/01/2017.
 */
public class BRDefinitionDAO {
    private Connection connection;
    private Statement statement;

    public Map getBusinessRuleDefinition(int brID) throws SQLException{
        String query = "SELECT * FROM BUSINESSRULE WHERE BUSINESSRULE_ID = " + brID;
        ResultSet rs = null;
        Map BRDef = new HashMap();

        try{
            connection = Jdbc.getToolConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next()){
                BRDef.put("NAME", rs.getString("NAME"));
            }
        } catch (SQLException e) {
        System.out.println("ERROR: Unable to Connect to Database.");
    }
        finally {
            if (rs != null){
                rs.close();}
            if (statement != null){
                statement.close();}
            if (connection != null){
                connection.close();}
        return BRDef;
    }

    }
}

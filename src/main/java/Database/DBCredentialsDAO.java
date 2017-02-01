package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

//Deze DAO klasse haalt de target database credentials van de user op
class DBCredentialsDAO {
    private Connection connection;
    private Statement statement;

    Map getDBCredentials(Map<String, String> brdefinition) throws SQLException {
        String customerID = brdefinition.get("GCUSTOMER_CUS_ID");

        String query = "SELECT DATABASE_USERNAME, DATABASE_PASSWORD, CONNECTION_STRING FROM GCUSTOMER where CUS_ID='" + customerID + "'";
        ResultSet rs = null;
        Map<String, String> DBCredentials = new HashMap();

        try{
            connection = Jdbc.getToolConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                DBCredentials.put("USER", rs.getString("DATABASE_USERNAME"));
                DBCredentials.put("PASS", rs.getString("DATABASE_PASSWORD"));
                DBCredentials.put("DB_URL", rs.getString("CONNECTION_STRING"));
                    }

            return DBCredentials;

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
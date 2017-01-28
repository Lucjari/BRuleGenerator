package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//Deze DAO klasse haalt de template uit de tooldatabase die overeenkomt met de taal en businessrule type van de te genereren businessrule
class TemplateDAO {
    private Connection connection;
    private Statement statement;

    String getTemplate(int languageID, int ruletypeID) throws SQLException{
        String query = "SELECT TEMPLATE_VALUE FROM GTEMPLATE where GLANGUAGE_LANG_ID=" + languageID + " AND GRULETYPE_RULETYPE_ID=" + ruletypeID;
        ResultSet rs = null;
        String templateValue = null;
        try {
            connection = Jdbc.getToolConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next()){
                    templateValue = rs.getString("TEMPLATE_VALUE");
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
                connection.close();
                System.out.println("Connection to database closed.");}

            return templateValue;
    }

}
}

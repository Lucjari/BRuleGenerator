package Database;

/**
 * Created by Martijn on 24-1-2017.
 */
import java.sql.*;

public class TemplateDAO {
    private Connection connection;
    private Statement statement;

    public TemplateDAO(){}

    public String getTemplate(int templateid) throws SQLException{
        String query = "SELECT TEMPLATE_VALUE FROM TEMPLATE where TEMPLATE_ID=" + templateid;
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
            rs.close();
                statement.close();
                connection.close();
        return templateValue;
    }

}
}

package Database;

import java.sql.SQLException;
import java.util.Map;

public class DatabaseService {

    private BRDefinitionDAO definitionDAO = new BRDefinitionDAO();
    private TemplateDAO templateDAO = new TemplateDAO();
    private DBCredentialsDAO credentialsDAO = new DBCredentialsDAO();
    private BRImplementDAO implementDAO = new BRImplementDAO();

    public Map getBRDefinition(int brID) throws SQLException{
        return definitionDAO.getBusinessRuleDefinition(brID);
    }

    public String getTemplate(Map<String, String> brdefinition) throws SQLException{
        return templateDAO.getTemplate(brdefinition);
    }

    public Map getDBCredentials(Map<String, String> brdefinition) throws SQLException{
        return credentialsDAO.getDBCredentials(brdefinition);
    }

    public void sendBusinessRule(String businessRule, Map<String, String> DBCredentials) throws SQLException{
        implementDAO.sendBusinessRule(businessRule, DBCredentials);
    }

}

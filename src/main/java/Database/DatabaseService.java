package Database;

import java.sql.SQLException;
import java.util.Map;

public class DatabaseService {

    private BRDefinitionDAO definitionDAO = new BRDefinitionDAO();
    private TemplateDAO templateDAO = new TemplateDAO();
    private DBCredentialsDAO credentialsDAO = new DBCredentialsDAO();
    private BRImplementDAO brImplementDAO = new BRImplementDAO();
    private BRDImplementDAO brdImplementDAO = new BRDImplementDAO();

    public Map getBRDefinition(int brID) throws SQLException{
        return definitionDAO.getBusinessRuleDefinition(brID);
    }

    public String getTemplate(Map<String, String> BRDefinition) throws SQLException{
        return templateDAO.getTemplate(BRDefinition);
    }

    public Map getDBCredentials(Map<String, String> BRDefinition) throws SQLException{
        return credentialsDAO.getDBCredentials(BRDefinition);
    }

    public void sendBusinessRule(String businessRule, Map<String, String> DBCredentials) throws SQLException{
        brImplementDAO.sendBusinessRule(businessRule, DBCredentials);
    }

    public void deleteBusinessRule(Map<String, String> BRDefinition, Map<String, String> DBCredentials) throws SQLException{
        brImplementDAO.deleteBusinessRule(BRDefinition, DBCredentials);
    }

    public void BRDtoTarget(Map<String, String> DBCredentials, Map<String, String> BRDefinition, String Action) throws SQLException {
        brdImplementDAO.BRDtoTarget(DBCredentials, BRDefinition, Action);
    }

    public void deleteBRDTarget(Map<String, String> DBCredentials, Map<String, String> BRDefinition) throws SQLException {
        brdImplementDAO.deleteBRDTarget(DBCredentials, BRDefinition);
    }

}

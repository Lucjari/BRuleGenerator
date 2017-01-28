package Database;

import java.sql.SQLException;
import java.util.Map;

public class DatabaseService {

    private BRDefinitionDAO definitionDAO = new BRDefinitionDAO();
    private TemplateDAO templateDAO = new TemplateDAO();
    private BRImplementDAO implementDAO = new BRImplementDAO();

    public String getTemplate(int languageID, int ruletypeID) throws SQLException {
        return templateDAO.getTemplate(languageID, ruletypeID);
    }

    public Map getBRDefinition(int brID) throws SQLException{
        return definitionDAO.getBusinessRuleDefinition(brID);
    }

    public void sendBusinessRule(String businessRule, String DB_URL, String USER, String PASS) throws SQLException{
        implementDAO.sendBusinessRule(businessRule, DB_URL, USER, PASS);
    }

}

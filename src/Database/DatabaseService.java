package Database;

import java.sql.SQLException;
import java.util.Map;

/**
 * Created by kvanwijngaarden on 18/01/2017.
 */
public class DatabaseService {

    BRDefinitionDAO definitionDAO = new BRDefinitionDAO();
    TemplateDAO templateDAO = new TemplateDAO();

    public String getTemplate(int templateid) throws SQLException {
        return templateDAO.getTemplate(templateid);
    }

    public Map getBRDefinition(int brID) throws SQLException{;
        return definitionDAO.getBusinessRuleDefinition(brID);
    }

}

package Database;

import java.sql.SQLException;
import java.util.Map;

/**
 * Created by kvanwijngaarden on 18/01/2017.
 */
public class DatabaseService {

    DefinitionDAO definitionDAO = new DefinitionDAO();
    TemplateDAO templateDAO = new TemplateDAO();

    public String getTemplate(int templateid) throws SQLException {
        return templateDAO.getTemplate(templateid);
    }

    public Map getDefinition(String name, String code, String tekst){;
        return definitionDAO.getBusinessDefinition(name, code, tekst);
    }

}

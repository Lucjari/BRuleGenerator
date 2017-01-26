package Generator;

import java.sql.SQLException;
import java.util.Map;

/**
 * Created by kvanwijngaarden on 18/01/2017.
 */
public class Generator {
    private GeneratorService genService = new GeneratorService();

    public Map getBRDefinition(int brID) throws SQLException {
        return genService.getBRDefinition(brID);
    }

    public String getTemplate(int templateid) throws SQLException {
        return genService.getTemplate(templateid);
    }

    public void executeTemplate(int templateid, int brID) throws SQLException {
        String template = getTemplate(templateid);
        Map<String, String> definition = getBRDefinition(brID);


        for (Map.Entry<String, String> entry : definition.entrySet()) {
            template = template.replaceAll("\\b"+entry.getKey()+"\\b", entry.getValue());
        }

        System.out.println(template);


    }
}



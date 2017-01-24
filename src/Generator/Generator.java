package Generator;

import java.sql.SQLException;
import java.util.Map;

/**
 * Created by kvanwijngaarden on 18/01/2017.
 */
public class Generator {
    private GeneratorService genService = new GeneratorService();

    public Map getDefinition(String name, String code, String tekst) {
        return genService.getDefinition(name, code, tekst);
    }

    public String getTemplate(int templateid) throws SQLException {
        return genService.getTemplate(templateid);
    }

    public void executeTemplate(String name, String code, String tekst, int templateid) throws SQLException {
        String template = getTemplate(templateid);
        Map<String, String> definition = getDefinition(name, code, tekst);


        for (Map.Entry<String, String> entry : definition.entrySet()) {
            template = template.replaceAll("\\b"+entry.getKey()+"\\b", entry.getValue());
        }

        System.out.println(template);


    }
}



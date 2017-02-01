package Generator;

import Database.DatabaseService;

import java.sql.SQLException;
import java.util.Map;

class Generator {
    private DatabaseService dbService = new DatabaseService();

    Map getBRDefinition(int brID) throws SQLException {
        return dbService.getBRDefinition(brID);
    }

    String getTemplate(Map<String, String> brdefinition) throws SQLException {
        return dbService.getTemplate(brdefinition);
    }

    String generateTemplate(int brID) throws SQLException {
        Map<String, String> definition = getBRDefinition(brID);
        String template = getTemplate(definition);

        //Printen template voor vervangen steekwoorden
        System.out.println(template);

        for (Map.Entry<String, String> entry : definition.entrySet()) {
            template = template.replaceAll("\\b"+"xx"+entry.getKey()+"xx"+"\\b", entry.getValue());
        }

        //printen van gegenereerde template na vervangen steekwoorden
        System.out.println(template);

        return template;
    }

    void executeTemplate(int brID) throws SQLException{
        Map<String, String> BRDefinition = dbService.getBRDefinition(brID);
        Map<String, String> DBCredentials = dbService.getDBCredentials(BRDefinition);
        String generatedTemplate = generateTemplate(brID);

        dbService.sendBusinessRule(generatedTemplate, DBCredentials);

    }
}


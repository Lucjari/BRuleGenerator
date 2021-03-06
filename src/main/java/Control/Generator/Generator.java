package Control.Generator;

import DataAccess.Database.DatabaseService;

import java.sql.SQLException;
import java.util.Map;

class Generator {
    private DatabaseService dbService = new DatabaseService();

    String generateTemplate(int brID) throws SQLException {
        Map<String, String> definition = dbService.getBRDefinition(brID);
        String template = dbService.getTemplate(definition);

        for (Map.Entry<String, String> entry : definition.entrySet()) {
            template = template.replaceAll("\\b"+"xx"+entry.getKey()+"xx"+"\\b", entry.getValue());
        }
        return template;
    }

    void executeTemplate(int brID, String Action) throws SQLException{
        Map<String, String> BRDefinition = dbService.getBRDefinition(brID);
        Map<String, String> DBCredentials = dbService.getDBCredentials(BRDefinition);
        String generatedTemplate = generateTemplate(brID);

        dbService.sendBusinessRule(generatedTemplate, DBCredentials);
        dbService.BRDtoTarget(DBCredentials, BRDefinition, Action);

    }

    void deleteBusinessRule(int brID) throws SQLException{
        Map<String, String> BRDefinition = dbService.getBRDefinition(brID);
        Map<String, String> DBCredentials = dbService.getDBCredentials(BRDefinition);
        dbService.deleteBusinessRule(BRDefinition, DBCredentials);
        dbService.deleteBRDTarget(DBCredentials, BRDefinition);
    }
}


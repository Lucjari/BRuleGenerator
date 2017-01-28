package Generator;

import Database.DatabaseService;

import java.sql.SQLException;
import java.util.Map;

class Generator {
    private DatabaseService dbService = new DatabaseService();

    Map getBRDefinition(int brID) throws SQLException {
        return dbService.getBRDefinition(brID);
    }

    String getTemplate(int languageID, int ruletypeID) throws SQLException {
        return dbService.getTemplate(languageID, ruletypeID);
    }

    void executeTemplate(int languageID, int ruletypeID, int brID, String DB_URL, String USER, String PASS) throws SQLException {
        String template = getTemplate(languageID, ruletypeID);
        Map<String, String> definition = getBRDefinition(brID);


        for (Map.Entry<String, String> entry : definition.entrySet()) {
            template = template.replaceAll("\\b"+entry.getKey()+"\\b", entry.getValue());
        }

        //uitprinten van gegenereerde template ter controle voor test
        System.out.println(template);

        dbService.sendBusinessRule(template, DB_URL, USER, PASS);

    }
}



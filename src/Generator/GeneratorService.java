package Generator;

import Database.DatabaseService;

import java.sql.SQLException;
import java.util.Map;

/**
 * Created by kvanwijngaarden on 18/01/2017.
 */
public class GeneratorService {
    DatabaseService dbService = new DatabaseService();

    public String getTemplate(int templateid) throws SQLException{
        return dbService.getTemplate(templateid);
    }

    public Map getDefinition(String name, String code, String tekst){
        return dbService.getDefinition(name, code, tekst);
    }

    public void createTemplate(String name, String code, String tekst, int templateid) throws SQLException{
        new Generator().executeTemplate(name, code, tekst, templateid);
    }

}

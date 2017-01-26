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

    public Map getBRDefinition(int brID) throws SQLException{
        return dbService.getBRDefinition(brID);
    }

    public void executeTemplate(int templateid, int brID) throws SQLException{
        new Generator().executeTemplate(templateid, brID);
    }

}

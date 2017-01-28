package Generator;

import java.sql.SQLException;
import java.util.Map;

public class GeneratorService {
    private Generator generator = new Generator();

    public String getTemplate(int languageID, int ruletypeID) throws SQLException{
        return generator.getTemplate(languageID, ruletypeID);
    }

    public Map getBRDefinition(int brID) throws SQLException{
        return generator.getBRDefinition(brID);
    }

    public void executeTemplate(int languageID, int ruletypeID, int brID, String DB_URL, String USER, String PASS) throws SQLException{
        new Generator().executeTemplate(languageID, ruletypeID, brID, DB_URL, USER, PASS);
    }

}

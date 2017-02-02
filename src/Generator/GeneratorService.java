package Generator;

import java.sql.SQLException;
import java.util.Map;

public class GeneratorService {
    private Generator generator = new Generator();

    public String generateTemplate(int brID) throws SQLException{
        return generator.generateTemplate(brID);
    }

    public void executeTemplate(int brID, String Action) throws SQLException{
        generator.executeTemplate(brID, Action);
    }

}

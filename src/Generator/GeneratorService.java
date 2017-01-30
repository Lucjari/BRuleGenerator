package Generator;

import java.sql.SQLException;
import java.util.Map;

public class GeneratorService {
    private Generator generator = new Generator();

    public String getTemplate(Map<String, String> brdefinition) throws SQLException{
        return generator.getTemplate(brdefinition);
    }

    public Map getBRDefinition(int brID) throws SQLException{
        return generator.getBRDefinition(brID);
    }

    public String generateTemplate(int brID) throws SQLException{
        return generator.generateTemplate(brID);
    }

}

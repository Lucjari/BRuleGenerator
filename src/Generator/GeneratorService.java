package Generator;

import Database.DatabaseService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kvanwijngaarden on 18/01/2017.
 */
public class GeneratorService {
    DatabaseService dbService = new DatabaseService();

    public String getTemplate(){
        return dbService.getTemplate();
    }

    public Map getDefinition(String name, String code){
        return dbService.getDefinition(name, code);
    }

    public void CreateTemplate(String name, String code){
        new Generator().CreateTemplate(name, code);
    }

}

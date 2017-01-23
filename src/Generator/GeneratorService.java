package Generator;

import Database.DatabaseService;

import java.util.Map;

/**
 * Created by kvanwijngaarden on 18/01/2017.
 */
public class GeneratorService {
    DatabaseService dbService = new DatabaseService();

    public String getTemplate(){
        return dbService.getTemplate();
    }

    public Map getDefinition(String name, String code, String tekst){
        return dbService.getDefinition(name, code, tekst);
    }

    public void CreateTemplate(String name, String code, String tekst){
        new Generator().ExecuteTemplate(name, code, tekst);
    }

}

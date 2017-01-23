package Generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kvanwijngaarden on 18/01/2017.
 */
public class Generator {
    private GeneratorService genService = new GeneratorService();

    public HashMap GetDefinition(String name, String code){
        return genService.getDefinition(name, code);
    }

    public String GetTemplate(){
        return genService.getTemplate();
    }

    public void CreateTemplate(String name, String code){
        String template = GetTemplate();
        HashMap definition = new HashMap();
        definition = GetDefinition(name, code);

        String test = template.replaceAll("STEEKWOORD" , "" + definition.get(0));
        System.out.println(test);

    }


}



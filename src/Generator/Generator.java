package Generator;

import java.util.ArrayList;

/**
 * Created by kvanwijngaarden on 18/01/2017.
 */
public class Generator {
    private GeneratorService genService = new GeneratorService();

    public ArrayList GetDefinition(String name, String code){
        return genService.getDefinition(name, code);
    }

    public String GetTempalte(){
        return genService.getTemplate();
    }

    public void CreateTemplate(String name, String code){
        String template = GetTempalte();
        ArrayList definition = new ArrayList();
        definition = GetDefinition(name, code);

        String test = template.replaceAll("STEEKWOORD" , "" + definition.get(0));
        System.out.println(test);

    }


}



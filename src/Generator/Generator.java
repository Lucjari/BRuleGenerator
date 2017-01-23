package Generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by kvanwijngaarden on 18/01/2017.
 */
public class Generator {
    private GeneratorService genService = new GeneratorService();

    public Map GetDefinition(String name, String code){
        return genService.getDefinition(name, code);
    }

    public String GetTemplate(){
        return genService.getTemplate();
    }

    public void CreateTemplate(String name, String code){
        String template = GetTemplate();
        Map definition = new HashMap();
        definition = GetDefinition(name, code);

        Iterator it = definition.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            template.replaceAll("STEEKWOORD", pair.getKey() + " = " + pair.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
        System.out.println(template);
    }
}



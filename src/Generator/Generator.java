package Generator;

import java.util.Map;

/**
 * Created by kvanwijngaarden on 18/01/2017.
 */
public class Generator {
    private GeneratorService genService = new GeneratorService();

    public Map GetDefinition(String name, String code, String tekst) {
        return genService.getDefinition(name, code, tekst);
    }

    public String GetTemplate() {
        return genService.getTemplate();
    }

    public void ExecuteTemplate(String name, String code, String tekst) {
        String template = GetTemplate();
        Map<String, String> definition = GetDefinition(name, code, tekst);


        for (Map.Entry<String, String> entry : definition.entrySet()) {
            template = template.replaceAll("\\b"+entry.getKey()+"\\b", entry.getValue());
        }

        System.out.println(template);


    }
}



package Database;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by kvanwijngaarden on 18/01/2017.
 */
public class DefinitionDAO {

    public Map getBusinessDefinition(String name, String code, String tekst){
        Map def = new HashMap();

        def.put("NAME", name);
        def.put("CODE", code);
        def.put("TEXT", tekst);

        return def;

    }

}

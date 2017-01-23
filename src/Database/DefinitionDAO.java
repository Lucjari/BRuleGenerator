package Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kvanwijngaarden on 18/01/2017.
 */
public class DefinitionDAO {

    public Map getBusinessDefinition(String name, String code){
        Map def = new HashMap();

        def.put("name", name);
        def.put("code", code);

        return def;

    }

}

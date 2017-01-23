package Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kvanwijngaarden on 18/01/2017.
 */
public class DefinitionDAO {

    public HashMap getBusinessDefinition(String name, String code){
        HashMap def = new HashMap();

        def.put("key", name);
        def.put("value", code);

        return def;

    }

}

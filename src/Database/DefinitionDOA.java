package Database;

import java.util.ArrayList;

/**
 * Created by kvanwijngaarden on 18/01/2017.
 */
public class DefinitionDOA {

    public ArrayList getBusinessDefinition(String name, String code){
        ArrayList<String> def = new ArrayList<String>();

        def.add(name);
        def.add(code);

        return def;

    }

}

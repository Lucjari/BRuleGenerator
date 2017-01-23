package Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kvanwijngaarden on 18/01/2017.
 */
public class DatabaseService {

    DefinitionDAO defDoa = new DefinitionDAO();
    TemplateDAO temDao = new TemplateDAO();

    public String getTemplate(){
        return temDao.getBusinessTemplate();
    }

    public Map getDefinition(String name, String code){;
        return defDoa.getBusinessDefinition(name, code);
    }

}

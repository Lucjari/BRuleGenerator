package Database;

import java.util.ArrayList;

/**
 * Created by kvanwijngaarden on 18/01/2017.
 */
public class DatabaseService {

    DefinitionDOA defDoa = new DefinitionDOA();
    TemplateDAO temDao = new TemplateDAO();

    public String getTemplate(){
        return temDao.getBusinisTemplate();
    }

    public ArrayList getDefinition(String name, String code){;
        return defDoa.getBusinessDefinition(name, code);
    }

}

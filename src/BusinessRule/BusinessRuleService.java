package BusinessRule;

import java.util.ArrayList;

/**
 * Created by Kvanwijngaarden on 17-1-2017.
 */
public class BusinessRuleService {
    private ArrayList<IBusinessRule> businessRules = new ArrayList<IBusinessRule>();

    public void creatAttibuteRangeRule(String code, String category, String description, String name, String table, String column){
        IBusinessRule iBusinessRule = new AttributeRange(code, category, description, name, table, column);
        businessRules.add(iBusinessRule);
    }

    public void getBusinessRule(String naam){
        for(IBusinessRule i : businessRules){
            if(i.getName().equals(naam))
                i.Generate();
        }
    }

}

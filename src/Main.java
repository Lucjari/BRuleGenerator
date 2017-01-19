import BusinessRule.BusinessRuleService;

/**
 * Created by Kvanwijngaarden on 17-1-2017.
 */

//sdfsdfsdf sdf sdfsd f sdf ads f
//hallo daar
public class Main {

    public static void main(String args[]){

        BusinessRuleService businessRuleService = new BusinessRuleService();

        businessRuleService.creatAttibuteRangeRule("code", "category", "description", "Sjaak","table", "column");

        businessRuleService.getBusinessRule("Sjaak");

    }
}

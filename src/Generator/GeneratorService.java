package Generator;

import BusinessRule.IBusinessRule;

/**
 * Created by Kvanwijngaarden on 17-1-2017.
 */
public class GeneratorService {
    private Generator generator = new Generator();

    public void generateBusinessRule(IBusinessRule rule){
        generator.getTemplate(rule);
    }
}

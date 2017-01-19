package BusinessRule;
import Generator.GeneratorService;

/**
 * Created by Kvanwijngaarden on 17-1-2017.
 */
public class AttributeRange extends BusinessRule implements IBusinessRule{
    private GeneratorService generatorService = new GeneratorService();

    public AttributeRange(String code, String category, String description, String name, String table, String column) {
        super(code, category, description, name, table, column);
    }

    @Override
    public void Generate() {
        generatorService.generateBusinessRule(this);
    }

    @Override
    public String getName() {
        return super.getName();
    }
}

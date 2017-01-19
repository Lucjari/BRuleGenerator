package BusinessRule;

import java.util.Properties;

/**
 * Created by Kvanwijngaarden on 17-1-2017.
 */
public class BusinessRule {
    protected String code;
    protected String category;
    protected String Description;
    protected String name;
    protected String table;
    protected String column;

    public BusinessRule(String code, String category, String description, String name, String table, String column) {
        this.code = code;
        this.category = category;
        Description = description;
        this.name = name;
        this.table = table;
        this.column = column;
    }

    protected String getCode() {
        return code;
    }

    protected void setCode(String code) {
        this.code = code;
    }

    protected String getCategory() {
        return category;
    }

    protected void setCategory(String category) {
        this.category = category;
    }

    protected String getDescription() {
        return Description;
    }

    protected void setDescription(String description) {
        Description = description;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getTable() {
        return table;
    }

    protected void setTable(String table) {
        this.table = table;
    }

    protected String getColumn() {
        return column;
    }

    protected void setColumn(String column) {
        this.column = column;
    }
}

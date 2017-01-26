import Generator.GeneratorService;

import java.sql.SQLException;

/**
 * Created by kvanwijngaarden on 18/01/2017.
 */
public class Main {

    public static void main(String args[]) throws SQLException{
        GeneratorService gen = new GeneratorService();
//        System.out.println(gen.getTemplate(1));

//        gen.executeTemplate(1, 1);

        System.out.println(gen.getBRDefinition(1));

    }
}

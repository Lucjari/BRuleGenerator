import Control.Generator.GeneratorService;

import java.sql.SQLException;


//Alles wordt nu nog via de Main opgeroepen. Dit (en de methodes) moet(en) aangepast worden zodra de templates in de database staan en er samen met de restful webservice vanuit java getest kan worden.
public class Main {

    public static void main(String args[]) throws SQLException{
        GeneratorService gen = new GeneratorService();


//         gen.executeTemplate(59, "INSERT");
//         gen.deleteBusinessRule(59);
    }
}

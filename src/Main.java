import Generator.GeneratorService;

import java.sql.SQLException;


//Alles wordt nu nog via de Main opgeroepen. Dit (en de methodes) moet(en) aangepast worden zodra de templates in de database staan en er samen met de restful webservice vanuit java getest kan worden.
public class Main {

    public static void main(String args[]) throws SQLException{
        GeneratorService gen = new GeneratorService();

        //test voor het ophalen van een template uit de tool database
        System.out.println(gen.getTemplate(2, 10) + "\n");

        //test voor het ophalen van businessrule definitions uit de tool database
        System.out.println(gen.getBRDefinition(2) + "\n");

        //deze pas testen als er een goede template + definitie in database staat
        //gen.executeTemplate(parameters invoeren die kloppen met template en definitie);

    }
}

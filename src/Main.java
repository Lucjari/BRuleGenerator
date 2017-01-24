import Database.DBTemplateDAO;

import java.sql.SQLException;

/**
 * Created by kvanwijngaarden on 18/01/2017.
 */
public class Main {

    public static void main(String args[]){
//        GeneratorService gen = new GeneratorService();
//
//        gen.CreateTemplate("Mooie naam", "Rare Code", "ok");


        DBTemplateDAO test = new DBTemplateDAO();
        try{
            System.out.println(test.getTemplate(1));
        } catch (SQLException e) {
        System.out.println("ERROR: Unable to Connect to Database.");
    }
    }

}

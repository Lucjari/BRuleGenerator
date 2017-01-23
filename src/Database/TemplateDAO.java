package Database;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by kvanwijngaarden on 18/01/2017.
 */
public class TemplateDAO {

    public String getBusinessTemplate(){


        String content = "";

        try{
            content = new Scanner(new File("src//Database//test.txt")).useDelimiter("\\Z").next();
        }catch (IOException e){
            System.out.println(e);
        }

        return content;
    }





}

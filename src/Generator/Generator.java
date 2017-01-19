package Generator;

import BusinessRule.IBusinessRule;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Kvanwijngaarden on 17-1-2017.
 */
public class Generator {

    /*
       This should  access the DatabaseService to get the correct template.
       For this prototype we uses a TXT file to get a "template".
     */
    protected void getTemplate(IBusinessRule rule) {

        String content = "";

        try{
            content = new Scanner(new File("src/Generator/test.txt")).useDelimiter("\\Z").next();
        }catch (IOException e){
            System.out.println(e);
        }

        replaceAllKeywords(content, rule.getName());
    }

    private void replaceAllKeywords(String content, String name){

        String test = content.replaceAll("STEEKWOORD" , name);
        System.out.println(test);


    }



}

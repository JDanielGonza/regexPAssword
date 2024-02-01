/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.regexpassword;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author jadag
 */
public class RegexPassword {

    public static void main(String[] args) {
        List<String> passwords = new ArrayList<>();
        List<String> happyWord = new ArrayList<>();

        passwords.add("abcdinif323");
        passwords.add("happypassword");
        passwords.add("masdm32%&dog");
        passwords.add("abcdefghij");
        passwords.add("catAr$%&/pass6");
        passwords.add("pA55bird/%&56jk");

        happyWord.add("cat");
        happyWord.add("dog");
        happyWord.add("bird");
        happyWord.add("happy");

        List<String> result = strenghtPassword(passwords, happyWord);
        System.out.println(result);

    }

    public static List<String> strenghtPassword(List<String> passwords, List<String> happyPath) {

        List<String> result = new ArrayList<>();
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).*$";
        boolean valido = false;

        passwords.forEach(item -> {
            //System.out.println(item);
            happyPath.forEach(happyItem -> {
                //System.out.println(happyItem);
                if (item.contains(happyItem)) {
                    //System.out.println("Contraseña segura");
                    if(Pattern.matches(regex, item)){
                        //System.out.println("Contraseña segura: "+item);
                        result.add(item);
                    }
                    /*if (item.matches(".*[a-z].*") && item.matches(".*[A-Z].*")) {
                        if (item.matches(".*\\d.*")) {
                            //System.out.println("Contraseña segura: "+item);     
                            if (item.matches(".*[^a-zA-Z0-9].*")) {
                                System.out.println("Contraseña segura: " + item);
                            }
                        }
                    }*/
                };
            });
        });

        return result;
    }
}

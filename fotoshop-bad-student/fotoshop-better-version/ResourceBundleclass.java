import java.util.ResourceBundle;
import java.util.*;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rayhan aman
 */
public class ResourceBundleclass {
    
    public static void main (String[] args) {
        // gets resource bundle
        ResourceBundle bundle = ResourceBundle.getBundle("res/translation", Locale.ENGLISH);
        String translated = bundle.getString("txt_print"); // gets from properites
        System.out.println("text is: = + translated"); // prints out translation
    }
    
}

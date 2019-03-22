/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;


import Internationalisation.Internationalisation;
import Command.*;
import Editor.*;
import Tasks.*;
import Parser.*;
import Tasks.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Class for messages in User Interface
 * @author Team
 */


public class UI_Greetings {
    
    Internationalisation inter;
    Parser parser;
    
    Filtermanagement fm;
    
    /**
     *Constructor for UI Greetings
     */
    public UI_Greetings(){
        inter = new Internationalisation();
        parser = new Parser();
        fm = new Filtermanagement();
        
    
    }
    
    
    
    /**
     * Print out the opening message for the user.
     * @param name
     */
    public void printWelcome(String name) {
        System.out.println();
        System.out.println(inter.welcome);
        System.out.println(inter.description);
        System.out.println(inter.help);
        System.out.println();
        System.out.println(inter.current + name);
        
        fm.filterCheck();
        System.out.println();
    }
    
    /**
     *Method to print help options
     */
    public void printHelp() {
        System.out.println(inter.fotoshop);
        System.out.println();
        System.out.println(inter.explain);
        //System.out.println("   open save look mono fliph rot90 help quit script");
        parser.cmdwords.forEach((n) -> System.out.print(n + " "));
        System.out.println();
    }
     
    /**
     *method to print the user guide 
     */
    public void printUserGuide(){
        
         
        System.out.println(inter.ug_line1);
        System.out.println("-------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.println(inter.ug_line2);
        System.out.println();
        System.out.println(inter.ug_line3);
        System.out.println();
        System.out.println(inter.ug_line4);
        System.out.println();
        System.out.println(inter.ug_line5);
        System.out.println();
        System.out.println(inter.ug_line6);
        System.out.println();
        System.out.println(inter.ug_line7);
        System.out.println();
        System.out.println(inter.ug_line8);
        System.out.println(inter.ug_line9);
        System.out.println();
        System.out.println(inter.ug_line10);
        System.out.println();
        System.out.println(inter.ug_line11);
        System.out.println();
        System.out.println(inter.ug_line12);
        System.out.println(inter.ug_line13);
        System.out.println();
    
    
    }
     
}

    
    /**
     * Print out some help information. Here we print some useless, cryptic
     * message and a list of the command words.
     */
   


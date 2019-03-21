/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sk16acp
 */


public class UI_Greetings {
    
    Internationalisation inter;
    Parser parser;
    
    FilterManagement fm;
    
    public UI_Greetings(){
        inter = new Internationalisation();
        parser = new Parser();
        fm = new FilterManagement();
        
    
    }
    
    
    
    /**
     * Print out the opening message for the user.
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
    
    
     public void printHelp() {
        System.out.println(inter.fotoshop);
        System.out.println();
        System.out.println(inter.explain);
        //System.out.println("   open save look mono fliph rot90 help quit script");
        parser.cmdwords.forEach((n) -> System.out.print(n + " "));
        System.out.println();
    }
}

    
    /**
     * Print out some help information. Here we print some useless, cryptic
     * message and a list of the command words.
     */
   

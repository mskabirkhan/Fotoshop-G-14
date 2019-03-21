/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alpona
 */
public class UI_Greetings {
 
    Internationalisation in;
    FilterManagement FM;
    //String name;
    Parser parser;
    //persistence p;
    
    public UI_Greetings() {
        
        in = new Internationalisation();
        FM = new FilterManagement();
        parser = new Parser();
        //p = new persistence();
    }
        
    /**
     * Print out some help information. Here we print some useless, cryptic
     * message and a list of the command words.
     */
    public void printHelp() {
        System.out.println(in.fotoshop);
        System.out.println();
        System.out.println(in.explain);
        //System.out.println("   open save look mono fliph rot90 help quit script");
        parser.cmdwords.forEach((n) -> System.out.print(n + " "));
        System.out.println();
    }

    
    /**
     * Print out the opening message for the user.
     */
    public void printWelcome(String name) {
        //name = p.getName();
        System.out.println();
        System.out.println(in.welcome);
        System.out.println(in.description);
        System.out.println(in.help);
        System.out.println();
        System.out.println(in.current + name);
        
        FM.filterCheck();
        System.out.println();
    }

}

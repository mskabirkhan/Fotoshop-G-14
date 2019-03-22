
package Command;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * this is the enumerated class for all of the command words 
 * @author Team
 */
public enum CommandWords
{

    /**
     *
     */
    OPEN("open"),

    /**
     *
     */
    SAVE("save"),

    /**
     *
     */
    LOOK("look"),

    /**
     *
     */
    MONO("mono"),

    /**
     *
     */
    ROT90("rot90"),

    /**
     *
     */
    HELP("help"),

    /**
     *
     */
    QUIT("quit"),

    /**
     *
     */
    SCRIPT("script"),

    /**
     *
     */
    FLIPH("fliph"),

    /**
     *
     */
    UNDO("undo");


    // a variable to access the commands
    
    private String validCommands  ;
    

    /**
     * Constructor - initialise the command words.
     */
    CommandWords(String validCommands) {
        this.validCommands=validCommands;    
    }
    
    @Override
    /**
     * String representation of the class 
     * 
     * @param no parameter 
     * @return return String 
     * 
     */
    public String toString() {
        return validCommands;
    }   
}

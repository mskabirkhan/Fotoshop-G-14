import java.io.*;
/**
 * This class is derived from the "World of Zuul" application,
 * author Michael Kolling and David J. Barnes,
 * version 2006.03.30
 * This class holds an enumeration of all command words known to the editor.
 * It is used to recognise commands as they are typed in.
 *
 * @version 2013.09.09
 */

public enum CommandWords
{
    // a constant array that holds all valid command words
   // private static final String[] validCommands = {
        
       /**
        * command words
        */
        OPEN("open"),
        SAVE("save"),
        LOOK("look"),
        MONO("mono"),
        ROT90("rot90"),
        HELP("help"),
        QUIT("quit"),
        SCRIPT("script");

    private String CommandWords;

    //"open", "save", "look", "mono", "rot90", "help", "quit", "script"
   

    /**
     * Constructor - initialise the command words.
     */
    private CommandWords(String CMD)
    {
        this.CommandWords = CMD;
        // nothing to do at the moment...
    }
    
    public String toString() {
        return CommandWords;
    
    
    }
}
    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
//    public boolean isCommand(String aString)
//    {
//        for(int i = 0; i < validCommands.length; i++) {
//            if(validCommands[i].equals(aString))
//                return true;
//        }
//        // if we get here, the string was not found in the commands
//        return false;
//    }


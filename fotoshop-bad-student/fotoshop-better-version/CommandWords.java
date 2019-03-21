/**
 * This class is derived from the "World of Zuul" application,
 * author Michael Kolling and David J. Barnes,
 * version 2006.03.30
 * This class holds an enumeration of all command words known to the editor.
 * It is used to recognise commands as they are typed in.
 *
 * @version 2013.09.09
 */

public class CommandWords
{
    // a constant array that holds all valid command words
    private static final String[] validCommands = {
        "open", "save", "look", "mono", "rot90", "help", "quit", "script", "open", "put", "new"
    };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
      //String[] Strings = new String[] // the array is zero which is assigned below
      //new String (1,"open");  
       //new String (2,"save");      
       //new String (3,"look");     
       //new String (4,"mono");
      // new String (5,"rot90"); 
      // new String (6,"help");   
      // new String (7,"quit");      
      // new String (8,"script");  
      // new String (9,"put");     
      // new String (1,"new");    
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // if we get here, the string was not found in the commands
        return false;
    }
}


import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.imageio.ImageIO;


/**
 * This class is the main processing class of the Fotoshop application. 
 * Fotoshop is a very simple image editing tool. Users can apply a number of
 * filters to an image. That's all. It should really be extended to make it more
 * useful!
 *
 * To edit an image, create an instance of this class and call the "edit"
 * method.
 *
 * This main class creates and initialises all the others: it creates the parser
 * and  evaluates and executes the commands that the parser returns.
 *
 * @author Joseph Williams
 * @version 2018.12.12
 */

public class Editor {
   
    Parser parser;
    EditTools editTools;
    //cache c;
    
    /**
     * Create the editor and initialise its parser.
     */
    public Editor() {
        parser = new Parser();
        editTools = new EditTools();
        //c = new cache();
    }

    /**
     * Main edit routine. Loops until the end of the editing session.
     */
    public void edit() {
        editTools.ui.printWelcome(editTools.name);

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the editing session is over.
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println(editTools.inter.farewell);
    }

    

    /**
     * Given a command, edit (that is: execute) the command.
     *
     * @param command The command to be processed.
     * @return true If the command ends the editing session, false otherwise.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;
        
        if (command.isUnknown()) {
            System.out.println(editTools.inter.unknown);
            return false;
        }

        String [] commandWord = command.getCommandWord(); /// new change
        if (commandWord[0].equals("help")) {
            editTools.ui.printHelp();
        } else if (commandWord[0].equals("open")) {
            editTools.open(command);
        } else if (commandWord[0].equals("save")) {
            editTools.save(command);
        } else if (commandWord[0].equals("mono")) {
            editTools.mono(command);
        } else if (commandWord[0].equals("rot90")) {
            editTools.rot90(command);
        } else if (commandWord[0].equals("fliph")) {
            editTools.fliph(command);
        } else if (commandWord[0].equals("look")) {
            editTools.look(command);
        } else if (commandWord[0].equals("script")) {
            wantToQuit = script(command);
        } else if (commandWord[0].equals("quit")) {
            wantToQuit = quit(command);
        } else if (commandWord[0].equals("undo")){
            editTools.undoCommand();
            
        }
        

        return wantToQuit;
    }

   

    
    /**
     * The 'script' command runs a sequence of commands from a
     * text file.
     * 
     * IT IS IMPORTANT THAT THIS COMMAND WORKS AS IT CAN BE USED FOR TESTING
     * 
     * @param command the script command, second word of which is the name of 
     * the script file.
     * @return whether to quit.
     */
    private boolean script(Command command) {

        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to open...
            System.out.println(editTools.inter.script); 
            return false;
        }
  
        String[] scriptName = command.getCommandWord();
        Parser scriptParser = new Parser();
        try (FileInputStream inputStream = new FileInputStream(scriptName[1])) {
            scriptParser.setInputStream(inputStream);
            boolean finished = false;
            while (!finished) {
                try {
                    Command cmd = scriptParser.getCommand();
                    finished = processCommand(cmd);
                } catch (Exception ex) {
                    return finished;
                }               
            }
            return finished;
        } 
        catch (FileNotFoundException ex) {
            System.out.println(editTools.inter.find + scriptName[1]);
            return false;
        }
        catch (IOException ex) {
            throw new RuntimeException(editTools.inter.panic);
        }
    }
    
    /**
     * "Quit" was entered. Check the rest of the command to see whether we
     * really quit the editor.
     * @param command the command given.
     * @return true, if this command quits the editor, false otherwise.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println(editTools.inter.quit);
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }
 
}
 
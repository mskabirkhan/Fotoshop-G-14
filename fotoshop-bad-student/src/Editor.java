
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
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
    
    //initialisation of the fields 
    
    FilterManagement FM;
    Parser parser;
    String name;
    Internationalisation in;
    UI_Greetings UI;
    ProcessCmd_Script PCS;
   
    
    Cache cacheImage = new Cache(); //assigning the cache image to a new cache 
   
    /**
     * Create the editor and initialising the parameters 
     */
    public Editor() {
        parser = new Parser();
        FM = new FilterManagement();
        in = new Internationalisation();
        UI = new UI_Greetings();
        PCS = new ProcessCmd_Script();
    }

    /**
     * Main edit routine. Loops until the end of the editing session.
     */
    public void edit() {
        name = PCS.p.getName();
        UI.printWelcome(name);

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the editing session is over.
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = PCS.processCommand(command);
        }
        System.out.println("Thank you for using Fotoshop.  Good bye.");
    }
    
    //adds the image to the cache 
    private void put(String name ,String path ) {
        path = name ;
        cacheImage.addImage(name, path);
        FM.filterCheck();
        
    }
    
    //gets the name of the image 
    private void get(String nameincache) {
        
        cacheImage.getImage(nameincache);
    }

}

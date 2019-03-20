
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
    filtermanagement fm;
    Parser parser;
    ColorImage currentImage;
    String name;
    
    String language = "en";
    String country = "UK";
    
    Locale l = new Locale(language,country);
    ResourceBundle r = ResourceBundle.getBundle("Bundle_en_UK", l);
    
    String welcome = r.getString("welcome");
    String description = r.getString("description");
    String help = r.getString("help");
    String current = r.getString("current");
    String farewell = r.getString("farewell");
    String unknown = r.getString("unknown");
    String fotoshop = r.getString("fotoshop");
    String explain = r.getString("explain");
    String cannot = r.getString("cannot");
    String cwd = r.getString("cwd");
    String open = r.getString("open");
    String loaded = r.getString("loaded");
    String save = r.getString("save");
    String saved = r.getString("saved");
    String find = r.getString("find");
    String script = r.getString("script");
    String panic = r.getString("panic");
    String quit = r.getString("quit");
    String file = r.getString("file");
    String nme = r.getString("nme");
    String noimg = r.getString("noimg");
    String load = r.getString("load");
    String hlp = r.getString("hlp");
    
    
    
    cache cacheImage = new cache();
   
    /**
     * Create the editor and initialise its parser.
     */
    public Editor() {
        parser = new Parser();
        fm = new filtermanagement();
    }

    /**
     * Main edit routine. Loops until the end of the editing session.
     */
    public void edit() {
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the editing session is over.
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for using Fotoshop.  Good bye.");
    }

    /**
     * Print out the opening message for the user.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println(welcome);
        System.out.println(description);
        System.out.println(help);
        System.out.println();
        System.out.println(current + name);
        
        fm.filterCheck();
        System.out.println();
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
            System.out.println(unknown);
            return false;
        }

        String [] commandWord = command.getCommandWord(); /// new change
        if (commandWord[0].equals("help")) {
            printHelp();
        } else if (commandWord[0].equals("open")) {
            open(command);
        } else if (commandWord[0].equals("save")) {
            save(command);
        } else if (commandWord[0].equals("mono")) {
            mono(command);
        } else if (commandWord[0].equals("rot90")) {
            rot90(command);
        } else if (commandWord[0].equals("fliph")) {
            fliph(command);
        } else if (commandWord[0].equals("look")) {
            look(command);
        } else if (commandWord[0].equals("script")) {
            wantToQuit = script(command);
        } else if (commandWord[0].equals("quit")) {
            wantToQuit = quit(command);
        } 

        return wantToQuit;
    }
//----------------------------------
// Implementations of user commands:
//----------------------------------
    
    /**
     * Print out some help information. Here we print some useless, cryptic
     * message and a list of the command words.
     */
    private void printHelp() {
        System.out.println(fotoshop);
        System.out.println();
        System.out.println(explain);
        //System.out.println("   open save look mono fliph rot90 help quit script");
        parser.cmdwords.forEach((n) -> System.out.print(n + " "));
        System.out.println();
    }

    /**
     * Load an image from a file.
     * @param name The name of the image file
     * @return a ColorImage containing the image
     */
    private ColorImage loadImage(String name) {
        ColorImage img = null;
        try {
            img = new ColorImage(ImageIO.read(new File(name)));
        } catch (IOException e) {
            System.out.println(cannot + name);
            System.out.println(cwd + System.getProperty("user.dir"));
        }
        return img;
    }


    /**
     * "open" was entered. Open the file given as the second word of the command
     * and use as the current image. 
     * @param command the command given.
     */
    private void open(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to open...
            System.out.println(open);
            return ;
        }
  
        String[] inputName = command.getCommandWord();
        ColorImage img = loadImage(inputName[1]);
        if (img == null) {
            printHelp();
        } else {
            currentImage = img;
            name = inputName[1];
           // fm.filter1 = null;
            //fm.filter2 = null;
            //fm.filter3 = null;
            //fm.filter4 = null;
            System.out.println(loaded + name);
        }
    }

    /**
     * "save" was entered. Save the current image to the file given as the 
     * second word of the command. 
     * @param command the command given
     */
    private void save(Command command) {
        if(isImage()==false){return;};
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to save...
            System.out.println(save);
            return ;
        }
  
        String[] outputName = command.getCommandWord();
        try {
            File outputFile = new File(outputName[1]);
            ImageIO.write(currentImage, "jpg", outputFile);
            ImageIO.write(currentImage, "png", outputFile);
            System.out.println(saved + outputName[1]);
        } catch (Exception e){
            System.out.println("\n " + file + "\n " + nme);    
        } 
        
    }

    /**
     * "look" was entered. Report the status of the work bench. 
     * @param command the command given.
     */
    private void look(Command command) {
        if(isImage()==false){return;};
        System.out.println(current + name);
        fm.filterCheck();
        System.out.println();
    }

    /**
     * "mono" was entered. Convert the current image to monochrome. 
     * @param command the command given.
     */
    private void mono(Command command) {
        if(isImage()==false){return;}
        fm.checklastFilter();
        if(fm.ifFilterExist("mono")==false){return;}
        ColorImage tmpImage = new ColorImage(currentImage);
        //Graphics2D g2 = currentImage.createGraphics();
        int height = currentImage.getHeight();
        int width = currentImage.getWidth();
        
        for (int y=0; y<height; y++) {
            for (int x=0; x<width; x++) {
                Color pix = tmpImage.getPixel(x, y);
                int lum = (int) Math.round(0.299*pix.getRed()
                                         + 0.587*pix.getGreen()
                                         + 0.114*pix.getBlue());
                tmpImage.setPixel(x, y, new Color(lum, lum, lum));
            }
        }
        currentImage = tmpImage;
        fm.filterApplied("mono");
         
    
    }
    /**
     * "rot90" was entered. Rotate the current image 90 degrees. 
     * @param command the command given.
     */
    private void rot90(Command command) {
        if(isImage()==false){return;};
        fm.checklastFilter();
        // R90 = [0 -1, 1 0] rotates around origin
        // (x,y) -> (-y,x)
        // then transate -> (height-y, x)
        int height = currentImage.getHeight();
        int width = currentImage.getWidth();
        
        ColorImage rotImage = new ColorImage(height, width);
        
        for (int y=0; y<height; y++) { // in the rotated image
            for (int x=0; x<width; x++) {
                Color pix = currentImage.getPixel(x,y);
                rotImage.setPixel(height-y-1,x, pix);
            }
        }
        currentImage = rotImage;
        fm.filterApplied("rot90");
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
            System.out.println(script); 
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
            System.out.println(find + scriptName[1]);
            return false;
        }
        catch (IOException ex) {
            throw new RuntimeException(panic);
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
            System.out.println(quit);
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }
    
    
    
    private void fliph(Command command) {
        if(isImage()==false){return;};
        fm.checklastFilter();
       
        int height = currentImage.getHeight();
        int width = currentImage.getWidth();
     
        ColorImage flipImage = new ColorImage(width, height);
        
        for(int y = 0;y < height; y++){
            for(int x = 0; x < width; x++){
                Color pix = currentImage.getPixel(x,y);
                flipImage.setPixel( (width-1)-x , y , pix);
            }
        }
        
        currentImage = flipImage;
        fm.filterApplied("Flip Horizontal");
        put(name,name);
    }
    
    
    private void put(String name ,String path ) {
        path = name ;
        cacheImage.addImage(name, path);
        fm.filterCheck();
        
    }
    private void get(String nameincache) {
        
        cacheImage.getImage(nameincache);
    }
    
    private boolean isImage() {
        if (currentImage == null) {
            System.out.println(noimg+ "\n"+ load + "\n" + hlp);
            return false;
    }
        return true;
    }
}

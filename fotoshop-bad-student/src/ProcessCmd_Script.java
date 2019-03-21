
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alpona
 */
public class ProcessCmd_Script {
    
    FilterManagement fm;
    Parser parser;
    Internationalisation i;
    Mono m;
    Rot90 rt90;
    Fliph fh;
    InspectImage ilc;
    UI_Greetings ui;
    Persistence p ;
    
    String name;
    ColorImage currentImage;
    
    Cache cacheImage = new Cache();
   
    /**
     * Create the editor and initialise its parser.
     */
    public ProcessCmd_Script() {
        parser = new Parser();
        fm = new FilterManagement();
        i = new Internationalisation();
        m = new Mono();
        rt90 = new Rot90();
        fh = new Fliph(); 
        ui = new UI_Greetings();
        p = new Persistence();
        ilc = new InspectImage();
    }
    
    /**
     * Given a command, edit (that is: execute) the command.
     *
     * @param command The command to be processed.
     * @return true If the command ends the editing session, false otherwise.
     */
    public boolean processCommand(Command command) {
        
        
        boolean wantToQuit = false;
        
        if (command.isUnknown()) {
            System.out.println(i.unknown);
            ui.printHelp();
            return false;
        }

        String [] commandWord = command.getCommandWord(); /// new change
          if (commandWord[0].equals("help")) {
            ui.printHelp();
        } else if (commandWord[0].equals("open")) {
            p.open(command);
        } else if (commandWord[0].equals("save")) {
            p.save(command);
        } else if (commandWord[0].equals("mono")) {
            m.monofilter(command);
        } else if (commandWord[0].equals("rot90")) {
            rt90.rot90filter(command);
        } else if (commandWord[0].equals("fliph")) {
            fh.fliphfilter(command);
        } else if (commandWord[0].equals("look")) {
            look(command);
        } else if (commandWord[0].equals("script")) {
            wantToQuit = scriptText(command);
        } else if (commandWord[0].equals("quit")) {
            wantToQuit = quit(command);
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
    public boolean scriptText(Command command) {

        
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to open...
            System.out.println(i.script); 
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
            System.out.println(i.find + scriptName[1]);
            return false;
        }
        catch (IOException ex) {
            throw new RuntimeException(i.panic);
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
            System.out.println(i.quit);
            return false;
        } else {
            return true;  // signal that we want to quit
        }
    }

    public void look(Command command) {
        name = p.getName();
        currentImage = p.getCurrentImage();
        if(ilc.isImage(currentImage)==false){return;};
        System.out.println(i.current + name);
        fm.filterCheck();
        int a = fm.filtersStorage.size();
        for(int i = 1;i <= fm.filtersStorage.size();i++){
    
            String abc = fm.filtersStorage.get("filter"+i);
            System.out.println(abc);
            
                }
        
        System.out.println(a);
        System.out.println();
    }

}

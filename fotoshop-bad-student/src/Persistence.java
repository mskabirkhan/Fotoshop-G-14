
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alpona
 */
public class Persistence {
    
    
    Parser parser;
    public static ColorImage currentImage;
    public static String name;
    Internationalisation i;
    InspectImage ilc;
    int size ;
    FilterManagement fm;
    
    UI_Greetings ui;
    ProcessCmd_Script pcs;
    
    public Persistence() {
        
        parser = new Parser();
        i = new Internationalisation();
        ui = new UI_Greetings();
        ilc = new InspectImage();
        fm = new FilterManagement();
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
            System.out.println(i.cannot + name);
            System.out.println(i.cwd + System.getProperty("user.dir"));
        }
        return img;
    }


    /**
     * "open" was entered. Open the file given as the second word of the command
     * and use as the current image. 
     * @param command the command given.
     */
    public void open(Command command) {
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to open...
            System.out.println(i.open);
            return ;
        }
  
        String[] inputName = command.getCommandWord();
        ColorImage img = loadImage(inputName[1]);
        this.setCurrentImage(img);
        this.setName(inputName[1]);
        if (img == null) {
            ui.printHelp();
        } else {
            currentImage = img;
            //this.setCurrentImage(currentImage);
            name = inputName[1];
            //this.setName(name);
            /*
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("How many filters would you like ? ");
            int s = 0;
            boolean test = false ;
            while(test==false){
                if(myObj.hasNextInt()){
                    s = myObj.nextInt();
                    //fm.setsize(size);
                    test = true;
                } else if(!myObj.hasNextInt()){
                    System.out.println("You didn't type an integer."+"\nPlease , type and integer value.");
                    myObj.next();
                }    
            }
            this.setSize(size);
            */
            System.out.println("Number of filters : "+ fm.filtersStorage.size());   
            System.out.println(i.loaded + name);
        }
    }

    /**
     * "save" was entered. Save the current image to the file given as the 
     * second word of the command. 
     * @param command the command given
     */
    public void save(Command command) {
        if(ilc.isImage(currentImage)==false){return;};
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to save...
            System.out.println(i.save);
            return ;
        }
  
        String[] outputName = command.getCommandWord();
        try {
            File outputFile = new File(outputName[1]);
            ImageIO.write(currentImage, "jpg", outputFile);
            ImageIO.write(currentImage, "png", outputFile);
            System.out.println(i.saved + outputName[1]);
        } catch (Exception e){
            System.out.println("\n " + i.file + "\n " + i.nme);    
        } 
        
    }
     
    private void setCurrentImage(ColorImage currentImage) {
        this.currentImage=currentImage;
    }
    
    public ColorImage getCurrentImage(){
        return currentImage;
    }
    
    private void setName(String nme) {
        this.name=nme;
    }
    
    public String getName() {
        return name;
    }
    
    private void setSize(int sz) {
        this.size = sz;
    }
    
    public int getSize() {
        return size;
    }
}

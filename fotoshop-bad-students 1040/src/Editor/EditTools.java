
package Editor;

import Internationalisation.Internationalisation;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import Command.*;
import Image.*;
import Tasks.*;
        

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Class to initialise all the features 
 * @author Team
 */
public class EditTools {
    
    int openCounter;
    int lastOpenCounter;
    Cache c;
    Filtermanagement fm;
   
    ColorImage currentImage;
    String name;
    
   
    public Internationalisation inter;
    UI_Greetings ui;
    
    /**
     * Constructor to initialise the fields 
     */
    public EditTools(){
        
        fm = new Filtermanagement();
        inter = new Internationalisation();
        ui = new UI_Greetings();
        c = new Cache();
     }
    
    
//----------------------------------
// Implementations of user commands:
//----------------------------------

    /**
     * Load an image from a file.
     * @param name The name of the image file
     * @return a ColorImage containing the image
     */
    public ColorImage loadImage(String name) {
        ColorImage img = null;
        try {
            img = new ColorImage(ImageIO.read(new File(name)));
        } catch (IOException e) {
            System.out.println(inter.cannot + name);
            System.out.println(inter.cwd + System.getProperty("user.dir"));
        }
        return img;
    }


    /**
     * "open" was entered. Open the file given as the second word of the command
     * and use as the current image. 
     * @param command the command given.
     */
    public void open(Command command) {
        
        if(this.currentImage != null){
            System.out.println("Please save your image before opening a new one" + "\nOtherwise you'll loose your progress");
            return ;
        }

          if (!command.hasSecondWord()) {
            // if there is no second word, we don't know what to open...
            System.out.println(inter.open);
            return ;
        }
  
        String[] inputName = command.getCommandWord();
        ColorImage img = loadImage(inputName[1]);
        if (img == null) {
            ui.printHelp();
        } else {  
            
            currentImage = img;
            name = inputName[1];
            setImage(img);
            setName(name);
            
            fm.setupCmdWords();
            System.out.println(inter.loaded + name);
            cacheAdd(null);
        }
        
    }

    /**
     * "save" was entered. Save the current image to the file given as the 
     * second word of the command. 
     * @param command the command given
     */
     public void save(Command command) {
        if(isImage()==false){return;};
        if (!command.hasSecondWord()) {
            // if there is no second word, we don't know where to save...
            System.out.println(inter.save);
            return ;
        }
  
        String[] outputName = command.getCommandWord();
        try {
            File outputFile = new File(outputName[1]);
            ImageIO.write(currentImage, "jpg", outputFile);
            ImageIO.write(currentImage, "png", outputFile);
            System.out.println(inter.saved + outputName[1]);
            c.clearCache();
            currentImage = null;
        } catch(RuntimeException e) {
            throw e;
        } catch (Exception e){
            System.out.println("\n " + inter.file + "\n " + inter.nme);    
        } 
        
    }
    
    /**
     * "look" was entered. Report the status of the work bench. 
     * @param command the command given.
     */
    public void look(Command command) {
        if(isImage()==false){return;};
        System.out.println(inter.current + name);
        fm.filterCheck();
        System.out.println();
    }

    /**
     * "mono" was entered. Convert the current image to monochrome. 
     * @param command the command given.
     */
    public void mono(Command command) {
        if(isImage()==false){return;}
        fm.checklastFilter();
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
        if(fm.filtersStorage.size() >= c.cacheNo){
        cacheAdd("mono");
        } else {
            return ; 
        }
    
    }
    /**
     * "rot90" was entered. Rotate the current image 90 degrees. 
     * @param command the command given.
     */
    public void rot90(Command command) {
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
        if(fm.filtersStorage.size() >= c.cacheNo){
        cacheAdd("rot90");
        } else {
            return ; 
        }
    }
    
    /**
     *fliph command to flip the image horizontally 
     * @param command
     */
    public void fliph(Command command) {
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
        if(fm.filtersStorage.size() >= c.cacheNo){
        cacheAdd("Flip Horizontal");
        } else {
            return ; 
        }
    }
    
    /**
     *undo the filter 
     */
    public void undoCommand(){
        currentImage = c.undo(name);
        fm.deleteLastFilter();
    }
    
    /**
     *add image to the cache 
     * @param filter
     */
    public void cacheAdd(String filter){
        
        c.addToCache(name, currentImage,filter); 
    }
    
    /**
     *checking if image is null or not 
     * @return
     */
    public boolean isImage() {
        if (currentImage == null) {
            System.out.println(inter.noimg+ "\n"+ inter.load + "\n" + inter.hlp);
            return false;
    }
        return true;
    }
    public void setName(String nme){
        this.name = nme;
    }
    public String getName(){
        return name;
    }
     public void setImage(ColorImage img){
       this.currentImage = img;
    }
     public ColorImage getImage(){
         return currentImage;
     }
    
    
    
    
    
}


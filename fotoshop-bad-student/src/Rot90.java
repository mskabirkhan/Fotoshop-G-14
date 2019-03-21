
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alpona
 */
public class Rot90 {
    
    ColorImage currentImage;
    FilterManagement fm;
    Internationalisation i ;
    InspectImage ilc;
    Persistence p;
   
    
    public Rot90(){
        fm = new FilterManagement();
        i = new Internationalisation();
        ilc = new InspectImage();
        p = new Persistence();
    }
    
       /**
     * "Rot90" was entered. Rotate the current image 90 degrees. 
     * @param command the command given.
     */
    public void rot90filter(Command command) {
        currentImage = p.getCurrentImage();
        if(ilc.isImage(currentImage)==false){return;};
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
    
}

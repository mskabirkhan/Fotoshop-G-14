
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
public class Fliph {
    ColorImage currentImage;
    FilterManagement fm;
    Internationalisation i ;
    Persistence p;
    InspectImage ilc;
    
    public Fliph(){
        fm = new FilterManagement();
        i = new Internationalisation();
        p = new Persistence();
        ilc = new InspectImage();
    }
        
    
    public void fliphfilter(Command command) {
        currentImage = p.getCurrentImage();
        if(ilc.isImage(currentImage)==false){return;};
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
        //put(name,name);
    }

}

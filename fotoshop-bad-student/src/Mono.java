
import java.awt.Color;
import java.util.Locale;
import java.util.ResourceBundle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alpona
 */
public class Mono {
   
    FilterManagement FM;
    Internationalisation in ;
    Persistence ps;
    ColorImage currentImage;
    InspectImage ilc;
    String name;
    
    
    
    public Mono(){
        
        FM = new FilterManagement();
        in = new Internationalisation();
        //currentImage = Persistence.currentImage;
        ps = new Persistence();
        ilc = new InspectImage();
        
        
    }
    
    /**
     * "Mono" was entered. Convert the current image to monochrome. 
     * @param command the command given.
     */
    public void monofilter(Command command) {
        currentImage = ps.getCurrentImage();
        name = ps.getName();
        if(ilc.isImage(currentImage)==false){return;}
        FM.checklastFilter();
        if(FM.ifFilterExist("mono")==false){return;}
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
        System.out.println(name);
        FM.filterApplied("mono");
        //fm.filterCheck();
         
    }
     
}

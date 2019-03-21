/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alpona
 */
public class InspectImage {
    
    Internationalisation in;
    
    public InspectImage(){
        in = new Internationalisation(); //new object Internationalisation assigned to variable i 
    }
    
    //if the image is empty print the message inside the if condition else return true
    public boolean isImage(ColorImage currentImage) {
        if (currentImage == null) {
            System.out.println(in.noimg+ "\n"+ in.load + "\n" + in.hlp);
            return false;
    }
        return true;
    }
}


import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alpona
 */
public class Cache {
    
    public Map<String, String> savedImages = new HashMap<String , String>();
    
    
    
    public String getImage(String name) { 

       String found = null;
       
       if(savedImages.containsKey(name))
       {
           System.out.println("found");
           System.out.println(savedImages.get(name));
           return savedImages.get(name);
       }
       else
       {
       return null;
       }
   }
    
    public boolean checkExistence(String name) {
        
        if(savedImages.containsKey(name)) {
            return true;
        } else {
            return false;
        }
   }
    
    public void addImage(String name, String path) {
   
        savedImages.put(name, "cache/"+path);
        System.out.println("Image " + name + " added to cache.");
    
    }
    
    public void deleteImage(String name,String path) {
        savedImages.remove(name, "cache/"+path);    
    }
}

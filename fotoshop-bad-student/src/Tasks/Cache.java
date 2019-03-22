/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;


import Image.*;
import Command.*;
import Editor.*;
import Tasks.*;

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
    
    /**
     *
     */
    public int cacheNo;
    ColorImage img;
    private Map<String, ColorImage> cacheImages = new HashMap<String , ColorImage>();
    private Map<String, String> filters = new HashMap<String , String>();
    
    /**
     *
     */
    public Cache() { }
    
    /**
     *
     * @param filename
     * @param img
     * @param filter
     */
    public void addToCache(String filename, ColorImage img, String filter){
            
            
            cacheImages.put("cache"+cacheNo, img);
            filters.put("cache"+ cacheNo + filename, filter);
            System.out.println("Image added to cache");
            System.out.println("CacheNo= "+ cacheNo);
            System.out.println(cacheImages);
            System.out.println(filters.toString());
            cacheNo++;
    }
    
    /**
     *
     * @param filename
     * @return
     */
    public ColorImage undo(String filename){
        
        if (cacheImages.isEmpty() == false && filters.isEmpty() == false){
            String filterName = filters.get("cache" + (cacheNo-1) + filename);
            img = cacheImages.get("cache" + (cacheNo -2));
            cacheImages.remove("cache" + (cacheNo - 1));
            filters.remove("cache" + (cacheNo - 1) + filename);
            cacheNo--;
            System.out.println("CacheNo= "+ cacheNo);
            System.out.println("Filter " + filterName + " on file " + filename + " is undone");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("-------------------------------------------------");
            System.out.println(cacheImages);
            System.out.println(filters);
            
        } else { 
            System.out.println("Cache is empty");
        }
        return img;
    }
    
    /**
     *
     */
    public void clearCache(){
        cacheImages.clear();
        filters.clear();
        cacheNo = 0;
        System.out.println("Cache cleared");
    }
    
    
}
    

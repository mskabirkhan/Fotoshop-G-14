/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tasks;
import Internationalisation.Internationalisation;
import Command.*;
import Editor.*;
import Tasks.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
/**
 *
 * @author Team
 */
public class Filtermanagement {
    
    private Internationalisation inter;
    
    
    public Map<String, String> filtersStorage = new HashMap<String , String>();
    
    /**
     *constructor of the class
     */
    public Filtermanagement() {
        setupCmdWords();
        inter = new Internationalisation();
    }
    
    /**
     *method to check whether the filter is applied 
     */
    public void filterCheck()
    {
        System.out.println();
        for (int i = 1; i <= filtersStorage.size(); i++) {
            if(filtersStorage.get("filter"+i)!=null){
                String f = filtersStorage.get("filter"+i);
                System.out.println(f);
                
            }
            }
        
    }
    
    /**
     *method to apply the filter
     * @param s
     */
    public void filterApplied(String s)
    {
        for (int i = 1; i <= filtersStorage.size(); i++) {
            if(filtersStorage.get("filter"+i)==null){
                filtersStorage.put("filter"+i, s);
                return;
            }
            }
        }
    
    /**
     *method to check the last filter 
     */
    public void checklastFilter()
    {
        if (filtersStorage.get("filter"+ filtersStorage.size()) != null) {
            System.out.println(inter.exceeded);
            return;
        }
    }
    
    /**
     * method to delete the last filter
     */
    public void deleteLastFilter(){
        for (int i = 1; i <= filtersStorage.size(); i++) {
            if(filtersStorage.get("filter"+i)==null){
                
                filtersStorage.remove("filter"+(i-1));
                return;
            }
        }
    }
    
   
    /**
     *method to setup command words
     */
    public void setupCmdWords() {
     
    for (int i = 1; i <= 10; i++) {
            
        filtersStorage.put("filter"+i, null);

            }    
    }
   
}
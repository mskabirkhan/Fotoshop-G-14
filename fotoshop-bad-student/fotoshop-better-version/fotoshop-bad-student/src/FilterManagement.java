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
 * @author sk16acp
 */
public class FilterManagement {
    
    Internationalisation inter;
    
    public Map<String, String> filtersStorage = new HashMap<String , String>();
    
    
    
    FilterManagement() {
        setupCmdWords();
        inter = new Internationalisation();
    }
    
    public void filterCheck()
    {
        System.out.println(inter.filters);
        for (int i = 1; i <= filtersStorage.size(); i++) {
            if(filtersStorage.get("filter"+i)!=null){
                String f = filtersStorage.get("filter"+i);
                System.out.println(f);
                
            }
            }
        
    }
    
    public void filterApplied(String s)
    {
        for (int i = 1; i <= filtersStorage.size(); i++) {
            if(filtersStorage.get("filter"+i)==null){
                filtersStorage.put("filter"+i, s);
                return;
            }
            }
        
        
        }
    
        
    
    
    public void checklastFilter()
    {
        if (filtersStorage.get("filter"+ filtersStorage.size()) != null) {
            System.out.println(inter.exceeded);
            return;
        }
    }
    
    public void deleteLastFilter(){
        for (int i = 1; i <= filtersStorage.size(); i++) {
            if(filtersStorage.get("filter"+i)==null){
                
                filtersStorage.remove("filter"+(i-1));
                return;
            }
            }
        
    }
    
   
    
    
//    public boolean ifFilterExist(String s) {
//        
//        for (int i = 1; i <= filtersStorage.size(); i++) {
//            
//            if (filtersStorage.get("filter"+ i).equals(s)) {
//            System.out.println("applied" + "\nCant be applied again");
//            return false;
//            } 
//        }
//       return true;
//    }
//    
        
     
        
    

    
    public void setupCmdWords() {
     
    for (int i = 1; i <= 10; i++) {
            
        filtersStorage.put("filter"+i, null);

            }    
    }
   
}
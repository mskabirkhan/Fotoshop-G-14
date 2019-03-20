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
 * @author alpona
 */
public class filtermanagement {
    
    public Map<String, String> filtersStorage = new HashMap<String , String>();
    
    String language = "en";
    String country = "UK";
    
    Locale l = new Locale(language,country);
    ResourceBundle r = ResourceBundle.getBundle("Bundle_en_UK", l);
    
    String exceeded = r.getString("exceeded");
    String filters = r.getString("filters");
    
    filtermanagement() {
        setupCmdWords();
    }
    
    public void filterCheck()
    {
        System.out.println(filters);
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
            System.out.println(exceeded);
            return;
        }
    }
    
    public boolean ifFilterExist(String s) {
        
        for (int i = 1; i <= filtersStorage.size(); i++) {
            
            if (filtersStorage.get("filter"+ i).equals(s)) {
            System.out.println("applied" + "\nCant be applied again");
            return false;
            } 
        }
       return true;
    }
    
        
     
        
    

    
    public void setupCmdWords() {
     
    for (int i = 1; i <= 4; i++) {
            
        filtersStorage.put("filter"+i, null);

            }    
    }
    public static void main(String[] args) {
        filtermanagement fm = new filtermanagement();
        fm.filterApplied("mono");
        fm.filterCheck();
        if(fm.ifFilterExist("mono")==false){
            System.out.println("dasdsa");
        }
        fm.filterCheck();
        System.out.println((fm.filtersStorage.get("filter1")));
        System.out.println((fm.filtersStorage.get("filter2")));
        System.out.println((fm.filtersStorage.get("filter3")));
        System.out.println((fm.filtersStorage.get("filter4")));
        System.out.println(fm.filtersStorage.size());
    }

}
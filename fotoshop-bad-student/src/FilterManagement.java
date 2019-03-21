/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author alpona
 */
public class FilterManagement {
    
    /**
     *
     */
    public Map<String, String> filtersStorage = new HashMap<String , String>();
    
    Internationalisation in ;
    //persistence p ;
    
    int f = 0;
    
    public FilterManagement() {
        in = new Internationalisation();
        //p = new persistence();
        this.setupfilterWords();
      
    }
    
    /**
     *
     */
    public void filterCheck()
    {
        System.out.println(in.filters);
        for (int i = 1; i <= filtersStorage.size(); i++) {
            if(filtersStorage.get("filter"+i)!=null){
                String f = filtersStorage.get("filter"+i);
                System.out.println(f);
                
            }
            }
        
    }
    
    /**
     *
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
     *
     */
    public void checklastFilter()
    {
        if (filtersStorage.get("filter"+ filtersStorage.size()) != null) {
            System.out.println(in.exceeded);
            return;
        }
    }
    
    /**
     *
     * @param s
     * @return
     */
    public boolean ifFilterExist(String s) {
        
        for (int i = 1; i <= filtersStorage.size(); i++) {
            
            if (filtersStorage.containsValue(s)) {
            System.out.println("applied" + "\nCant be applied again");
            return false;
            } 
        }
       return true;
     }
    
    /**
     *
     */
    public void setupfilterWords() {
     
    for (int i = 1; i <= 10; i++) {
            
        filtersStorage.put("filter"+i, null);

            }    
    }
    
    
    /*
    public static void main(String[] args) {
        FilterManagement fm = new FilterManagement();
        fm.filterApplied("mono");
        Scanner ab = new Scanner(System.in); 
        int a = ab.nextInt();
        //fm.setupfilterWords(a);
        System.out.println(fm.filtersStorage.size());
        fm.filterApplied("mono");
        System.out.println("sadsa ");
        fm.filterCheck();
    }*/
}
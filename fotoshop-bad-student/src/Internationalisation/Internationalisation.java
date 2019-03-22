/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Internationalisation;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * Class to implement the internationalisation for the project 
 * @author Team
 */
public class Internationalisation {
    
    String language ;
    String country ;
    
   
    public Locale l;

   
    public ResourceBundle r;
    
  
    public String welcome ;

   
    public String description ;

   
    public String help;

  
    public String current;

   
    public String filters;

   
    public String farewell;

    
    public String unknown;

   
    public String fotoshop;

  
    public String explain;

    
    public String cannot;

    
    public String cwd;

   
    public String open;

   
    public String loaded;

  
    public String save;

  
    public String saved;

  
    public String exceeded;

    
 
    public String find;

   
    public String script;

  
    public String panic;

    
    public String quit;

  
    public String file;

  
    public String nme;

 
    public String noimg;

 
    public String load;


    public String hlp;

   
    public String save_prompt;

 
    public String save_prompt2;

 
    public String cache_amount;

   
    public String cache_added;

    public String filter;

    
    public String on_file;

   
    public String is_undone;

    public String cache_empty;

 
    public String cache_cleared;

    public String ug_line1;

    public String ug_line2;

   
    public String ug_line3;

  
    public String ug_line4;

  
    public String ug_line5;

  
    public String ug_line6;

   
    public String ug_line7;

  
    public String ug_line8;

  
    public String ug_line9;

   
    public String ug_line10;

   
    public String ug_line11;

   
    public String ug_line12;

   
    public String ug_line13;
    
   
    public Internationalisation(){
        
        SetupEnglishLanguage();
        
    }
  
    /**
     * set the resource bundle 
     */
    public void setResouceBundle() {
       this.r=ResourceBundle.getBundle("Internationalisation/bundle");
    }
    
    /**
     * set up Internationalisation
     */
    public void SetupInternationalisation() {
        
        welcome = r.getString("welcome");
        description = r.getString("description");
        help = r.getString("help");
        current = r.getString("current");
        filters = r.getString("filters");
        farewell = r.getString("farewell");
        unknown = r.getString("unknown");
        fotoshop = r.getString("fotoshop");
        explain = r.getString("explain");
        cannot = r.getString("cannot");
        cwd = r.getString("cwd");
        open = r.getString("open");
        loaded = r.getString("loaded");
        save = r.getString("save");
        saved = r.getString("saved");
        exceeded = r.getString("exceeded");
        find = r.getString("find");
        script = r.getString("script");
        panic = r.getString("panic");
        file = r.getString("file");
        nme = r.getString("nme");
        noimg = r.getString("noimg");
        load = r.getString("load");
        hlp = r.getString("hlp");
        quit = r.getString("quit");
        save_prompt = r.getString("save_prompt");
        save_prompt2 = r.getString("save_prompt2");
        cache_amount = r.getString("cache_amount");
        cache_added = r.getString("cache_added");
        filter = r.getString("filter");   
        on_file = r.getString("on_file");
        is_undone = r.getString("is_undone");
        cache_empty = r.getString("cache_empty");
        cache_cleared = r.getString("cache_cleared");
        ug_line1 = r.getString("ug_line1");
        ug_line2 = r.getString("ug_line2");
        ug_line3 = r.getString("ug_line3");
        ug_line4 = r.getString("ug_line4");
        ug_line5 = r.getString("ug_line5");
        ug_line6 = r.getString("ug_line6");
        ug_line7 = r.getString("ug_line7");
        ug_line8 = r.getString("ug_line8");
        ug_line9 = r.getString("ug_line9");
        ug_line10 = r.getString("ug_line10");
        ug_line11 = r.getString("ug_line11");
        ug_line12 = r.getString("ug_line12");
        ug_line13 = r.getString("ug_line13");
    }

    /**
     * SetupEnglishLanguage
     */
    public void SetupEnglishLanguage() {
    setResouceBundle();
    Locale.setDefault(Locale.UK);
    SetupInternationalisation();
    }
    
    /**
     *SetupITALIANLanguage
     */
    public void SetupITALIANLanguage() {
    setResouceBundle();    
    Locale.setDefault(Locale.ITALY);
    SetupInternationalisation();
    }
    
    /**
     *SetupCHINESELanguage
     */
    public void SetupCHINESELanguage() {
    setResouceBundle();    
    Locale.setDefault(Locale.CHINA);
    SetupInternationalisation();
    }
    
    /**
     *setLanguage
     */
    public void setLanguage() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please select your language : ");
        System.out.println("Option 1 : English : (Type 1)");
        System.out.println("Option 2 : Italian : (Type 2)");
        System.out.println("Option 3 : Chinese : (Type 3)");
            int option = 0 ;       
            boolean test = false ;
            while(test==false){
                if(myObj.hasNextInt()){
                    option = myObj.nextInt();
                        if(option == 1) {
                            SetupEnglishLanguage();
                            test = true;
                            return;
                        } else if(option == 2) {
                            SetupITALIANLanguage();
                            test = true;
                        } else if (option == 3) {
                            SetupCHINESELanguage();
                            test = true;
                        } else {
                            System.out.println("Please select a number : 1 ,2 ,3 ");
                            test = false;
                            //return;
                        }
                        
                    //fm.setsize(size);
                    test = true;
                    return;
                } else if(!myObj.hasNextInt()){
                    System.out.println("You didn't type an integer."+"\nPlease , type and integer value.");
                    myObj.next();
                }    
            }

    }

}

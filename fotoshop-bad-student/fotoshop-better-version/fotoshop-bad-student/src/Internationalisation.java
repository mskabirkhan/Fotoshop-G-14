
import java.util.Locale;
import java.util.ResourceBundle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sk16acp
 */
public class Internationalisation {
    String language = "en";
    String country = "UK";
    
    Locale l;
    ResourceBundle r;
    
    String welcome;
    String description;
    String help;
    String current;
    String filters;
    String farewell;
    String unknown;
    String fotoshop;
    String explain;
    String cannot;
    String cwd;
    String open;
    String loaded;
    String save;
    String saved;
    String exceeded;
    String find;
    String script;
    String panic;
    String quit;
    String file;
    String nme;
    String noimg;
    String load;
    String hlp;
    
    Internationalisation(){
        
    language = "en";
    country = "UK";
    
    l = new Locale(language,country);
    r = ResourceBundle.getBundle("Bundle_en_UK", l);
    
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
    quit = r.getString("quit");
    file = r.getString("file");
    nme = r.getString("nme");
    noimg = r.getString("noimg");
    load = r.getString("load");
    hlp = r.getString("hlp");
        
        
        
    }
}

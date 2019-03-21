
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
public class Internationalisation {
    
    
    String language = "en";
    String country = "UK";
    
    Locale l = new Locale(language,country);
    ResourceBundle r = ResourceBundle.getBundle("languages/bundle");
    
    String welcome = r.getString("welcome");
    String description = r.getString("description");
    String help = r.getString("help");
    String current = r.getString("current");
    String farewell = r.getString("farewell");
    String unknown = r.getString("unknown");
    String fotoshop = r.getString("fotoshop");
    String explain = r.getString("explain");
    String cannot = r.getString("cannot");
    String cwd = r.getString("cwd");
    String open = r.getString("open");
    String loaded = r.getString("loaded");
    String save = r.getString("save");
    String saved = r.getString("saved");
    String find = r.getString("find");
    String script = r.getString("script");
    String panic = r.getString("panic");
    String quit = r.getString("quit");
    String file = r.getString("file");
    String nme = r.getString("nme");
    String noimg = r.getString("noimg");
    String load = r.getString("load");
    String hlp = r.getString("hlp");
    String exceeded = r.getString("exceeded");
    String filters = r.getString("filters");
    
    
    Internationalisation(){}
}


import java.util.Locale;

/**
 * This is the main class for the Fotoshop application
 * 
 * @author Joseph Williams
 * @version 2018.12.12
 */
public class Main {
   public static void main(String[] args) {
       Locale.setDefault(Locale.CHINA);
        new Editor().edit();
    }
}

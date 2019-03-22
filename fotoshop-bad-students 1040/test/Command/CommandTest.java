/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Team
 */
public class CommandTest {
    
    public CommandTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of testallMethods method, of class Command.
     */
    @Test
    public void testallMethods() {
        System.out.println("Methods in Command words : ");
        
        Command instance = new Command("raspberry","strawberry","blueberry");
        Boolean expResult = true;
        Boolean expResult2 = true;
        Boolean expResult3 = false;
        Boolean result = instance.hasSecondWord();
        System.out.println(result);
        Boolean result2 = instance.hasThirdWord();
        System.out.println(result2);
        Boolean result3 = instance.isUnknown();
        System.out.println(result3);
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
    }

    /**
     * Test getCommandWord Method, of class Command.
     */
    @Test
    public void getCommandWord() {
        System.out.println("Get Command word Method : ");
        List<String> commandWords = new ArrayList<>();
        commandWords.add("raspberry");
        commandWords.add("strawberry");
        commandWords.add("blueberry");
        String expResult = "[Ljava.lang.String;@3f8f9dd6";
        Command instance = new Command("abc","def","blueberry");
        String result = instance.getCommandWord().toString() ;
        System.out.println(result);
        assertEquals(expResult, result);
        
    }
    
}

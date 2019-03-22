/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Editor;

import Command.Command;
import Image.ColorImage;
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
public class EditToolsTest {
    
    Editor edit;
    
    public EditToolsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        edit = new Editor();
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of save method, of class EditTools.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        Command command = null;
        EditTools instance = new EditTools();
        instance.save(command);
        boolean result = instance.isImage();
        boolean expresult = false ;
        assertEquals(expresult,result);
        
    }

    /**
     * Test of look method, of class EditTools.
     */
    @Test
    public void testLook() {
        System.out.println("look");
        Command command = null;
        EditTools instance = new EditTools();
        instance.look(command);
        boolean result = instance.isImage();
        boolean expresult = false ;
        assertEquals(expresult,result);
    }

    /**
     * Test of mono method, of class EditTools.
     */
    @Test
    public void testMono() {
        System.out.println("mono");
        Command command = null;
        EditTools instance = new EditTools();
        instance.mono(command);
        boolean result = instance.isImage();
        System.out.println(result);
        boolean expresult = false ;
        assertEquals(expresult,result);
        
    }

    /**
     * Test of rot90 method, of class EditTools.
     */
    @Test
    public void testRot90() {
        System.out.println("rot90");
        Command command = null;
        EditTools instance = new EditTools();
        instance.rot90(command);
        boolean result = instance.isImage();
        System.out.println(result);
        boolean expresult = false ;
        assertEquals(expresult,result);
    }

    /**
     * Test of fliph method, of class EditTools.
     */
    @Test
    public void testFliph() {
        System.out.println("fliph");
        Command command = null;
        EditTools instance = new EditTools();
        instance.fliph(command);
        boolean result = instance.isImage();
        System.out.println(result);
        boolean expresult = false ;
        assertEquals(expresult,result);
    }

    /**
     * Test of isImage method, of class EditTools.
     */
    @Test
    public void testIsImage() {
        System.out.println("isImage");
        EditTools instance = new EditTools();
        boolean expResult = false;
        boolean result = instance.isImage();
        assertEquals(expResult, result);
        instance.setImage(instance.loadImage("input.jpg"));
        boolean expresult2 = true ;
        boolean result2 = instance.isImage();
        assertEquals(expresult2, result2);
    }
    
    @Test
    public void testLoadImage() {
        System.out.println("loadImage");
        String name = "input.jpg";
        EditTools edit = new EditTools();
        ColorImage image = edit.loadImage(name);
        edit.setImage(image);
        edit.setName(name);
        ColorImage result = image;
        String result2 = edit.getName();
        System.out.println(result2);
        assertTrue("An image exists", result != null);
        assertTrue("Image name fits", result2 == name);
    }
    
}

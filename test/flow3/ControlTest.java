package flow3;


import java.io.*;
import java.nio.file.*;
import java.util.UUID;
import java.util.logging.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author lam
 * 10-10-2012 hau: 
 * Direct file manipulation removed (the test should not require more than is 
 * expressed in the interface  - ex: a specific file format)
 * Use of special danish characters omitted
 * Added negative tests
 * 9-10-2013 hau: 
 * automatic filename generation deleted (filename is not part of interface)
 */
public class ControlTest
{  
  QuizzControlIF control;

  public ControlTest()
  {
  }   

  // <editor-fold defaultstate="collapsed" desc=" Setup/teardown ">
  @Before
  public void setUp()
  {
    //==>  Replace ControlDemoAdapt() with your Controller =========
    control = new Control(); 
    control.addGame("Test");
    control.selectGame("Test");
    assertTrue(control.size()== 0);
    control.add("hest", "horse");      // trust add()
    control.add("hus", "house");
    control.add("skib", "ship");
    
  }
  
  @After
  public void tearDown()
  {
  }

// </editor-fold>
  
  @Test
  /**
   * This test requires that both save and load are implemented, since the test strategy is:
   * Save the file, clear the content of the list, and read the file back in and check
   * the result.
   */
  public void testLoad()
  {
    assertTrue(control.save()); 
    control.clear();                       
    assertTrue(control.load());
    control.selectGame("Test");
    assertTrue(control.size() == 3);
    assertEquals(control.lookup("hest"),"horse");
    assertEquals(control.lookup("hus"), "house");
    assertEquals(control.lookup("skib"),"ship");
  }
  
  
  
  @Test
  /**
   * This test is redundant (covered by testLoad).
   */
  public void testSave()
  {
    
  }
  
  @Test
  public void testLookup()
  {
    assertEquals(control.lookup("hest"), "horse");
    assertNotSame(control.lookup("hest"), "Cow");
  }

  @Test
  public void testClear()
  {
    control.clear();
      System.out.println(control.size());
    assertTrue(control.size() == 0);
  }

  @Test
  public void testAdd()
  {
    control.add("ko", "cow");
    assertTrue(control.size() == 4);
    assertEquals(control.lookup("ko"),"cow");
  }

  @Test
  /**
   * This does not test the distribution, but if we belive in the random generators
   * it tests the "border values" in that all possible values must be generated
   */
  public void testGetRandomQuestion()
  {
    int testTries = 30;
    boolean horseFound = false;
    boolean houseFound = false;
    boolean boatFound  = false;

    for (int i = 0; i < testTries; i++) {
      String question = control.getRandomQuestion();
      if (question.equals("hest")) {
        horseFound = true;
      }
      if (question.equals("hus")) {
        houseFound = true;
      }
      if (question.equals("skib")) {
        boatFound = true;
      }
    }
    assertTrue(horseFound && houseFound && boatFound);
  }

  @Test
  public void testCheckGuess()
  {
    assertTrue(control.checkGuess("hest", "horse"));
    assertFalse(control.checkGuess("hest","cow"));
  }

  @Test
  public void testGetSize()
  {
    assertTrue(control.size() == 3);
  }

    @Test
    public void testDelete()
    {
        assertTrue(control.lookup("hest").equals("horse"));
        assertTrue(control.delete("hest"));
        assertTrue(control.lookup("hest") == null);
    }

    @Test
    public void testSize()
    {
        assertTrue(control.size() == 3);
    }

    @Test
    public void testGetGameNames()
    {
        assertTrue(control.getGameNames().length == 1);
        assertTrue(control.getGameNames()[0].equals("Test"));
        
        
    }

    @Test
    public void testSelectGame()
    {
        
        control.selectGame(null);
        assertTrue(control.getSelectedGameName() == null);
        control.selectGame("Test");
        assertTrue(control.getSelectedGameName().equalsIgnoreCase("Test"));
        
    }

    @Test
    public void testGetSelectedGameName()
    {control.selectGame("Test");
    assertTrue(control.getSelectedGameName().equalsIgnoreCase("Test"));
    }

    @Test
    public void testAddGame()
    {
        control.selectGame("Test1");
        assertTrue(control.getSelectedGameName() == null);
        control.addGame("Test1");
        control.selectGame("Test1");
        assertTrue(control.getSelectedGameName().equals("Test1"));
    }
}

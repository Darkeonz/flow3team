package flow3;

//Herunder ses de klasser vi har importeret fra Java-biblioteket:
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Flow 3 - "Team"
 * Udarbejdet af:
 * Andreas og Emil
 * 
 */

//Denne klasse indeholder metoder til at skrive i tekstfiler.
public class WriteFile
{
    //Herunder ses konstruktøren "WriteFile":
    public WriteFile()
    {
        
    }

    public boolean saveFile(ArrayList<Game> liste)
    { 
        PrintWriter pw;
        
        try
        {
            pw = new PrintWriter("words.txt");
            
            for (int i = 0; i < liste.size(); i++)
            {
                pw.println(liste.get(i).toSaveString());
                System.out.println(liste.get(i).toSaveString());
            }
            
            pw.close(); 
        }
        
        catch (FileNotFoundException ex)
        {
            System.out.println("Fejl: " + ex.getMessage());
        return false;
        }
    return true;}
    
}
    
    
    

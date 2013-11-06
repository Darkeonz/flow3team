package flow3;

//Herunder ses de klasser vi har importeret fra Java-biblioteket:
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Flow 3 - "Team" Udarbejdet af: Andreas og Emil
 *
 */
//Denne klasse indeholder metoder til at læse i tekstfiler.
public class ReadFile {

    public boolean getTxt(ArrayList<Word> personlist) {
        //Herunder ses referencen til den textfil, der indeholder vores ord-data:
        String fileName = "words.txt";

        //Dette vil læse én linie ad gangen:
        String line = null;

        try {
            //FileReader læser tekstfiler i standard encoding.
            FileReader fileReader = new FileReader(fileName);

            //Læser tekst fra en karakter-input stream, buffer tegn, så som at sørge for effektiv læsning af tegn, arrays og linjer.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] part = line.split(",");
                String danname = part[0];
                String engname = (part[1]);

                Word p = new Word(danname, engname);
                personlist.add(p);
            }

            // Lukker filen.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");
            return false;
        } catch (IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");
            return false;
        }
        return true;

    }
}

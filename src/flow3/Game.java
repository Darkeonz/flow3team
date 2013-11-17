/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flow3;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Darkeonz
 */
public class Game {

    private ArrayList<Question> questions = new ArrayList<>();
    private String name;

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Henter et tilfældigt spørgsmål
     * @return 
     */
    public Question getRandomQuestion() {

        // Er der nogen spørgsmål?
        if (questions.isEmpty())
        {
            return null;
        }
        
        // Hent tilfældigt spørgsmål
        Random random = new Random();
        int nummer = random.nextInt(questions.size());
        return questions.get(nummer);
    }
    
    /**
     * Skriver game til streng incl. spørgsmål
     * @return 
     */
    public String toSaveString()
    {
        String resultat = name + "\n";
        
        for (int i = 0; i < questions.size(); i++)
        {
            resultat += questions.get(i).toSaveString() + "\n";
        }
        
        return resultat;
    }
}

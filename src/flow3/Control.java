/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flow3;

import java.util.ArrayList;


/**
 *
 * @author Andreas
 */
public class Control implements QuizzControlIF {

    private WriteFile writefile;
    private ReadFile readfile;
    private ArrayList<Game> games = new ArrayList<>();
    private Game currentgame = null;

    public Control() {
        writefile = new WriteFile();
        readfile = new ReadFile();
    }

    /**
     * 
     * @param question
     * @param answer 
     */
    @Override
    public void add(String question, String answer) {
        
        // Man skal have valgt et spil for at kunne tilføje et spørgsmål
        if (currentgame == null)
        {
            return;
        }
        
        if (lookup(question) == null) {
            currentgame.getQuestions().add(new Question(question, answer));
        }
    }

    @Override
    public boolean delete(String question) {
        
        // Man skal have valgt et spil for at kunne tilføje et spørgsmål
        if (currentgame == null)
        {
            return false;
        }
        
        for (int i = 0; i < currentgame.getQuestions().size(); i++) {
            if (question.equals(currentgame.getQuestions().get(i).getQuestion())) {

                currentgame.getQuestions().remove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public int size() {
        if (currentgame == null) 
        {
            return 0;
        }
        int size = currentgame.getQuestions().size();
        return size;
    }

    @Override
    public String getRandomQuestion() {

        // Man skal have valgt et spil for at kunne tilføje et spørgsmål
        if (currentgame == null)
        {
            return null;
        }
        
        return currentgame.getRandomQuestion().getQuestion();
    }

    @Override
    public boolean checkGuess(String question, String answer) {
           if (currentgame == null)
        {
            return false;
        }
        for (int i = 0; i < currentgame.getQuestions().size(); i++) {
            if (currentgame.getQuestions().get(i).getQuestion().equalsIgnoreCase(question) && currentgame.getQuestions().get(i).getAnswer().equalsIgnoreCase(answer)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public String lookup(String question) {
        // Tjek om der er valgt et spil
        if (currentgame == null) {
            return null;
        }

        // Find spørgsmål
        for (int i = 0; i < currentgame.getQuestions().size(); i++) {
            if (currentgame.getQuestions().get(i).getQuestion().equals(question)) {
                String english = currentgame.getQuestions().get(i).getAnswer();
                return english;
            }
        }
        return null;
    }

    @Override
    public boolean load() {

        return readfile.getTxt(games);
    }

    @Override
    public boolean save() {
        return writefile.saveFile(games);
    }

    @Override
    public void clear() {
        for (int i = 0; i < games.size(); i++) {
            games.clear();
        }
           currentgame = null;
    }

    @Override
    public String[] getGameNames() {
        readfile.getTxt(games);

        String[] resultat = new String[games.size()];

        for (int i = 0; i < games.size(); i++) {
            resultat[i] = games.get(i).getName();
        }

        return resultat;
    }

    @Override
    public void selectGame(String gameName) {
        currentgame = null;
        // Find spil
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getName().equals(gameName)) {
                // Vi har fundet spillet
                currentgame = games.get(i);
            }
        }

    }

    @Override
    public String getSelectedGameName() {
        if (currentgame == null) {
            return null;
        }
        return currentgame.getName();
    }

    @Override
    public boolean addGame(String name) {

        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getName() == name) {

                return false;
            }

        }

        Game game1 = new Game();
        game1.setName(name);
        games.add(game1);

        return true;


    }
}


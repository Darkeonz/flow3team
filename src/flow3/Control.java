/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flow3;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Andreas
 */
public class Control implements QuizzControlIF
{

    private WriteFile writefile;
    private ReadFile readfile;
    private ArrayList<Word> words = new ArrayList<>();

    public Control()
    {
        writefile = new WriteFile();
        readfile = new ReadFile();
    }

    @Override
    public void add(String question, String answer)
    {

        if (lookup(question) == null)
        {
            words.add(new Word(question, answer));
        }
    }

    @Override
    public boolean delete(String question)
    {
        for (int i = 0; i < words.size(); i++)
        {
            if (question.equals(words.get(i).getDanword()) == true || question.equals(words.get(i).getEngword()) == true)
            {

                words.remove(i);
                return true;


            }
        }


        return false;
    }

    @Override
    public int size()
    {
        int size = words.size();
        return size;
    }

    @Override
    public String getRandomQuestion()
    {
        if (words.isEmpty())
        {
        return null;
        }
        else {Random random = new Random();
        int nummer = random.nextInt(size());
        return words.get(nummer).getDanword();}

    }

    @Override
    public boolean checkGuess(String question, String answer)
    {
        for (int i = 0; i < words.size(); i++)
        {
            if (words.get(i).getDanword().equalsIgnoreCase(question) && words.get(i).getEngword().equalsIgnoreCase(answer))
            {
                return true;
            }

        }
        return false;
    }

    @Override
    public String lookup(String question)
    {
        for (int i = 0; i < words.size(); i++)
        {
            if (words.get(i).getDanword().equals(question))
            {
                String english = words.get(i).getEngword();
                return english;
            }
        }
        return null;
    }

    @Override
    public boolean load()
    {

        return readfile.getTxt(words);
    }

    @Override
    public boolean save()
    {
        return writefile.saveFile(words);
    }

    @Override
    public void clear()
    {
        for (int i = 0; i < words.size(); i++)
        {
            words.clear();
        }
    }

    @Override
    public String[] getGameNames()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void selectGame(String gameName)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSelectedGameName()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addGame(String name)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

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
    private ArrayList<Category> categories = new ArrayList<>();
    private Category currentCategory = null;

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
            categories.add(new Question(question, answer));
        }
    }

    @Override
    public boolean delete(String question)
    {
        for (int i = 0; i < categories.size(); i++)
        {
            if (question.equals(categories.get(i).getDanword()) == true || question.equals(categories.get(i).getEngword()) == true)
            {

                categories.remove(i);
                return true;


            }
        }


        return false;
    }

    @Override
    public int size()
    {
        int size = categories.size();
        return size;
    }

    @Override
    public String getRandomQuestion()
    {
        if (categories.isEmpty())
        {
        return null;
        }
        else {Random random = new Random();
        int nummer = random.nextInt(size());
        return categories.get(nummer).getDanword();}

    }

    @Override
    public boolean checkGuess(String question, String answer)
    {
        for (int i = 0; i < categories.size(); i++)
        {
            if (categories.get(i).getDanword().equalsIgnoreCase(question) && categories.get(i).getEngword().equalsIgnoreCase(answer))
            {
                return true;
            }

        }
        return false;
    }

    @Override
    public String lookup(String question)
    {
        for (int i = 0; i < categories.size(); i++)
        {
            if (categories.get(i).getDanword().equals(question))
            {
                String english = categories.get(i).getEngword();
                return english;
            }
        }
        return null;
    }

    @Override
    public boolean load()
    {

        return readfile.getTxt(categories);
    }

    @Override
    public boolean save()
    {
        return writefile.saveFile(categories);
    }

    @Override
    public void clear()
    {
        for (int i = 0; i < categories.size(); i++)
        {
            categories.clear();
        }
    }

    @Override
    public String[] getGameNames()
    {
        readfile.getTxt(categories);
        
        String[] resultat = new String[categories.size()];
        
        for (int i = 0; i < categories.size(); i++)
        {
            resultat[i] = categories.get(i).getName();
        }
        
        return resultat;
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

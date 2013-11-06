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
public class Control implements WordPairControlIF
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
    public void add(String danish, String english)
    {

        if (lookup(danish) == null)
        {
            words.add(new Word(danish, english));
        }
    }

    @Override
    public boolean delete(String danish)
    {
        for (int i = 0; i < words.size(); i++)
        {
            if (danish.equals(words.get(i).getDanword()) == true || danish.equals(words.get(i).getEngword()) == true)
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
    public boolean checkGuess(String danish, String english)
    {
        for (int i = 0; i < words.size(); i++)
        {
            if (words.get(i).getDanword().equals(danish) && words.get(i).getEngword().equals(english))
            {
                return true;
            }

        }
        return false;
    }

    @Override
    public String lookup(String danish)
    {
        for (int i = 0; i < words.size(); i++)
        {
            if (words.get(i).getDanword().equals(danish))
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
//
//    public void setWritefile(WriteFile writefile)
//    {
//        writefile.saveFile(words);
//        this.writefile = writefile;
//    }
//
//    public ReadFile getReadfile()
//    {
//        readfile = rf.getTxt();
//        return readfile;
//    }
//
//    public WriteFile getWritefile()
//    {
//        
//        return writefile;
//    }
//
//    public void addWords(String danish, String english)
//    {
//        Word p = new Word(danish, english);
//        words.add(p);
//    }
}

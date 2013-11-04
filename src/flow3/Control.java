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
public class Control
{

    private WriteFile writefile;
    private ReadFile readfile;
    private ArrayList<Word> words = new ArrayList<>();
    WriteFile wf = new WriteFile();
    ReadFile rf = new ReadFile();

    public void setWritefile(WriteFile writefile)
    {
        writefile.saveFile(words);
        this.writefile = writefile;
    }

    public ReadFile getReadfile()
    {
        readfile = rf.getTxt();
        return readfile;
    }

    public WriteFile getWritefile()
    {
        
        return writefile;
    }

    public void addWords(String danish, String english)
    {
        Word p = new Word(danish, english);
        words.add(p);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flow3;

/**
 *
 * @author Andreas & Emil
 */
public class Word
{
    //Herunder attributterne:

    private String danword;
    private String engword;

    public Word(String danishword, String englishword)
    {
        this.danword = danishword;
        this.engword = englishword;

    }

    public String getDanword()
    {
        return danword;
    }

    public void setDanword(String danword)
    {
        this.danword = danword;
    }

    public String getEngword()
    {
        return engword;
    }

    public void setEngword(String engword)
    {
        this.engword = engword;
    }

    public String toSaveString()
    {
        return danword + "," + engword;
    }
}

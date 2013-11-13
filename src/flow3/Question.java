/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flow3;

/**
 *
 * @author Andreas & Emil
 */
public class Question
{
    //Herunder attributterne:

    private String question;
    private String answer;


    public Question(String question, String answer)
    {
        this.question = question;
        this.answer = answer;
        
    }

    public String getDanword()
    {
        return question;
    }

    public void setDanword(String danword)
    {
        this.question = danword;
    }

    public String getEngword()
    {
        return answer;
    }

    public void setEngword(String engword)
    {
        this.answer = engword;
    }

    public String toSaveString()
    {
        return question + "," + answer;
    }
}

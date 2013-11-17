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

    public String getQuestion()
    {
        return question;
    }
 
    public void setQuestion(String question)
    {
        this.question = question;
    }

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

    public String toSaveString()
    {
        return question + "," + answer;
    }
}

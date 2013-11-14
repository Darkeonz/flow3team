/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flow3;

import java.util.ArrayList;

/**
 *
 * @author Darkeonz
 */
public class Category
{

    private ArrayList<Question> questions = new ArrayList<>();
    private String name;
    private String question;
    private String answer;

    public Category(String question, String answer)
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

    public ArrayList<Question> getQuestions()
    {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions)
    {
        this.questions = questions;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String toSaveString()
    {
        return question + "," + answer;
    }
}

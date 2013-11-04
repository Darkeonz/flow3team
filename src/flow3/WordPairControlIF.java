/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package flow3;

//**
// *
// * @author Andreas

    
    public interface WordPairControlIF {

    /** 
     * Post: A new word pair is added to the existing collection of word
     * pairs
     */
    void add(String question, String answer);

    /**  
     * Post: A word pair corresponding to the question is removed from the collection.
     * Returns true if a word pair is removed. Otherwise false.
     */
    boolean delete(String question);

    /**
     * Returns the number of wordpairs
     */
    int size();

    /**
     * Pre: At least one word pair must be present
     * Returns a question randomly selected from the collection of word pairs
     */
    String getRandomQuestion();

    /** 
     * Returns true if (question, quess) exists as a word pair in the
     * collection, otherwise false
     */
    boolean checkGuess(String question, String quess);

    /**
     * Returns the answer corresponding to the question if this
     * exists in the collection. Otherwise it returns null.
     */
    String lookup(String question);

    /** 
     * Post: Word pairs are read from file and added to the
     * collection of word pairs. 
     * Returns true if successfully done. Otherwise false.
     */
    boolean load();

    /**
     * Post: All word pairs from the collection has been written to file
     * Returns true if successfully done. Otherwise false.
     */
    boolean save();

    /**
     * Post: The existing collection of word pairs is cleared
     */
    void clear();
}
    


package it.unibo.mvc;

import java.util.List;

/**
 * an interface which models a controller responsible for I/O access.
 */
public interface Controller {
    /**
     * sets the next string to be printed.
     * 
     * @param s the next string to be set
     */
    void setNextString(String s);

    /**
     * provides the next string to be printed.
     * 
     * @return the next string to be printed
     */

    String getNextString();

    /**
     * provides the whole history of printed strings.
     * 
     * @return a List of Strings containing the String history
     */

    List<String> getHistory();

    /**
     * shows the string to be printed on standard output.
     */

    void printString();

}

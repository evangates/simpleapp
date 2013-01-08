package com.baesystems.cmo.simpleapp;

/**
 * Exception thrown when an illegal guess is made, such as not having
 * the correct number of characters or non-digit characters.
 * 
 * @author evan.gates
 */
public class IllegalGuessException extends Exception {

  /**
   * Creates a new instance of
   * <code>IllegalGuessException</code> without detail message.
   */
  public IllegalGuessException() {
  }

  /**
   * Constructs an instance of
   * <code>IllegalGuessException</code> with the specified detail message.
   *
   * @param msg the detail message.
   */
  public IllegalGuessException(String msg) {
    super(msg);
  }

}

package com.baesystems.cmo.simpleapp;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author evan.gates
 */
public class Game {
  
  private String secret;
  
  private SecretGenerator secretGenerator;
  
  public void generateSecret() {
    secret = secretGenerator.generate();
    System.out.println(String.format("Secret is %s", secret));
  }
  
  public GuessResult guess(String guess) throws IllegalGuessException {
    if (!guess.matches(Constants.GUESS_REGEX)) {
      throw new IllegalGuessException(Constants.INVALID_CHARACTERS_MESSAGE);
    }
    
    List<Character> guessChars = new LinkedList<Character>();
    addAllChars(guessChars, guess);
    List<Character> secretChars = new LinkedList<Character>();
    addAllChars(secretChars, secret);
    
    int numExactMatches = 0;
    int numWrongPositionMatches = 0;
    
    // check for exact matches first
    for (int i = 0; i < guessChars.size(); ++i) {
      if (guessChars.get(i) == secretChars.get(i)) {
        numExactMatches++;
        
        // make sure we don't match this secret character again
        secretChars.set(i, Constants.NON_MATCHING_CHARACTER);
        
        // mark guess character as matched
        guessChars.set(i, Constants.NON_MATCHING_CHARACTER);
      }
    }
    
    // check for wrong position matches
    for (int i = 0; i < guessChars.size(); ++i) {
      // already matched move on
      if (guessChars.get(i) == Constants.NON_MATCHING_CHARACTER) {
        continue;
      }
      
      for (int j = 0; j < secretChars.size(); ++j) {
        if (guessChars.get(i) == secretChars.get(j)) {
          numWrongPositionMatches++;
          
          // make sure we don't match this secret character again
          secretChars.set(j, Constants.NON_MATCHING_CHARACTER);
          
          // go to next input character
          break;
        }
      }
    }
    
    return new GuessResult(numExactMatches, numWrongPositionMatches);
  }
  
  public void setSecretGenerator(SecretGenerator secretGenerator) {
    if (secretGenerator == null) {
      throw new IllegalArgumentException("secretGenerator cannot be null");
    }
    this.secretGenerator = secretGenerator;
  }
  
  private void addAllChars(Collection<Character> collection, String str) {
    for (char c : str.toCharArray()) {
      collection.add(c);
    }
  }
    
  public static final class GuessResult {
    private final int numExactMatches;
    private final int numWrongPositionMatches;
    
    public GuessResult(int numExactMatches, int numWrongPositionMatches) {
      this.numExactMatches = numExactMatches;
      this.numWrongPositionMatches = numWrongPositionMatches;
    }

    public int getNumExactMatches() {
      return numExactMatches;
    }

    public int getNumWrongPositionMatches() {
      return numWrongPositionMatches;
    }
  }
  
}

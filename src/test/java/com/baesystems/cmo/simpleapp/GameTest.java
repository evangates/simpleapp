/*
 * Copyright 2012
 * Evan Gates
 * http://www.thoughtmerge.net
 */

package com.baesystems.cmo.simpleapp;

import com.baesystems.cmo.simpleapp.Game.GuessResult;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import static org.fest.assertions.Assertions.assertThat;

/**
 *
 * @author evan.gates
 */
public class GameTest {
  
  private Game game;
  
  private SecretGenerator secretGenerator;
  
  @Before
  public void setup() {
    secretGenerator = EasyMock.createStrictMock(SecretGenerator.class);
    
    game = new Game();
    game.setSecretGenerator(secretGenerator);
  }

  @Test
  public void guess_withNoMatches_returnsResultWithNoMatches() throws Exception {
    // arrange
    final String secret = "12345";
    final String guess  = "00000";
    final int expectedExactMatches = 0;
    final int expectedWrongPositionMatches = 0;
    
    EasyMock.expect(secretGenerator.generate()).andReturn(secret);
    
    EasyMock.replay(secretGenerator);
    
    game.generateSecret();
    
    // act
    GuessResult result = game.guess(guess);
    
    // assert
    assertThat(result.getNumExactMatches()).isEqualTo(expectedExactMatches);
    assertThat(result.getNumWrongPositionMatches()).isEqualTo(expectedWrongPositionMatches);
  }
  
  @Test
  public void guess_withCompleteMatch_returnsCorrectResult() throws Exception {
    // arrange
    final String secret = "12345";
    final String guess  = secret;
    final int expectedExactMatches = secret.length();
    final int expectedWrongPositionMatches = 0;
    
    EasyMock.expect(secretGenerator.generate()).andReturn(secret);
    
    EasyMock.replay(secretGenerator);
    
    game.generateSecret();
    
    // act
    GuessResult result = game.guess(guess);
    
    // assert
    assertThat(result.getNumExactMatches()).isEqualTo(expectedExactMatches);
    assertThat(result.getNumWrongPositionMatches()).isEqualTo(expectedWrongPositionMatches);
  }
  
  @Test
  public void guess_with1ExactMatchAtStart_returnsExpectedResult() throws Exception {
    // arrange
    final String secret = "12345";
    final String guess  = "10000";
    final int expectedExactMatches = 1;
    final int expectedWrongPositionMatches = 0;
    
    EasyMock.expect(secretGenerator.generate()).andReturn(secret);
    
    EasyMock.replay(secretGenerator);
    
    game.generateSecret();
    
    // act
    GuessResult result = game.guess(guess);
    
    // assert
    assertThat(result.getNumExactMatches()).isEqualTo(expectedExactMatches);
    assertThat(result.getNumWrongPositionMatches()).isEqualTo(expectedWrongPositionMatches);
  }
  
  @Test
  public void guess_with1ExactMatchInMiddle_returnsExpectedResult() throws Exception {
    // arrange
    final String secret = "12345";
    final String guess  = "00300";
    final int expectedExactMatches = 1;
    final int expectedWrongPositionMatches = 0;
    
    EasyMock.expect(secretGenerator.generate()).andReturn(secret);
    
    EasyMock.replay(secretGenerator);
    
    game.generateSecret();
    
    // act
    GuessResult result = game.guess(guess);
    
    // assert
    assertThat(result.getNumExactMatches()).isEqualTo(expectedExactMatches);
    assertThat(result.getNumWrongPositionMatches()).isEqualTo(expectedWrongPositionMatches);
  }
  
  @Test
  public void guess_with1ExactMatchAtEnd_returnsExpectedResult() throws Exception {
    // arrange
    final String secret = "12345";
    final String guess  = "00005";
    final int expectedExactMatches = 1;
    final int expectedWrongPositionMatches = 0;
    
    EasyMock.expect(secretGenerator.generate()).andReturn(secret);
    
    EasyMock.replay(secretGenerator);
    
    game.generateSecret();
    
    // act
    GuessResult result = game.guess(guess);
    
    // assert
    assertThat(result.getNumExactMatches()).isEqualTo(expectedExactMatches);
    assertThat(result.getNumWrongPositionMatches()).isEqualTo(expectedWrongPositionMatches);
  }
  
  @Test
  public void guess_withMultipleExactMatchesInMiddle_returnsExpectedResult() throws Exception {
    // arrange
    final String secret = "12345";
    final String guess  = "10305";
    final int expectedExactMatches = 3;
    final int expectedWrongPositionMatches = 0;
    
    EasyMock.expect(secretGenerator.generate()).andReturn(secret);
    
    EasyMock.replay(secretGenerator);
    
    game.generateSecret();
    
    // act
    GuessResult result = game.guess(guess);
    
    // assert
    assertThat(result.getNumExactMatches()).isEqualTo(expectedExactMatches);
    assertThat(result.getNumWrongPositionMatches()).isEqualTo(expectedWrongPositionMatches);
  }
  
  @Test
  public void guess_with1WrongPositionMatch_returnsExpectedResult() throws Exception {
    // arrange
    final String secret = "12345";
    final String guess  = "00100";
    final int expectedExactMatches = 0;
    final int expectedWrongPositionMatches = 1;
    
    EasyMock.expect(secretGenerator.generate()).andReturn(secret);
    
    EasyMock.replay(secretGenerator);
    
    game.generateSecret();
    
    // act
    GuessResult result = game.guess(guess);
    
    // assert
    assertThat(result.getNumExactMatches()).isEqualTo(expectedExactMatches);
    assertThat(result.getNumWrongPositionMatches()).isEqualTo(expectedWrongPositionMatches);
  }
  
  @Test
  public void guess_withMultipleWrongPositionMatches_returnsExpectedResult() throws Exception {
    // arrange
    final String secret = "12345";
    final String guess  = "51432";
    final int expectedExactMatches = 0;
    final int expectedWrongPositionMatches = 5;
    
    EasyMock.expect(secretGenerator.generate()).andReturn(secret);
    
    EasyMock.replay(secretGenerator);
    
    game.generateSecret();
    
    // act
    GuessResult result = game.guess(guess);
    
    // assert
    assertThat(result.getNumExactMatches()).isEqualTo(expectedExactMatches);
    assertThat(result.getNumWrongPositionMatches()).isEqualTo(expectedWrongPositionMatches);
  }

  @Test
  public void guess_with1ExactMatchAnd1WrongPositionMatches_returnsExpectedResult() throws Exception {
    // arrange
    final String secret = "12345";
    final String guess  = "02030";
    final int expectedExactMatches = 1;
    final int expectedWrongPositionMatches = 1;
    
    EasyMock.expect(secretGenerator.generate()).andReturn(secret);
    
    EasyMock.replay(secretGenerator);
    
    game.generateSecret();
    
    // act
    GuessResult result = game.guess(guess);
    
    // assert
    assertThat(result.getNumExactMatches()).isEqualTo(expectedExactMatches);
    assertThat(result.getNumWrongPositionMatches()).isEqualTo(expectedWrongPositionMatches);
  }
  
  @Test
  public void guess_withMultipleExactMatchesAndMultipleWrongPositionMatches_returnsExpectedResult() throws Exception {
    // arrange
    final String secret = "12345";
    final String guess  = "12530";
    final int expectedExactMatches = 2;
    final int expectedWrongPositionMatches = 2;
    
    EasyMock.expect(secretGenerator.generate()).andReturn(secret);
    
    EasyMock.replay(secretGenerator);
    
    game.generateSecret();
    
    // act
    GuessResult result = game.guess(guess);
    
    // assert
    assertThat(result.getNumExactMatches()).isEqualTo(expectedExactMatches);
    assertThat(result.getNumWrongPositionMatches()).isEqualTo(expectedWrongPositionMatches);
  }
  
  @Test
  public void guess_withDuplicateDigitsInSecretAndGuess_returnsExpectedResult() throws Exception {
    // arrange
    final String secret = "08080";
    final String guess  = "11080";
    final int expectedExactMatches = 3;
    final int expectedWrongPositionMatches = 0;
    
    EasyMock.expect(secretGenerator.generate()).andReturn(secret);
    
    EasyMock.replay(secretGenerator);
    
    game.generateSecret();
    
    // act
    GuessResult result = game.guess(guess);
    
    // assert
    assertThat(result.getNumExactMatches()).isEqualTo(expectedExactMatches);
    assertThat(result.getNumWrongPositionMatches()).isEqualTo(expectedWrongPositionMatches);
  }
  
  @Test
  public void guess_withDuplicateDigitsInSecretAndGuess2_returnsExpectedResult() throws Exception {
    // arrange
    final String secret = "08080";
    final String guess  = "80880";
    final int expectedExactMatches = 2;
    final int expectedWrongPositionMatches = 2;
    
    EasyMock.expect(secretGenerator.generate()).andReturn(secret);
    
    EasyMock.replay(secretGenerator);
    
    game.generateSecret();
    
    // act
    GuessResult result = game.guess(guess);
    
    // assert
    assertThat(result.getNumExactMatches()).isEqualTo(expectedExactMatches);
    assertThat(result.getNumWrongPositionMatches()).isEqualTo(expectedWrongPositionMatches);
  }
}
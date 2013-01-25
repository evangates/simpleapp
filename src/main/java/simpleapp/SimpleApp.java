package simpleapp;

import simpleapp.Game.GuessResult;
import java.util.Scanner;

public class SimpleApp {
  
  /**
   * For handling input
   */
  private static Scanner scanner;
  
  /**
   * The game.
   */
  private static Game game;

  public static void main(String[] args) {
    init();
    
    welcome();
    
    boolean exit = false;
    do {
      prompt();
      
      String input = getInput();
      
      if (Constants.EXIT_COMMAND.equals(input)) {
        exit = true;
        continue;
      }
      
      try {
        GuessResult guessResult = game.guess(input);
        
        if (guessResult.getNumExactMatches() == Constants.NUM_DIGITS) {
          System.out.println(Constants.WIN_MESSAGE);
          System.out.println(Constants.STARTING_NEW_GAME_MESSAGE);
          game.generateSecret();
        }
        else {
          System.out.println(String.format(Constants.GUESS_MESSAGE_D_D, guessResult.getNumExactMatches(), guessResult.getNumWrongPositionMatches()));
        }
      }
      catch (IllegalGuessException ex) {
        System.out.println(ex.getMessage());
      }      
    } while(exit == false);
  }
  
  private static void init() {
    game = new Game();
    game.setSecretGenerator(new SecretGenerator());
    
    game.generateSecret();
    
    scanner = new Scanner(System.in);
  }
  
  private static void welcome() {
    System.out.println(Constants.WELCOME_MESSAGE);
    System.out.println(String.format(Constants.INSTRUCTIONS));
  }
  
  private static String getInput() {
    return scanner.nextLine().trim();
  }
  
  private static void prompt() {
    System.out.print(Constants.PROMPT);
  }

}

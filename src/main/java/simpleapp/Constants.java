package simpleapp;

/**
 *
 * @author evan.gates
 */
public class Constants {
  public final static int NUM_DIGITS = 5;
  
  public final static String WELCOME_MESSAGE = "Welcome to Simple App!";
  public final static String WIN_MESSAGE = String.format("%nCongrats!  That's correct!%n");
  public final static String GUESS_MESSAGE_D_D = "%d exact matches, %d correct digits in the wrong position.";
  public final static String STARTING_NEW_GAME_MESSAGE = "Creating a new secret number and starting a new game.";
  
  public final static String INSTRUCTIONS = String.format("INSTRUCTIONS:%nTry to guess the randomly selected %d digit number string.%nIt may have leading zeroes.%nType 'exit' to stop playing.", NUM_DIGITS);
  public final static String PROMPT = "Type your guess and press Enter: ";
  
  public final static String EXIT_COMMAND = "exit";
  
  public final static char NON_MATCHING_CHARACTER = '$';
  
  public final static String GUESS_REGEX = String.format("[0-9]{%d}", NUM_DIGITS);

  public final static String INVALID_CHARACTERS_MESSAGE = String.format("Must be a string of %d digits.", NUM_DIGITS);
}

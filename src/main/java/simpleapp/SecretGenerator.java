package simpleapp;

import java.util.Random;

/**
 *
 * @author evan.gates
 */
public class SecretGenerator {
  
  private final Random random;
  
  public SecretGenerator() {
    this(System.currentTimeMillis());
  }
  
  public SecretGenerator(long seed) {
    random = new Random(seed);
  }
  
  public String generate() {
    int number = random.nextInt((int)Math.pow(10, Constants.NUM_DIGITS));
    
    return String.format(String.format("%%0%dd", Constants.NUM_DIGITS), number);
  }
}

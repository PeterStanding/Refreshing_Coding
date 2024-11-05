import java.util.Random;

public class Player {
  public int number;
  public void guess(){
    Random rNumber = new Random();
    number = randomGenerator.nextInt(10);
  }
}

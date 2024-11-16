import java.util.*;

public class finalGame{
  private GameHelper helper = new GameHelper();
  private ArrayList<Startup> startups = new ArrayList<Startup>();
  private int numOfGuesses = 0;

  private void setUpGame() {
    //first make some startups and give them locations
    Startup one = new Startup();
    one.setName("Cruiser");
    Startup two = new Startup();
    two.setName("Battleship");
    Startup three = new Startup();
    three.setName("Aircraft");
    startups.add(one);
    startups.add(two);
    startups.add(three);

    System.out.println("Your Goal is to sink the three ships");
    System.out.println("Cruiser, Battleship and Aircraft");
    System.out.println("Try to sink them in as few guesses as possible");

    for (Startup startup: startups){
      ArrayList<String> newLocation = helper.placeStartup(3);
      startup.setLocationCells(newLocation);
    }
  }
  private void startPlaying(){
    while (!startups.isEmpty()){
      String userGuess = helper.getUserInput("Enter a Guess");
      checkUserGuess(userGuess);
    }
    finishGame();
  }
  private void checkUserGuess(String userGuess){
    numOfGuesses++:
    String result = "miss";
    for (Startup startupToTest: startups){
      result = startupToTest.checkYourself(userGuess);

      if (result.equals("hit")){
        break;
      }
      if (result.equals("kill")){
        startups.remove(startupToTest();
        break;
      }
    }
    System.out.println(result);
  }
  private void finishGame(){
    System.out.println("All startups are sunk!");
    if (numOfGuesses<=18){
      System.out.println("It only Took you "+numOfGuesses+" guesses.");
      System.out.println("You got out before your ships sank");
    } else {
      System.out.println("Took you long enough. "+numOfGuesses+" guesses...");
      System.out.println("Fish are dancing with your options");
    }
  }
  public static void main(String[] args){
    finalGame game = new finalGame();
    game.setUpGame();
    game.startPlaying();
  }
}

public class Startup{
  private ArrayList<String> locationCells;
  private String name;

  public void setLocationCells(ArrayList<String> locs){
    locationCells = locs;
  }
  public void setName(String n){
    name = n;
  }
  public String checkYourself(String userInput){
    String result = "miss";
    int index = locationCells.indexOf(userInput);

    if (index >= 0){
      locationCells.remove(index);
      if (locationCells.isEmpty()){
        result = "kill";
        System.out.println("You sunk "+name+" : ( ");
      } else {
        result = "hit";
      }
    }
    return result;
}

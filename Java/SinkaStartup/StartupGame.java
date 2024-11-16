//Chapter 5 of the book creating a simple battleship style coded game
//Also makes use of user inputting into the command line for the first time

import java.util.*;

public class StartupGame {
  public static void main(String[] args){
    int numOfGuessess = 0;
    GameHelper helper = new GameHelper();
    SimpleStartup theStartup = new SimpleStartup();
    int randomNum = (int)(Math.random()*5);
    int[] locations = {randomNum,randomNum+1,randomNum+2};
    theStartup.setLocationCells(locations);
    boolean isAlive = true;

    while (isAlive){
      int guess = helper.getUserInput("Enter a Number");
      String result = theStartup.checkYourself(guess);
      numOfGuessess++;

      if (result.equals("kill")){
        isAlive = false;
        System.out.println("You Took "+numOfGuessess+ " guesses");
      }
    }
  }
}

//Class that reads the user input from the command line
class GameHelper{
  public int getUserInput(String prompt){
    System.out.print(prompt+": ");
    Scanner scanner = new Scanner(System.in);
    return scanner.nextInt();
  }
}
class SimpleStartup {
  /*
  Using an Array rather than ArrayList
  int[] locationCells;
  int numOfHits;

  String checkYourself(int guess){
    String result = "miss";
    for (int cell: locationCells){
      if(guess==cell){
        result = "hit";
        numOfHits++;
        break;
      }
    }
    if (numOfHits==locationCells.length){
      result = "kill";
    }
    System.out.println(result);
    return result;
  }
  void setLocationCells(int[] locs){
    locationCells = locs;
  }*/
  private ArrayList<String> locationCells;
  public void setLocationCells(ArrayList<String> locs){
    locationCells = locs;
  }
  public String checkYourself(String userInput){
    String result = "miss";
    int index = locationCells.indexOf(userInput);

    if (index >= 0){
      locationCells.remove(index);
      if (locationCells.isEmpty()){
        result = "kill";
      } else {
        result = "hit";
      }
    }
    return result;
  }
}

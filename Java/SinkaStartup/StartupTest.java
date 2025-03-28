public class StartupTest {
  public static void main(String[] args){
    SimpleStartup dot = new SimpleStartup();

    int[] locations = {2,3,4};
    dot.setLocationCells(locations);

    int userGuess = 2;
    String result = dot.checkYourself(userGuess);

    String testResult = "failed";
    if(result.equals("hit")){
      testResult = "passed";
    }
    System.out.println(testResult);
  }
}

class SimpleStartup {
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
  }
}

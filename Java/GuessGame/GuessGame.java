class GuessGame{
  //Creating the Player Objects
  Player p1;
  Player p2;
  Player p3;

  public void startGame(){
    p1 = new Player();
    p2 = new Player();
    p3 = new Player();

    int guessp1 = 0;
    int guessp2 = 0;
    int guessp3 = 0;

    boolean p1isRight = false;
    boolean p2isRight = false;
    boolean p3isRight = false;

    int targetNumber = (int) (Math.random()*10);
    System.out.println("I'm thinking of a number between 0 and 9...");

    while (true){
      System.out.println("Number ot guess is "+targetNumber);

      //Each Player Calls the Guess Method
      p1.guess();
      p2.guess();
      p3.guess();

      //Get each players guess by access the number variable for each player
      guessp1 = p1.Number;
      System.out.println("Player One guessed "+guessp1);
      guessp2 = p2.Number;
      System.out.println("Player Two guessed "+guessp2);
      guessp3 = p3.Number;
      System.out.println("Player Three guessed "+guessp3);

      //Check each players guess to the generated Number
      if (guessp1==targetNumber){
        p1isRight = true;
      }
      if (guessp2==targetNumber){
        p2isRight = true;
      }
      if (guessp3==targetNumber){
        p3isRight = true;
      }

      //If Any player is correct
      if (p1isRight||p2isRight||p3isRight){
        System.out.println("We have a winner!");
        System.out.println("Player one got it right? "+p1isRight);
        System.out.println("Player Two got it right? "+p2isRight);
        System.out.println("Player Three got it right? "+p3isRight);
        System.out.println("Game is Over");
        break;
      } else {
        System.out.println("Players will have to try again.");
      }
    }
  }
}

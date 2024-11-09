//Dog Classes
class Dog {
  int size;
  String name;

  public void bark(){
    if (size>60){
      System.out.println("Woof Woof!");
    } else if (size>14){
      System.out.println("Ruff Ruff!");
    } else {
    System.out.println("Yip Yip!");
  }}
  public void eat(){

  }
  public void chaseCat(){

  }
}
class GoodDog{
  private int size;

  public int getSize(){
    return size;
  }
  public void setSize(int s){
    size = s;
  }
  void bark(){
    if (size>60){
      System.out.println("Woof Woof!");
    } else if (size>14){
      System.out.println("Ruff Ruff!");
    } else {
    System.out.println("Yip Yip!");
    }}
}

public class allDogs{
  public static void main(String[] args){
    //Original Dog Code, Playing with Arrays
    /*
    //Make a new Dog object and access it
    Dog dog1 = new Dog();
    dog1.bark();
    dog1.name = "Bart";

    //Now make a Dog Array
    Dog[] myDogs = new Dog[3];
    //Put dogs into the Array
    myDogs[0] = new Dog();
    myDogs[1] = new Dog();
    myDogs[2] = dog1;

    //Now Access the Dogs using the Array References
    myDogs[0].name = "Fred";
    myDogs[1].name = "Marge";

    System.out.print("Last dog's name is ");
    System.out.println(myDogs[2].name);

    //Now Loop through the Array
    //and tell all dogs to bark
    int x = 0;
    while (x < myDogs.length){
      myDogs[x].bark();
      x++;
    }
    */
    //Implements the size command in the Bark Method
    /*
    Dog one = new Dog();
    one.size = 70;
    Dog two = new Dog();
    two.size = 8;
    Dog three = new Dog();
    three.size = 35;

    one.bark();
    two.bark();
    three.bark();
    */
    //Works with the new Good Dog class
    GoodDog one  = new GoodDog();
    one.setSize(70);
    GoodDog two = new GoodDog();
    two.setSize(8);
    System.out.println("Dog One: " + one.getSize());
    System.out.println("Dog Two: " + two.getSize());
    one.bark();
    two.bark();
  }
}

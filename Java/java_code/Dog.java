class Dog {
  String name;

  public void bark(){
    System.out.println(name+" says Ruff!");
  }
  public void eat(){

  }
  public void chaseCat(){

  }

  public static void main(String[] args){
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
  }
}

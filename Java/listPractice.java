import java.util.*;
/*
Practicing the uses of ArrayLists, LinkedList, HashMaps and HashSets;
Using w3 schools.com for examples and practice
*/
public class listPractice {
  public static void main(String[] args){
    //sortArray();
    // 1 for Number array, 2 for String Array
    //reverseArray(2);
    //hashMap();
    //hashMapDiff();
    hashsetPract();
  }

  //ARRAYLISTS
  public static void sortArray(){
    ArrayList<Integer> myNum = new ArrayList<Integer>();
    /*
    For Math.Random need to define the range
    In example the range is 100
    */
    int max = 100;
    int min = 1;
    int range = max-min+1;
    for (int j = 0; j<10; j++){
      int rand = (int) (Math.random()*range)+min;
      myNum.add(rand);
    }

    Collections.sort(myNum);

    for (int i : myNum){
      System.out.println(i);
    }
  }
  public static void reverseArray(int n){
    switch(n){
      case 1:
        ArrayList<Integer> myNum = new ArrayList<Integer>();
        int max = 100;
        int min = 1;
        int range = max-min+1;
        for (int j = 0; j<10; j++){
          int rand = (int) (Math.random()*range)+min;
          myNum.add(rand);
        }
        //Sorts the Array in Numeric Order then Inverts it
        Collections.sort(myNum, Collections.reverseOrder());
        System.out.println("List After Reverse order");
        for (int i : myNum){
          System.out.println(i);
        }
        break;
      case 2:
        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("Honda");
        cars.add("Toyota");
        cars.add("Alpha Romeo");
        cars.add("Fiat");
        for (String i : cars){
          System.out.println(i);
        }
        //Sorts the Array in Alphabetical Order then Inverts it
        System.out.println("List After Reverse order");
        Collections.sort(cars, Collections.reverseOrder());
        for (String i : cars){
          System.out.println(i);
        }
        break;
      default:
        System.out.println("Default Switch");
    }
  }

  //HashMaps
  public static void hashMapSame(){
    HashMap<String, String> capitalCities = new HashMap<String, String>();

    capitalCities.put("England", "London");
    capitalCities.put("Germany", "Berlin");
    capitalCities.put("Norway", "Oslo");
    capitalCities.put("USA", "Washington DC");

    //Prints all the Keys in the HashMap
    for (String i: capitalCities.keySet()){
      System.out.println(i);
    }
    //Prints all the Values in the HashMap
    for (String i:capitalCities.values()){
      System.out.println(i);
    }
    //Prints all the Keys and Values in the HashMap
    for (String i: capitalCities.keySet()){
      System.out.println("Key: "+i+ " Value: "+capitalCities.get(i));
    }
  }
  public static void hashMapDiff(){
    HashMap<String, Integer> people = new HashMap<String, Integer>();

    people.put("John",32);
    people.put("Steve",30);
    people.put("Angie",33);

    for (String i: people.keySet()){
      System.out.println("Key: "+i+" Value: "+people.get(i));
    }
  }

  //HashSet
  public static void hashsetPract(){
    //Create a HashSet cna call it Numbers
    HashSet<Integer> numbers = new HashSet<Integer>();
    numbers.add(4);
    numbers.add(7);
    numbers.add(8);

    for (int i = 1;i<=10; i++){
      if (numbers.contains(i)){
        System.out.println(i+" was found in the set!");
      } else {
        System.out.println(i+" wasn't found in the set :(");
      }
    }
  }
}

import java.util.*;
import java.util.stream.Collectors;
import com.sun.source.tree.Tree;

public class App {
  public List<String> organizeInbox(String inboxString) {
      // Extract the senders Email Addresses
      String p = "[,\\;\\s]";
      String[] input = inboxString.split(p);
      ArrayList<String> emailAddresses = new ArrayList<String>();
      for (String i : input){
          if (i.contains(".com")||i.contains(".co.uk")){
              emailAddresses.add(i);
          }
      }

      //Count Number of Emails Received
      HashMap<String, Integer> emailCount = new HashMap<String, Integer>();
      for (String x : emailAddresses){
          emailCount.put(x, emailCount.getOrDefault(x,0)+1);
      }

      //Output a list of Strings, where each Contains the address and the count separated by a space
      for (String i : emailCount.keySet()){
          System.out.println(i + " " + emailCount.get(i));
      }

      //Sort the List in descending order of Count, If two have the same then Alphabetically.
      /*Sorted by Keys
      Map<String, Integer> sortedEmails = new TreeMap(emailCount);
      for (Map.Entry<String,Integer> entry : sortedEmails.entrySet()){
          System.out.println(entry.getKey() + " : " + entry.getValue());
      }
      */
      /*Sorted by Value
      List<Map.Entry<String, Integer>> list = new ArrayList<>(emailCount.entrySet());
      Collections.sort(list, new Comparator<Map.Entry<String,Integer>>(){
          public int compare(Map.Entry<String,Integer>o1, Map.Entry<String,Integer>o2){
              return (o1.getValue()).compareTo(o2.getValue());
          }
      });
      Map<String, Integer> sortedEmails = new LinkedHashMap<>();
      for (Map.Entry<String, Integer> entry : list) {
          sortedEmails.put(entry.getKey(), entry.getValue());
      }
      TreeMap<String, Integer> reveresedEmails = new TreeMap<>(Comparator.reverseOrder());
      reveresedEmails.putAll(sortedEmails);

      System.out.println(reveresedEmails);
      */

      //Google AI to help
      Comparator<Map.Entry<String, Integer>> valueComparator = Map.Entry.comparingByValue(Comparator.reverseOrder());
      Comparator<Map.Entry<String, Integer>> keyComparator = Map.Entry.comparingByKey();

      Comparator<Map.Entry<String,Integer>> compoundComparator = valueComparator.thenComparing(keyComparator);

      Map<String, Integer> sortedMap = emailCount.entrySet()
              .stream()
              .sorted(compoundComparator)
              .collect(Collectors.toMap(
                  Map.Entry::getKey,
                  Map.Entry::getValue,
                  (oldValue, newValue) -> oldValue,
                  LinkedHashMap::new // Use LinkedHashMap to preserve the sorted order
              ));

      System.out.println("Sorted by Value, then by Key:");
      /*
      for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
          System.out.println(entry.getKey() + " : " + entry.getValue());
      }*/

      ArrayList<String> output = new ArrayList<String>();

      for (String x : sortedMap.keySet()){
          String y = "";
          y = x + " " + sortedMap.get(x);
          output.add(y);
      }

      return output;
}

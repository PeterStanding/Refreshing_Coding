package com.app;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.text.*;

public class App {

    public List<String> solution(String logs) {
        /*Input Information
        <BookID> borrow <time>, <BookID> return <time>
        Time is given the HH:MM 24 hr format
        BookID is a positive integer between 1 and 500
        Logs Separated by a comma, followed by a space -- (", ")
        */
        /*Example
        "1 borrow 09:00, 2 borrow 10:00, 1 return 12:00, 3 borrow 13:00, 2 return 15:00, 3 return 16:00"
        ["2 05:00"]
        */
        /*Output
        List of Strings representing the booked with the longest duration
        If multiple books share the same longest duration, function should retun all such books in ascending order of ID
        */
        String p = "[,\\.\\s]";
        String[] logArray = logs.split(p);
        ArrayList<String> input = new ArrayList<String>(Arrays.asList(logArray));
        input.removeAll(Arrays.asList(""));

        DecimalFormat formatter = new DecimalFormat("00");

        List<String> output = new ArrayList<String>();
        String[] longestTime = {"0","0"};
        String[] totalTime = {"0","0"};
        List<Integer> bookID = new ArrayList<Integer>();
        int nextOcc = 0, currID = 0,n = 0, count = 0;
        String arrayInput = "";
        for (int x = 0; x < input.size();x+=3){
            currID = Integer.parseInt(input.get(x));
            nextOcc = input.lastIndexOf(Integer.toString(currID));
            if (Collections.frequency(input,input.get(x)) == 2){
                if (input.get(x+1).equals("borrow")){
                    String i = input.get(x+2);
                    String j = input.get(nextOcc+2);

                    String [] partsI = i.split(":");
                    String [] partsJ = j.split(":");

                    int hrsI = Integer.parseInt(partsI[0]);
                    int minsI = Integer.parseInt(partsI[1]);

                    int hrsJ = Integer.parseInt(partsJ[0]);
                    int minsJ = Integer.parseInt(partsJ[1]);

                    int hrsDiff = hrsJ - hrsI;
                    int minsDiff = minsJ - minsI;

                    if (Integer.parseInt(longestTime[0]) == hrsDiff && Integer.parseInt(longestTime[1]) == minsDiff ){
                        bookID.add(currID);
                    } else if (Integer.parseInt(longestTime[0]) < hrsDiff || Integer.parseInt(longestTime[0]) == 0){
                        longestTime[0] = formatter.format(hrsDiff);
                        longestTime[1] = formatter.format(minsDiff);
                        if (bookID.isEmpty()){
                            bookID.add(currID);
                        } else {
                            bookID.clear();
                            bookID.add(currID);
                        }
                    }
                }
            } else {
                if (input.get(x+1).equals("borrow")){
                    for (int a = currID; a < input.size(); a++){
                        if (input.get(a).equals(Integer.toString(currID))){
                            n = a;
                            if (count == 0){
                                break;
                            }
                        }
                    }
                    String i = input.get(x+2);
                    String j = input.get(n+2);

                    String [] partsI = i.split(":");
                    String [] partsJ = j.split(":");

                    int hrsI = Integer.parseInt(partsI[0]);
                    int minsI = Integer.parseInt(partsI[1]);

                    int hrsJ = Integer.parseInt(partsJ[0]);
                    int minsJ = Integer.parseInt(partsJ[1]);

                    int hrsDiff = hrsJ - hrsI;
                    int minsDiff = minsJ - minsI;
                    if (count == 0){
                        totalTime[0] = formatter.format(hrsDiff);
                        totalTime[1] = formatter.format(minsDiff);
                        bookID.add(currID);
                    } if (count > 0){
                        int oldHrs = Integer.parseInt(totalTime[0]);
                        int oldMins = Integer.parseInt(totalTime[1]);

                        totalTime[0] = formatter.format(oldHrs+hrsDiff);
                        totalTime[1] = formatter.format(oldMins+minsDiff);
                        bookID.clear();
                        bookID.add(currID);
                    }
                    count++;
                }
            }
        }
        if (count > 0){
            arrayInput = bookID.get(0) + " " + totalTime[0] + ":"+totalTime[1];
            output.add(arrayInput);
        } else if (bookID.size() == 1){
            arrayInput = bookID.get(0) + " " + longestTime[0] + ":"+longestTime[1];
            output.add(arrayInput);
        } else {
            for (int i : bookID){
                arrayInput = i + " " + longestTime[0] + ":"+longestTime[1];
                output.add(arrayInput);
            }
        }
        return output;
    }
}

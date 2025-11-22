import java.util.*;

public class App {
    public List<int[]> analyzeCompetition(String logs) {
      // Output for the final result
        List<int[]> output = new ArrayList<int[]>();

        //Creates an ArrayList from the Input with No Spaces
        String p = "[,\\.\\s]";
        String[] i = logs.split(p);
        ArrayList<String> input = new ArrayList<String>(Arrays.asList(i));
        input.removeAll(Arrays.asList(""));

        int student1Fail, student1Pass,student2Fail, student2Pass,student3Fail, student3Pass;
        student1Fail = student1Pass = student2Fail =  student2Pass = student3Fail =  student3Pass = 0;
        int stu1Time = 0, stu2Time = 0, stu3Time = 0;

        for (int y = 0; y < input.size(); y++){
            if (input.get(y).equals("1") || input.get(y).equals("2") || input.get(y).equals("3")){
                /* Split the Timing
                String [] parts = input.get(y+2).split(":");
                int curr = Integer.parseInt(parts[0]);
                */
                if (input.get(y+1).equals("fail")) {
                    if (input.get(y).equals("1")){
                        student1Fail++;
                    } else if (input.get(y).equals("2")){
                        student2Fail++;
                    } else if (input.get(y).equals("3")){
                        student3Fail++;
                    }
                }
                if (input.get(y+1).equals("solve")) {
                    int currDiff = Integer.parseInt(input.get(y+3));
                    if (input.get(y).equals("1")){
                        student1Pass++;
                        stu1Time+=currDiff;
                    } else if (input.get(y).equals("2")){
                        student2Pass++;
                        stu2Time+=currDiff;
                    } else if (input.get(y).equals("3")){
                        student3Pass++;
                        stu3Time+=currDiff;
                    }
                }
            }
        }

        // Students that have entered the Competition
        int [] student1 = {1, stu1Time, student1Pass, student1Fail};
        int [] student2 = {2, stu2Time, student2Pass, student2Fail};
        int [] student3 = {3, stu3Time, student3Pass, student3Fail};

        System.out.println(input);

        output.add(student1);
        output.add(student2);
        output.add(student3);

        //Google AI to aid in the Sorting of the List
        final int PRIMARY_SORT_INDEX = 2;   // Third element (Sort Key)
        final int SECONDARY_SORT_INDEX = 1; // Second element (Tie-breaker Key)

        Comparator<int[]> stableComparator = (rowA, rowB) -> {
            int primaryComparison = Integer.compare(rowB[PRIMARY_SORT_INDEX], rowA[PRIMARY_SORT_INDEX]);

            if (primaryComparison != 0) {
                // If primary values are different, return the primary comparison result
                return primaryComparison;
            } else {
                // If primary values are the same (a tie), compare the secondary values
                // Use rowB vs rowA again for descending secondary sort
                return Integer.compare(rowB[SECONDARY_SORT_INDEX], rowA[SECONDARY_SORT_INDEX]);
            }
        };
        output.sort(stableComparator);

        return output;
    }
}

package BreakingRecords;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        List<Integer> output = new ArrayList<>();

        int minScore = 0;
        int maxScore = 0;
        int countMinScore = 0;
        int countMaxScore = 0;

        for (int i = 0; i < scores.size(); i++) {

            int score = scores.get(i);

            if (i == 0) {
                if (minScore == 0 && maxScore == 0) {
                    minScore = score;
                    maxScore = score;
                }
            }

            if (score < minScore) {
                minScore = score;
                countMinScore = countMinScore + 1;
            }else if (score > maxScore) {
                maxScore = score;
                countMaxScore = countMaxScore + 1;
            }
        }

        output.add(countMaxScore);
        output.add(countMinScore);

        return output;
    }

}

// Breaking the record
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

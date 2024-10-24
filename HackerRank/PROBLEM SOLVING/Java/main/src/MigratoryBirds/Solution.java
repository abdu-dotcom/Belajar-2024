package MigratoryBirds;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        int resultOutput = 0;
        int max = 0;
        int min = 0;

        HashMap<Integer, Integer> bird = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.size(); i++) {
            int typeBird = arr.get(i);
            // check bird

            if (bird.containsKey(typeBird)) {
                bird.put(typeBird, bird.get(typeBird)+1);
            }else {
                bird.put(typeBird, 1);
            }

            if (bird.get(typeBird) > max) {
                max = bird.get(typeBird);
                min = typeBird;
            }else if (bird.get(typeBird) == max) {
                if (typeBird < min) {
                    min = typeBird;
                }
            }
        }

        return resultOutput = min;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
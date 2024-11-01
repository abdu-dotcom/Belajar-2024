package Medium.ClimbingTheLeaderboard;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here

        List<Integer> rankedOutput = new ArrayList<Integer>();

        // Populate rankedOutput with unique values in descending order
        for (int score : ranked) {
            if (rankedOutput.isEmpty() || rankedOutput.get(rankedOutput.size() - 1) != score) {
                rankedOutput.add(score);
            }
        }

        List<Integer> rankPlayer = new ArrayList<Integer>();
        int rankedIndex = rankedOutput.size() - 1; // Start from the lowest rank

        for(int scorePlayer : player){
            while (rankedIndex >= 0 && scorePlayer >= rankedOutput.get(rankedIndex)) {
                rankedIndex--;
            }

            rankPlayer.add(rankedIndex + 2);
        }

        System.out.println("rankedIndex : " + rankedIndex);
        return rankPlayer;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

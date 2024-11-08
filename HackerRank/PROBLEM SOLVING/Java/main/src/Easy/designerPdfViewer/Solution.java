package Easy.designerPdfViewer;

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
     * Complete the 'designerPdfViewer' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h
     *  2. STRING word
     */

    public static int designerPdfViewer(List<Integer> h, String word) {
        // Write your code here

        // Creating Arrays of String type
        String alfabet[]
                = new String[] {"a","b","c","d","e","f","g","h","i","j"
                ,"k","l","m","n","o","p","q","r","s","t","u","v","w","x"
                ,"y","z"};

        // Getting the list view of Array
        List<String> list = Arrays.asList(alfabet);

        int output = 0;
        char[] wordChar = word.toCharArray();

        for (int i = 0; i < wordChar.length; i++) {
            int indextChar = 0;

            for (int j = 0; j < alfabet.length; j++) {

                if (String.valueOf(wordChar[i]).equals(alfabet[j])) {

                    indextChar = indextChar +j;

                    j = alfabet.length;
                    int valueIndexChar = h.get(indextChar);

                    if (valueIndexChar > output) {
                        output = valueIndexChar;
                    }
                }
            }
        }
        output = output * word.length();
        return output;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        List<Integer> h = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String word = bufferedReader.readLine();

        int result = Result.designerPdfViewer(h, word);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

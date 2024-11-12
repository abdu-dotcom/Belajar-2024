class Solution {
    public String mergeAlternately(String word1, String word2) {

        // pisahkan string menjadi satu-satu huruf (Array)
        String[] wordArray1 = word1.split(""); // "abc"
        String[] wordArray2 = word2.split(""); // "pqr";

        // dapatnya length dari string1 dan string2
        int lengthWordArray1 = wordArray1.length;
        int lengthWordArray2 = wordArray2.length;

        // dapatkan length terpanjang dari string1 dan string2
        int length = (lengthWordArray1 > lengthWordArray2 ? lengthWordArray1 : lengthWordArray2);

        // init kalimat yang akan digabung
        String mergeWord = "";

        // looping string
        for(int i = 0; i < length; i++){

            String char1 = "";
            String char2 = "";

            if (lengthWordArray1 > i) char1 = wordArray1[i];
            if (lengthWordArray2 > i) char2 = wordArray2[i];

            // gabungkan string dari char1 dan char2 kedalam mergeWord
            mergeWord = mergeWord + char1 + char2;
        }
        return mergeWord;
    }
}
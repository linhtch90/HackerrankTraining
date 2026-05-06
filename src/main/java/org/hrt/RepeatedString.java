package org.hrt;

import java.io.*;

class Result {

    /*
     * Complete the 'repeatedString' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. LONG_INTEGER n
     */

    public static long repeatedString(String s, long n) {
        // Write your code here

        long repeat = (n / s.length()) + 1;
        long redundant = repeat * s.length() - n;
        long lastRepeat = s.length() - redundant;
        long lastACount = 0;
        for (int i = 0; i < lastRepeat; i++) {
            if (s.charAt(i) == 'a') {
                lastACount += 1;
            }
        }
        long stringACount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                stringACount++;
            }
        }
        return lastACount + stringACount * (repeat - 1);
    }

}

public class RepeatedString {
    static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


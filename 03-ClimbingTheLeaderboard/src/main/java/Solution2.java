import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result2 {

    /*
     * Complete the 'gamingArray' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static String gamingArray(List<Integer> arr) {
        boolean bob = false;
        while (arr.get(0) > 0) {
            int max = arr.get(0);
            int index = 0;
            for (int i = 1; i < arr.size(); i++) {
                if (max < arr.get(i)) {
                    max = arr.get(i);
                    index = i;
                }
            }
            for (int i = index; i < arr.size(); i++) {
                arr.set(i, 0);
            }
            bob = !bob;
        }

        if (bob) {
            return "BOB";
        } else {
            return "ANDY";
        }
    }
}

public class Solution2 {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int g = Integer.parseInt(bufferedReader.readLine().trim());
//
//        for (int gItr = 0; gItr < g; gItr++) {
//            int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//            String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//            List<Integer> arr = new ArrayList<>();
//
//            for (int i = 0; i < arrCount; i++) {
//                int arrItem = Integer.parseInt(arrTemp[i]);
//                arr.add(arrItem);
//            }
        List<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(2);
        arr.add(6);
        arr.add(3);
        arr.add(4);

        String result = Result2.gamingArray(arr);
        System.out.println(result);

        String str1 = "2229505813";
        String str2 = "9505";
        String str3 = str1.substring(str1.indexOf(str2), str1.length() - str2.length() + 1);
        System.out.println(str3);

//            bufferedWriter.write(result);
//            bufferedWriter.newLine();
    }
//
//        bufferedReader.close();
//        bufferedWriter.close();

}

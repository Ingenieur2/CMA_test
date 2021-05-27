import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;


public class Solution3 {
//    https://www.hackerrank.com/challenges/ctci-contacts/problem
    public static final String ADD_FUNCTION = "add";
    public static final String FIND_FUNCTION = "find";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Set<String> names = new TreeSet<>();
        List<String> findings = new ArrayList<>();

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        for (int nItr = 0; nItr < n; nItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            // String op = firstMultipleInput[0];

            // String contact = firstMultipleInput[1];
            if (firstMultipleInput[0].equals(ADD_FUNCTION)) {
                names.add((firstMultipleInput[1]));
            }
            if (firstMultipleInput[0].equals(FIND_FUNCTION)) {
                findings.add(firstMultipleInput[1]);
            }
        }
        List<String> newList = new ArrayList<>(names);
        int findingsLength = findings.size();
        int contactsLength = newList.size();

        for (int i = 0; i < findingsLength; i++) {
            int count = 0;
            for (int j = 0; j < contactsLength; j++) {
                if(newList.get(j).startsWith(findings.get(i))){
                    count++;
                }
            }
            System.out.println(count);
        }

        bufferedReader.close();
    }
}
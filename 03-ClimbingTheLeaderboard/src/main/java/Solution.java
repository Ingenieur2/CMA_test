//https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

class Result {
    static final List<String> threadsNameList = new ArrayList<>();
    static final List<Thread> threadsList = new ArrayList<>();
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
//        List<Integer> output = new ArrayList<>();
        threadsNameList.add("first__1");
//        threadsNameList.add("second____2");

        Result sequence = new Result();
        for (int j = 0; j < threadsNameList.size(); j++) {
            Thread currentThread = new Thread(() -> {
                sequence.action(ranked, player);
            });
            currentThread.start();
        }


        List<Integer> output = new ArrayList<>();

        Set<Integer> deleteAllRepeats = new TreeSet<>();
        deleteAllRepeats.addAll(ranked);
        List<Integer> newListRanked = new ArrayList<>();
        newListRanked.addAll(deleteAllRepeats);

        int sizeOfPlayers = player.size();
        int sizeOfNewListRanked = newListRanked.size();

        for (int i = 0; i < sizeOfPlayers; i++) {
            output.add(1);

            for (Integer integer : newListRanked) {
                if (player.get(i) < integer) {
                    output.set(i, output.get(i) + 1);
                }
            }
        }
        return output;
    }


    private synchronized List<Integer> action(List<Integer> ranked, List<Integer> player) {

        List<Integer> output = new ArrayList<>();

        Set<Integer> deleteAllRepeats = new TreeSet<>();
        deleteAllRepeats.addAll(ranked);
        List<Integer> newListRanked = new ArrayList<>();
        newListRanked.addAll(deleteAllRepeats);

        int sizeOfPlayers = player.size();
        int sizeOfNewListRanked = newListRanked.size();

        for (int i = 0; i < sizeOfPlayers; i++) {
            output.add(1);

            for (Integer integer : newListRanked) {
                if (player.get(i) < integer) {
                    output.set(i, output.get(i) + 1);
                }
            }
        }
        notify();
        return output;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] rankedTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> ranked = new ArrayList<>();

        for (int i = 0; i < rankedCount; i++) {
            int rankedItem = Integer.parseInt(rankedTemp[i]);
            ranked.add(rankedItem);
        }

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] playerTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> player = new ArrayList<>();

        for (int i = 0; i < playerCount; i++) {
            int playerItem = Integer.parseInt(playerTemp[i]);
            player.add(playerItem);
        }

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


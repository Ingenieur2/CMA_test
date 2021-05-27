import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result4 {
//https://www.hackerrank.com/challenges/the-grid-search/problem
    /*
     * Complete the 'gridSearch' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY G
     *  2. STRING_ARRAY P
     */
    //EXAMPLE
//    2
//            20 20
//            34889246430321978567
//            58957542800420926643
//            35502505614464308821
//            14858224623252492823
//            72509980920257761017
//            22842014894387119401
//            01112950562348692493
//            16417403478999610594
//            79426411112116726706
//            65175742483779283052
//            89078730337964397201
//            13765228547239925167
//            26113704444636815161
//            25993216162800952044
//            88796416233981756034
//            14416627212117283516
//            15248825304941012863
//            88460496662793369385
//            59727291023618867708
//            19755940017808628326
//            7 4
//            1641
//            7942
//            6517
//            8907
//            1376
//            2691
//            2599
//            25 25
//            7652157548860692421022503
//            9283597467877865303553675
//            4160389485250089289309493
//            2583470721457150497569300
//            3220130778636571709490905
//            3588873017660047694725749
//            9288991387848870159567061
//            4840101673383478700737237
//            8430916536880190158229898
//            8986106490042260460547150
//            2591460395957631878779378
//            1816190871689680423501920
//            0704047294563387014281341
//            8544774664056811258209321
//            9609294756392563447060526
//            0170173859593369054590795
//            6088985673796975810221577
//            7738800757919472437622349
//            5474120045253009653348388
//            3930491401877849249410013
//            1486477041403746396925337
//            2955579022827592919878713
//            2625547961868100985291514
//            3673299809851325174555652
//            4533398973801647859680907
//            5 4
//            5250
//            1457
//            8636
//            7660
//            7848


    public static String gridSearch(List<String> G, List<String> P) {
        // Write your code here
        String str = "YES";
        boolean flag = false;

        int heightG = G.size();
        int widthG = G.get(0).length();
        int[][] arrG = new int[heightG][widthG];

        int heightP = P.size();
        int widthP = P.get(0).length();
        int[][] arrP = new int[heightP][widthP];

        for (int i = 0; i < heightG; i++) {
            for (int j = 0; j < widthG; j++) {
                arrG[i][j] = Integer.parseInt(String.valueOf(G.get(i).toCharArray()[j]));
                System.out.print(arrG[i][j] + "  ");
            }
            System.out.println();
        }
        for (int i = 0; i < heightP; i++) {
            for (int j = 0; j < widthP; j++) {
                arrP[i][j] = Integer.parseInt(String.valueOf(P.get(i).toCharArray()[j]));
                System.out.print(arrP[i][j] + "  ");
            }
            System.out.println();
        }
        for (int i = 0; i < heightG - heightP; i++) {
            for (int j = 0; j < widthG - widthP; j++) {
                if (arrG[i][j] == arrP[0][0]) {
                    flag = true;
                    for (int i1 = 0; i1 < heightP; i1++) {
                        for (int j1 = 0; j1 < widthP; j1++) {
                            if (!(arrG[i + i1][j + j1] == arrP[i1][j1])) {
                                flag = false;
                                j1 = widthP;
                                i1 = heightP;
                            }
                        }
                    }
                    if (flag) {
                        i = heightG - heightP;
                        j = widthG - widthP;
                    }
                }
            }
        }
        if (!flag) {
            str = "NO";
        }
        return str;
    }
}


public class Solution4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter((System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int R = Integer.parseInt(firstMultipleInput[0]);

            int C = Integer.parseInt(firstMultipleInput[1]);

            List<String> G = new ArrayList<>();

            for (int i = 0; i < R; i++) {
                String GItem = bufferedReader.readLine();
                G.add(GItem);
            }

            String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int r = Integer.parseInt(secondMultipleInput[0]);

            int c = Integer.parseInt(secondMultipleInput[1]);

            List<String> P = new ArrayList<>();

            for (int i = 0; i < r; i++) {
                String PItem = bufferedReader.readLine();
                P.add(PItem);
            }

            String result = Result4.gridSearch(G, P);

            System.out.println(result);

        }

        bufferedReader.close();
//        bufferedWriter.close();
    }
}


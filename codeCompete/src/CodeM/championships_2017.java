package CodeM;

import java.util.Arrays;
import java.util.Scanner;

public class championships_2017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] score = new int[n];
            score[0] = sc.nextInt();
            int tag = score[0];
            int greater = 1;
            for (int i = 1; i < n; i++) {
                score[i] = sc.nextInt();
                if (score[i] <= tag) {
                    greater += 1;
                }
            }
            //int after=(int)(Math.log(greater)/Math.log(2));
            int after = 0;
            while (greater > 1) {
                greater /= 2;
                after += 1;
            }
            System.out.println(after);
        }
    }
}

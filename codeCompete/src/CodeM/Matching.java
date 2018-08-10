package CodeM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class time_cost {
    int de, shop, time;

    public time_cost(int de, int shop, int time) {
        this.de = de;
        this.shop = shop;
        this.time = time;
    }
}

public class Matching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        time_cost[] t = new time_cost[m];
        for (int i = 0; i < m; i++) {
            int del = sc.nextInt();
            int shop = sc.nextInt();
            int cost = sc.nextInt();
            t[i] = new time_cost(del, shop, cost);
        }
        Arrays.sort(t, new Comparator<time_cost>() {
            @Override
            public int compare(time_cost time_cost, time_cost t1) {
                return time_cost.time - t1.time;
            }
        });
        int[] res = new int[n];
        ArrayList<Integer> has = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (!has.contains(t[i].shop)) {
                res[has.size()] = t[i].time;
                has.add(t[i].shop);
            }
            if (has.size()==n)break;
        }
        if (has.size()<n){
            System.out.println("-1");
        }else {
            for (int i = 0; i < n - 1; i++)
                System.out.print(res[i] + " ");
            System.out.println(res[n - 1]);
        }

    }
}

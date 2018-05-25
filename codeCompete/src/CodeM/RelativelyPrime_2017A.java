package CodeM;

import java.util.HashMap;
import java.util.Scanner;

public class RelativelyPrime_2017A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n + 1];
        HashMap<Integer, Integer> all = new HashMap<>();
        int k = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            if (!all.containsKey(a[i])) {
                all.put(a[i], k++);
            }
        }
        //use times to record every a[i]'s times
        int[][] times = new int[all.size()][n + 1];
        for (int j = 1; j <= n; j++) {
            int key = all.get(a[j]);
            times[key][j] = times[key][j - 1] + 1;
            for (int i = 0; i < times.length; i++) {
                times[i][j] = Math.max(times[i][j], times[i][j - 1]);
            }
        }

        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            k = sc.nextInt();
            //ArrayList<Integer> exist = new ArrayList<>();
            long res = 0;
            for (int x = 0; x < times.length; x++) {
                int time = times[x][r] - times[x][l - 1];
                //System.out.println(l+"\t"+r+"\t"+time);
                if (time == 0)
                    continue;
                if (gcd(k, time) == 1) {
                    // exist.add(time);
                    res += 1;
                }
            }
            System.out.println(res);
        }
    }

    private static int gcd(int a, int b) {
        while (b > 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}


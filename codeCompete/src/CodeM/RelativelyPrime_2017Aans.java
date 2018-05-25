package CodeM;

import java.util.Scanner;

public class RelativelyPrime_2017Aans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n + 1];
        int maxid = -1, minid = 50000;
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            maxid = maxid > a[i] ? maxid : a[i];
            minid = minid < a[i] ? minid : a[i];
        }
        for (int i = 1; i <= m; i++) {
            int[] vis = new int[maxid + 1];
            int l = sc.nextInt();
            int r = sc.nextInt();
            int k = sc.nextInt();
            for (int j = l; j <= r; j++) {
                vis[a[j]] += 1;
            }
            int res = 0;
            for (int p = 0; p < vis.length; p++) {
                if (vis[p] == 0) continue;
                if (gcd(vis[p], k) == 1) res += 1;
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

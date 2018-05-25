package CodeM;

import java.util.ArrayList;
import java.util.Scanner;

public class LongestTreeChain_2017A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] tree = new int[n + 1];
        for (int i = 1; i < n; i++) {
            int in = sc.nextInt();
            int out = sc.nextInt();
            tree[out] = in;
        }
        int[] w = new int[n + 1];
        for (int i = 1; i <= n; i++)
            w[i] = sc.nextInt();
        sc.close();
        int res = 0;
        for (int i = n; i > 0; i--) {
            if (tree[i] > 0&& w[i]>1) {
                int t = dfs(tree, i, w, w[i], 1);
                res = res > t ? res : t;
                //System.out.println(i+"\tres:"+res);
            }
        }
        System.out.println(res);
    }

    private static int dfs(int[] tree, int cur, int[] w, int gcd, int res) {
        int in = tree[cur];
        int gcd1 = gcd(w[in], gcd);
        if (in > 0 && gcd1 > 1) {
            res += 1;
            int t = dfs(tree, in, w, gcd1, res);
            res = res > t ? res : t;
        }
        //System.out.println(in+"\t"+gcd1+"\t"+cur+" gcd: "+gcd+" res: "+res);
        return res;
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

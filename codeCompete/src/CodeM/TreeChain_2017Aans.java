package CodeM;

import java.util.ArrayList;
import java.util.Scanner;

class node{
    int weight;
    ArrayList<Integer> leaf;
    public node() {
    }
}
public class TreeChain_2017Aans {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        node[] tree = new node[n + 1];
        for (int i = 1; i < n; i++) {
            int in = sc.nextInt();
            int out = sc.nextInt();
            try {
                tree[in].leaf.add(out);
            } catch (Exception e) {
                tree[in] = new node();
                tree[in].leaf = new ArrayList<>();
                tree[in].leaf.add(out);
            }
        }
        for (int i = 1; i <= n; i++) {
            int w = sc.nextInt();
            try {
                tree[i].weight = w;
            } catch (Exception e) {
                tree[i] = new node();
            }
        }
        int res = 1;
        int[] vis = new int[n + 1];
        vis[1] = 1;
        res = dfs(tree, 1, tree[1].weight, res, vis);
        System.out.println(res);
    }

    private static int dfs(node[] tree, int cur, int gcd, int res, int[] vis) {
         System.out.println(cur+"\t"+gcd+"\t"+cur+" gcd: "+gcd+" res: "+res);
        int ans = res;
        try {
            for (int leaf : tree[cur].leaf) {
                if (vis[leaf] == 0) {
                    int t = gcd(tree[leaf].weight, gcd);
                    if (t > 1) {
                        vis[leaf] = 1;
                        int len = dfs(tree, leaf, t, res + 1, vis);
                        ans = ans > len ? ans : len;
                    }
                }
            }
        } catch (Exception e) {
            return ans;
        }
        return ans;
    }

    private static int gcd(int a,int b){
        while (b>0){
            int t=a%b;
            a=b; b=t;
        }
        return a;
    }
}

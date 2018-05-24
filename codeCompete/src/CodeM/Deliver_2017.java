package CodeM;


import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Deliver_2017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            String[] G = new String[n];
            String str = "";
            int[] vis = new int[n];
            int[] vis2 = new int[n];
            for (int i = 0; i < n; i++)
                G[i] = "\t";
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
                int t = i + a[i];
                if (t >= 0 && t < n) {
                    //G存储可以到达t点的所有点（t = 0~n-1）
                    G[t] += i + "\t";
                }
            }
            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
                int t = i + b[i];
                if (t >= 0 && t < n) {
                    G[t] += i + "\t";
                }
            }
            //System.out.println(Arrays.toString(G));
            //从后向前使用广度优先搜索，求搜索路径
            rev_bfs(n - 1, G, vis);
            if (vis[0] == 0) {
                //从后向前搜索，未能到达初始点0
                System.out.println("No solution!");
            } else {
                //能够到达初始点0,则求最小字典序方案
                int p = 0;
                vis2[0] = 1; //前向访问数组
                boolean infflag = false;
                for (int x = 0; x != n - 1 && !infflag; ) {
                    int nxt = x + a[x];
                    if (nxt >= 0 && nxt < n && vis[nxt] == 1) {
                        if (vis2[nxt] == 0) {
                            vis2[nxt] = 1;
                            str += 'a';
                        } else {
                            //若已访问过，说明存在环，使得方案无限
                            infflag = true;
                        }
                        x = nxt;
                    } else {
                        nxt = x + b[x];
                        if (nxt >= 0 && nxt < n && vis[nxt] == 1) {
                            if (vis2[nxt] == 0) {
                                vis2[nxt] = 1;
                                str += 'b';
                            } else {
                                infflag = true;
                            }
                        } else {
                            System.out.println("No solution!");
                        }
                        x = nxt;
                    }
                }
                System.out.println(infflag ? "Infinity!" : str);
            }
        }
    }
    private static void rev_bfs(int p, String[] G, int[] vis) {
        Queue<Integer> q = new ArrayDeque<>();
        vis[p] = 1;
        q.add(p);
        while (!q.isEmpty()) {
            //System.out.println(q.toString());
            int x = q.poll();
            String[] str = G[x].trim().split("\t");
            for (int i = 0; i < str.length; i++) {
                int t;
                try {
                    t = Integer.valueOf(str[i]);
                } catch (Exception e) {
                    continue;
                }
                if (vis[t] == 0) {
                    vis[t] = 1;
                    q.add(t);
                }
            }
        }
    }
}

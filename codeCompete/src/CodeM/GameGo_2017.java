package CodeM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class hascode {
    long has0;
    long has1;

    public hascode(long has0, long has1) {
        this.has0 = has0;
        this.has1 = has1;
    }
}

public class GameGo_2017 {
    static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    static int goNum = 19;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            while (n-- > 0) {
                int Num = sc.nextInt();
                char[][] go = new char[goNum][goNum];
                for (int i = 0; i < go.length; i++) {
                    // inital go board
                    for (int j = 0; j < go.length; j++)
                        go[i][j] = '.';
                }
                //use st to store the hashcode of go board,
                // to compare the next go board and the past go board.
                ArrayList<Long> st = new ArrayList<>();
                check(go, st);
                while (Num-- > 0) {
                    String op = sc.next();
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    x -= 1;
                    y -= 1;
                    //System.out.println("first : "+op);
                    char a = op.charAt(0);
                    char b = a == 'B' ? 'W' : 'B';
                    if (go[x][y] != '.') {
                        //exist one point.
                        System.out.println("miss 1");
                    } else {
                        //use nextgo to get the next step
                        //if this step can be done then cur equals to nextgo
                        //otherwise print the mistake.
                        char[][] nextgo = new char[goNum][goNum];
                        copy(nextgo, go);
                        /*System.out.println("==============================");
                        for (int i = 0; i < goNum; i++) {
                            System.out.println(Arrays.toString(nextgo[i]));
                        }*/
                        nextgo[x][y] = a;
                        //use vis[][] to distinguish one poist is visited or not.
                        int[][] vis = new int[goNum][goNum];
                        //check this step is conformed to the 2nd or not
                        //that is whether exist a or not,if not that is the 2nd mistake.
                        boolean isOk = dfs(x, y, a, vis, nextgo);
                        for (int i = 0; i < dir.length; i++) {
                            int tx = x + dir[i][0];
                            int ty = y + dir[i][1];
                            //!dfs(tx,ty,b,vis,nextgo) means there are all a around [tx,ty]
                            //according the go rules,must pick the go point.
                            if (tx >= 0 && tx < goNum && ty >= 0 && ty < goNum &&
                                    vis[tx][ty] == 0 && nextgo[tx][ty] == b
                                    && !dfs(tx, ty, b, vis, nextgo)) {
                                pick(tx, ty, b, nextgo);
                                isOk = true;
                            }
                        }
                        if (isOk) {
                            // if this step will not appear the first two mistakes
                            // now check if the same as the the past one go board.
                            // use hashcode to compare.
                            if (check(nextgo, st)) {
                                //if this step is pass the check,then the cur is
                                // the same as the next
                                copy(go, nextgo);
                            } else System.out.println("miss 3");
                        } else System.out.println("miss 2" );
                    }
                }
                //show();
                for (int i = 0; i < goNum; i++) {
                    for (int j = 0; j < goNum; j++) {
                        System.out.print(go[i][j]);
                    }
                    System.out.println();
                }
            }

    }

    private static boolean dfs(int x, int y, char op, int[][] vis, char[][] next) {
        //check whether this point is surrounded by different points
        if (next[x][y] == '.') return true;
        if (next[x][y] != op) return false;
        vis[x][y] = 1;
        boolean isOk = false;
        for (int i = 0; i < dir.length; i++) {
            int tx = x + dir[i][0];
            int ty = y + dir[i][1];
            if (tx >= 0 && tx < goNum && ty >= 0 && ty < goNum && vis[tx][ty] == 0) {
                isOk |= dfs(tx, ty, op, vis, next);
            }
        }
        return isOk;
    }

    private static void pick(int x, int y, char op, char[][] next) {
        next[x][y] = '.';
        for (int i = 0; i < dir.length; i++) {
            int tx = x + dir[i][0];
            int ty = y + dir[i][1];
            if (tx >= 0 && tx < goNum && ty >= 0 && ty < goNum && next[tx][ty] == op)
                pick(tx, ty, op, next);
        }
    }

    private static boolean check1(char[][] next, ArrayList<hascode> st) {
        long has1 = 0, has2 = 0;
        for (int i = 0; i < goNum; i++) {
            for (int j = 0; j < goNum; j++) {
                has1 = has1 * 131 + next[i][j];
                has2 = has2 * 137 + next[i][j];
            }
        }
        for (hascode has : st) {
            if (has1 == has.has0 && has2 == has.has1)
                return false;
        }
        hascode hasCode = new hascode(has1, has2);
        st.add(hasCode);
        return true;
    }
    private static boolean check(char[][] next, ArrayList<Long> st) {
        long has1 = 0;
        for (int i = 0; i < goNum; i++) {
            for (int j = 0; j < goNum; j++) {
                has1 = has1 * 131 + next[i][j];
                //has2 = has2 * 137 + next[i][j];
            }
        }
        if (st.contains(has1)){
            return false;
        }
        //hascode hasCode = new hascode(has1, has2);
        st.add(has1);
        return true;
    }

    private static void copy(char[][] next, char[][] go) {
        for (int i = 0; i < goNum; i++)
            for (int j = 0; j < goNum; j++)
                next[i][j] = go[i][j];
    }

}

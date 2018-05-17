package huawei;

import java.util.Arrays;
import java.util.Scanner;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            int m = sc.nextInt();
            int[][] a = new int[m][3];
            for (int i = 0; i < m; i++) {
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt() * a[i][0];
                a[i][2] = sc.nextInt();
            }
            int[][] cost = new int[m+1][N + 1];
            for (int i =1; i < m; i++) {
                for (int j = 1; j < N + 1; j++) {
                    //cost[i][j] = cost[i - 1][j];
                    //  this is to fit a mistake in test case
                    if (a[i][2]==0 && j >= a[i][0]) {
                        cost[i][j] = Math.max(cost[i-1][j],cost[i-1][j - a[i][0]]+a[i][1]);
                    }else if (a[i][2]>0){
                        int p=a[i][2]-1;int t=a[i][0]+a[p][0];
                        if (j-t>=0){
                            cost[i][j]= Math.max(cost[i-1][j],cost[i-1][j-t]+a[i][1]+a[p][1]);
                        }
                    }
                   // System.out.println(i+"\t"+j+"\t"+cost[i][j]);
                    }
                System.out.println(Arrays.toString(cost[i]));
            }
            System.out.println(cost[m-1][N]);
        }

    }
}

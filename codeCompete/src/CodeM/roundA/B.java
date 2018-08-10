package CodeM.roundA;

import org.omg.CORBA.MARSHAL;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] target = new int[n];
        int max_start = 0;
        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
            if (start[i] == 1) {
                max_start = i;
            }
        }
        int diff = 0;
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            target[i] = sc.nextInt();
            if (i >= max_start && target[i] == 1) {
                diff += 1;
            }
            if (target[i] == start[i] && target[i] == 1) {
                pos[i] = 1;
            }
        }
        int st_1 = diff;
        int res = 0;
        for (int i = n - 1; i > 0; i--) {
            //get (1,1)
            if (diff-- >= 0 && start[i] == 1 && target[i] != start[i]) {
                res += i;
                start[i] = 0;
                start[0] = 1;
                //System.out.println("yyy");
            }
        }
        //System.out.println(st_1+"\t"+Arrays.toString(start));
        for (int i = 0; i < n; i++) {
            if (start[i] == target[i] || target[i] == 0) continue;
            //System.out.println(i+"\t"+Arrays.toString(start));
            for (int j = n - 1; j >= 0; j--) {
                if (start[j] == 1 && pos[j] == 0) {
                    pos[j] = 1;
                    res += Math.abs(i - j);
                    start[j] = 0;
                    start[i] = 1;
                    if (j == 0 && st_1-- >= 0) {
                        start[j] = 1;
                    }
                }
            }
        }
        System.out.println(res);

    }
}

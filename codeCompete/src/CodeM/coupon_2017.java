package CodeM;

import java.util.Scanner;

public class coupon_2017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxN = 100005;
        int m = sc.nextInt();
        int[] coupon = new int[maxN];
        int res = -1;
        int unknow = 0;
        for (int i = 0; i < m; i++) {
            String op = sc.next();
            if (op.equals("？")) {
                unknow += 1;
                continue;
            }
            // System.out.println(op);
            int id = sc.nextInt();
            if (op.equals("I")) {
                coupon[id] += 1;
            } else {
                if (coupon[id] > 0) {
                    coupon[id] -= 1;
                } else if (unknow > 0) {
                    unknow -= 1;
                } else {
                    res = i + 1;
                    break;
                }
            }
        }
        System.out.println(res);
    }
}

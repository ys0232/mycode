package wangyi;

import java.util.Scanner;

public class divide3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            int i = 1;
            int sum = 0;
            while (i <= left) {
                if (i >= 10) {
                    int t = i;
                    while (t >= 10) {
                        sum += t % 10;
                        t /= 10;
                    } sum+=t;
                } else sum += i;
                i++;
            }
            sum = sum % 3;
            int res = 0;
            if (sum == 0) res += 1;
            // System.out.println(sum+"\t"+left+"\t"+right);
            while (i <= right) {
                int t = i;
                if (i >= 10) {
                    while (t >=10) {
                        sum += t % 10;
                        t /= 10;
                    }
                    sum+=t;
                } else sum += i;
                sum = sum % 3;
                // System.out.println(sum+"===");
                if (sum == 0) {
                    res += 1;
                }
                i++;
            }
            System.out.println(res);

        }
    }
}

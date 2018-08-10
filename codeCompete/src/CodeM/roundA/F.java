package CodeM.roundA;

import java.util.ArrayList;
import java.util.Scanner;

public class F {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        String s = sc.next();
        while (s.length() == 0) {
            s = sc.next();
        }
        String mod = "";
        int res = -1;
        int i = 0;
        int carry;
        boolean flag = false;
        int t = 0;
        ArrayList<Integer> big_a = new ArrayList<>();
        int max_len = 100005;
        while (i < max_len) {
            carry = a / b;
            t = (a - carry * b);
            a = t * 10;
            if (big_a.contains(t)){
                i += 1;
                mod += String.valueOf(carry);
                break;
            }

            if (carry <= 0) {
                flag = true;
            }
            if (flag) {
                i += 1;
                mod += String.valueOf(carry);
                big_a.add(t);
            }
        }
        String circle = mod.substring(big_a.indexOf(t));
        System.out.println(mod+"\t"+big_a+"\t"+t+"\t"+circle);
        int cur = 0;
        for (int j = 1; j < max_len; j++) {
            if (mod.equals(s)) {
                res = j;
                break;
            } else {
                mod = mod.substring(1) + circle.charAt((cur++) % circle.length());
            }
        }
        System.out.println(res);

    }
}

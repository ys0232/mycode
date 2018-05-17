package huawei;

import java.util.Scanner;

public class StrSplit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            int len = str.length();
            String res = "";
            int k = 0;
            while (len > 0) {
                //System.out.println(len);
                if (len >= 8) {
                    if (res.length() == 0) {
                        res = str.substring(k, k + 8);
                    } else res += "\n" + str.substring(k, k + 8);
                    k += 8;
                    len -= 8;
                } else {
                    if (res.length() == 0) {
                        res = str;
                    } else res += "\n" + str.substring(k);
                    for (int i = len; i < 8; i++) {
                        res += "0";
                    }
                    len = 0;
                }
            }
            System.out.println(res);
        }
    }
}

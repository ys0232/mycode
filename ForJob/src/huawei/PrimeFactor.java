package huawei;


import java.util.Scanner;

public class PrimeFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long n = sc.nextLong();
            while (n > 1) {
                for (int i = 2; i <= n; i++) {
                    boolean flag = true;
                    for (int j = 2; j <= i / 2; j++) {
                        if (i % j == 0) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag && n % i == 0) {
                        System.out.print(i + " ");
                        n = n / i;
                        break;
                    }
                }
            }
        }
    }
}

package CodeM;

import java.util.Scanner;

public class CombinePalindrome_2017A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            while (n-- > 0) {
                int res = 0;
                String s1 = sc.next();
                String s2 = sc.next();
                char[] ch1 = s1.toCharArray();
                char[] ch2 = s2.toCharArray();
                int len1 = ch1.length;
                int len2 = ch2.length;
                boolean[][][][] f = new boolean[55][55][55][55];
                for (int x = 0; x <= len1; x++) {
                    for (int y = 0; y <= len2; y++) {
                        for (int i = 1, j = x; j <= len1; i++, j++) {
                            for (int k = 1, l = y; l <= len2; k++, l++) {
                                if (x + y <= 1) {
                                    //边界初始化为true
                                    f[i][j][k][l] = true;
                                } else {
                                    f[i][j][k][l] = false;
                                    if (x > 1 && ch1[i-1] == ch1[j-1]) f[i][j][k][l] |= f[i + 1][j - 1][k][l];
                                    if (x > 0 && y > 0 && ch1[i-1] == ch2[l-1]) f[i][j][k][l] |= f[i + 1][j][k][l - 1];
                                    if (y > 1 && ch2[k-1] == ch2[l-1]) f[i][j][k][l] |= f[i][j][k + 1][l - 1];
                                    if (x > 0 && y > 0 && ch2[k-1] == ch1[j-1]) f[i][j][k][l] |= f[i][j - 1][k + 1][l];
                                }
                                if (f[i][j][k][l]) res = Math.max(res, x + y);
                            }
                        }
                    }
                }
                System.out.println(res);
            }
        }
    }
}

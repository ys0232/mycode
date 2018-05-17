package DynamicProgrammingDemo;


import java.util.Arrays;

public class LCS {
    public static void main(String[] args) {
        String s = "abghdcv";
        String t = "bghdv";
        char[][] b = new char[s.length() + 1][t.length() + 1];
        int[][] c = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i < c.length; i++) {
            for (int j = 1; j < c[0].length; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = '0';
                } else if (c[i][j - 1] > c[i - 1][j]) {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = '1';
                } else {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = '2';
                }
            }
        }
        for (int i = 0; i < c.length; i++) {
            System.out.println(Arrays.toString(c[i]));
            // System.out.println("####"+Arrays.toString(b[i])+"####");
        }
        for (int i = 0; i < c.length; i++) {
            // System.out.println(Arrays.toString(c[i]));
            System.out.println("####" + Arrays.toString(b[i]) + "####");
        }
        String res = "";
        int j = b[0].length - 1;
        for (int i = b.length - 1; i > 0; i--) {
            if (b[i][j] == '0') {
                res = s.charAt(i - 1) + res;
                j--;
            } else if (b[i][j] == '1') {
                while (j > 0 && b[i][j] == '1') {
                    j--;
                }
                if (j >0 && b[i][j] == '0') {
                    res = s.charAt(i - 1) + res;
                    j--;
                }
            } else {
                while (i >= 0 && b[i][j] == '2') {
                    i--;
                }
                if (i >= 0 && b[i][j] == '0') {
                    res = s.charAt(i - 1) + res;
                    j--;
                }
            }
        }
        System.out.println(res);
    }
}

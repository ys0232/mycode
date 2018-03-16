package Tencent;

import java.util.Scanner;

/**
 * Created by yolin on 2018/3/15.
 */
public class MaxPalindrome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while (sc.hasNext()){
            String str=sc.next();
            System.out.println(palindrome(str));
        }
    }

    private static int palindrome(String str) {
        if (str == null || str.length() <= 1) return 0;
        char[] ch1 = str.toCharArray();
        char[] ch2 = new char[ch1.length];
        int k = ch1.length - 1;
        for (char ch : ch1) {
            ch2[k--] = ch;
        }
        k = ch1.length;
        int[][] maxLen = new int[k + 1][k + 1];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= k; j++) {
                if (ch1[i - 1] == ch2[j - 1]) {
                    maxLen[i][j] = maxLen[i - 1][j - 1] + 1;
                } else maxLen[i][j] = Math.max(maxLen[i - 1][j], maxLen[i][j - 1]);
            }
        }
        return k - maxLen[k][k];
    }
}

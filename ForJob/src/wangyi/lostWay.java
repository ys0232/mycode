package wangyi;

import java.util.Scanner;

public class lostWay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String str = sc.next();
            char[] ch = str.toCharArray();
            char p = 'N';
            for (int i = 0; i < n; i++) {
                switch (p) {
                    case 'N':
                        if (ch[i] == 'L') {
                            p = 'W';
                        } else if (ch[i] == 'R') {
                            p = 'E';
                        }
                        break;
                    case 'W':
                        if (ch[i] == 'L') {
                            p = 'S';
                        } else if (ch[i] == 'R') {
                            p = 'N';
                        }
                        break;
                    case 'S':
                        if (ch[i] == 'L') {
                            p = 'E';
                        } else if (ch[i] == 'R') {
                            p = 'W';
                        }
                        break;
                    case 'E':
                        if (ch[i] == 'L') {
                            p = 'N';
                        } else if (ch[i] == 'R') {
                            p = 'S';
                        }
                        break;
                }
            }
            System.out.println(p);
        }
    }
}

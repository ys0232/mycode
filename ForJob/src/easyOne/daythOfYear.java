package easyOne;

import java.util.Scanner;

/**
 * Created by yolin on 2018/3/10.
 */
public class daythOfYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
                int year = sc.nextInt();
                int month = sc.nextInt();
                int day = sc.nextInt();
            System.out.println(dayth(year, month, day));
        }
    }

    private static int dayth(int year, int month, int day) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            days[1] += 1;
        }
        if (month > 12 || day > days[month - 1]) return 0;
        int res = 0;
        int m = 0;
        while (m < month - 1) {
            res += days[m++];
        }
        return res + day;

    }
}

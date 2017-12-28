package tenDaysOfStatistics;
import java.util.*;

public class day1Quartile {

	private static int median(int[] a, int start, int length) {
        if (length % 2 == 0) {
            int half_length = length / 2;
            return (a[start + half_length] + a[start + half_length - 1]) / 2;
        }
        return a[start + length / 2];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(a);
        System.out.println(median(a, 0, a.length / 2));
        System.out.println(median(a, 0, a.length));
        System.out.println(median(a, a.length / 2, a.length / 2));
    }
}

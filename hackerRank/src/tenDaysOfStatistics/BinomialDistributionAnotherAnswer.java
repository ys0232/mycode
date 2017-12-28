package tenDaysOfStatistics;
//import java.io.*;
import java.util.*;

public class BinomialDistributionAnotherAnswer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double M = sc.nextDouble();
        double F = sc.nextDouble();
        sc.close();
        double pM = M / (M+F);
        double pF = F / (M+F);
        double p3M = 0;
        for (int i = 0; i < (1<<6); i++) {
            int boys = 0;
            double p = 1;
            for (int j = 0; j < 6; j++) {
                boolean isBoy = (i & (1<<j)) != 0;
                p *= isBoy ? pM : pF;
                if (isBoy) boys++;
            }
            if (boys >= 3) {
                p3M += p;
            }
        }
        System.out.println(Math.round(1000 * p3M) / 1000d);
    }
}
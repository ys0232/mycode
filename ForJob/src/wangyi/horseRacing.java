package wangyi;


import java.util.Scanner;

public class horseRacing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            double sum =0;
            for (int j = 1; j <=n; j++) {
                double t=j;
               sum+=1.0/t;
            }

            System.out.println(String.format("%.4f", sum));
        }
    }
}

package CodeM;

import java.util.Scanner;

public class pourWater_2017A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int T0 = sc.nextInt();
        int C0 = sc.nextInt();
        int[][] water = new int[n][2];
        int minT = Integer.MAX_VALUE;
        int maxT = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            water[i][0] = sc.nextInt();
            water[i][1] = sc.nextInt();
            if (water[i][0] > maxT) {
                maxT = water[i][0];
            }
            if (water[i][0] < minT) {
                minT = water[i][0];
            }
        }
        if (minT <= T0 && maxT >= T0) {
            if (minT == maxT)
                System.out.println("Possible\n" + String.format("%.4f", (float) minT));
            else System.out.println("Impossible");
        } else {
            //System.out.println("Possible");
            if (T0 < minT) {
                double sum = 0;
                for (int i = 0; i < n; i++) {
                    if (water[i][0] > minT) {
                        sum += water[i][1] * (double)(water[i][0] - minT) / (minT - T0);
                    }
                    if (sum > C0) break;
                }
                if (sum > C0) {
                    System.out.println("Impossible");
                } else {
                    System.out.println("Possible\n" + String.format("%.4f", (double) minT));
                }
            } else {
                double sum = 0;
                double sut = 0;
                double suc = 0;
                for (int i = 0; i < n; i++) {
                    sut += water[i][0] * water[i][1];
                    suc += water[i][1];
                    if (water[i][0] < maxT) {
                        sum += water[i][1] * (double)(water[i][0] - minT) / (minT - T0);
                    }
                    if (sum > C0) break;
                }
                if (sum > C0) {
                    System.out.println("Impossible");
                } else if (sum == C0) {
                    System.out.println("Possible\n" + String.format("%.4f", (double) maxT));
                } else {
                    double res = (sut + (double) T0 * C0) / (suc + C0);
                    //将所有杯子中的水看成是一个杯子，将缸看成是另外一个杯子，
                    // 求将缸里的水导入杯子后，杯子里水的温度
                    System.out.println("Possible\n" + String.format("%.4f", res));
                }
            }
        }

    }
}

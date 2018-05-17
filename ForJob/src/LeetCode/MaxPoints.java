package LeetCode;

import java.util.HashMap;

/**
 * Created by yolin on 2018/3/14.
 */

public class MaxPoints {
    private static int maxPoints(Point[] points) {
        if (points.length <= 2) return points.length;
        int res = 0;
        for (int i = 0; i < points.length - 1; i++) {
            HashMap<Double, Integer> slope_count = new HashMap<>();
            int maxcount=1;
            int theSame = 0;
            for (int j = i + 1; j < points.length; j++) {
                double slope;
                int x=points[i].x - points[j].x;
                int y=points[i].y -points[j].y;
                if (x==0 && y==0){
                    theSame++;
                }else if (x==0 && y!=0){
                    slope=Integer.MAX_VALUE;
                    if (slope_count.containsKey(slope)) {
                        int count = slope_count.get(slope);
                        slope_count.put(slope, count + 1);
                    } else slope_count.put(slope, 2);
                }else {
                    slope =1.0* y / x;
                    if (y==0)
                        slope=0;
                    if (slope_count.containsKey(slope)) {
                        int count = slope_count.get(slope);
                        slope_count.put(slope, count + 1);
                    } else slope_count.put(slope, 2);
                }
            }
            System.out.println(res+"\t"+slope_count+"\t"+theSame);
            for (double it : slope_count.keySet()) {
                if (maxcount < slope_count.get(it)) {
                    maxcount=slope_count.get(it);
                }
            }
            if (maxcount+theSame>res)
                res=maxcount+theSame;
        }

        return res;
    }

    public static void main(String[] args) {
        //[(84,250),(0,0),(1,0),(0,-70),(0,-70),(1,-1),(21,10),(42,90),(-42,-230)]

        Point p1 = new Point(84,250);
        Point p2 = new Point(0, 0);
        Point p3 = new Point(1, 0);
        Point p4 = new Point(0,-70);
        Point p5 = new Point(0,-70);
        Point p6 = new Point(1, -1);
        Point p7 = new Point(21, 10);
        Point p8 = new Point(42, 90);
        Point p9 = new Point(-42, -230);
        Point p0 = new Point(21, 10);
        Point p10 = new Point(42, 10);
        Point p12 = new Point(-42, 10);

        Point[] p = {p1, p2, p3,p4, p5, p6,p7, p8, p9};
        Point[] pk={p0,p10,p12};
        System.out.println(maxPoints(pk));
    }
}

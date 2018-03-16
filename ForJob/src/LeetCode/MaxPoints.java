package LeetCode;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by yolin on 2018/3/14.
 */

public class MaxPoints {
    private static int maxPoints(Point[] points){
        if (points.length<=1)return points.length;
        HashMap<String,Integer> max=new HashMap<>();
        for (int i=0;i<points.length;i++){
            String  x=points[i].x+"_x";
            String  y=points[i].y+"_y";
            if (max.containsKey(x)){
                int t=max.get(x)+1;
                max.put(x,t);
            }else {
                max.put(x,1);
            }
            if (max.containsKey(y)){
                int t=max.get(y)+1;
                max.put(y,t);
            }else {
             max.put(y,1);
            }
            String k="";
            if (points[i].y!=0 ) {
                 k = points[i].x / points[i].y + "_k";
            }else {
                 k =points[i].x+"_k";
                 if (points[i].x==0)
                     k=Integer.valueOf(1)+"_k";
            }
            if (max.containsKey(k)){
                int t=max.get(k)+1;
                max.put(k,t);
            }else {
                max.put(k,1);
            }
        }
        System.out.println(max.toString());
        int res=0;
       for (String it:max.keySet()){
           if (res<max.get(it)){
            res=max.get(it);
           }
       }
        return res;
    }
    public static void main(String [] args){
        Point p1=new Point(0,0);
        Point p2=new Point(0,0);
        Point p3=new Point(2,7);
        Point[] p={p1,p2,p3};
        System.out.println(maxPoints(p));
    }
}

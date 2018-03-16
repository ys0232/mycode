package toutiao;

import java.util.*;

/**
 * Created by yolin on 2018/3/15.
 */
class point{
    long a;long b;
    public point(long a,long b){
        this.a=a;this.b=b;
    }
}

public class maxPoints {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
         int n=sc.nextInt();
        ArrayList<point> res=new ArrayList<>();
         long[] maxX=new long[2];
         long[] maxY=new long[2];
         int k=0;
         while (n-->0){
             long a=sc.nextLong();
             long b=sc.nextLong();
             if (a>maxX[0]){
              maxX[0]=a;
              maxX[1]=b;
             }
             if (b>maxY[0]){
                 maxY[0]=b;
                 maxY[1]=a;
             }
             point p=new point(a,b);
                 res.add(p);


         }
       //  int len= res.size();
            Collections.sort(res, new Comparator<point>() {
                @Override
                public int compare(point o1, point o2) {
                    if (o1.a>o2.a)
                        return 1;
                    else if (o1.a<o2.a)
                        return -1;
                    else if (o1.b>o2.b)
                        return 1;
                    else if (o1.b<o2.b)
                        return -1;
                    else return 0;
                }
            });
         int i;
            for (i=0;i<res.size();i++)
                System.out.println(res.get(i).a+"\t"+res.get(i).b);
          i=res.size()-2;
            while (i>=0){
                point p1=res.get(i);
                if (p1.a>=maxY[1] && p1.a<= maxX[0] && p1.b>maxX[1]){
                    maxX[1]=p1.b;
                    maxX[0]=p1.a;
                }else res.remove(p1);
                i--;
            }

            System.out.println(Arrays.toString(maxX)+" "+Arrays.toString(maxY));


         for (i=0;i<res.size();i++)
         System.out.println(res.get(i).a+"\t"+res.get(i).b);
        }

    }
}

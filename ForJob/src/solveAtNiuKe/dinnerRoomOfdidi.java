package solveAtNiuKe;

import java.util.*;

/**
 * Created by yolin on 2018/3/8.
 */
class booking{
    int b;int c;
    public booking(int b,int c){
       this.b=b;this.c=c;
    }
}

public class dinnerRoomOfdidi {
    public static void main(String [] args){
        // 不可以拼桌 ===》 使用贪心算法
        Scanner sc=new Scanner(System.in);
        int n=0;
        int m=0;
        while (sc.hasNext() ){
            n=sc.nextInt();
            m=sc.nextInt();
            int max=0;
            int[] desk=new int[n];
            for (int i=0;i<n;i++){
                desk[i]=sc.nextInt();
                if (desk[i]>max){
                    max=desk[i];
                }
            }
            ArrayList<booking> bookings=new ArrayList<>();
            int k=0;
            while (m-->0){
            int b=sc.nextInt();
            int c=sc.nextInt();
            if (max>=b){
           bookings.add(new booking(b,c));
            }
            }

           Collections.sort(bookings, new Comparator<booking>() {
               @Override
               public int compare(booking o1, booking o2) {
                   return o2.c-o1.c;
               }
           });
            long sum=0;

            Arrays.sort(desk);
//            for (int i=0;i<bookings.size();i++){
//                System.out.println(bookings.get(i).b+"\t"+bookings.get(i).c);
//            }
            for (int i=0;i<bookings.size();i++){
                int j;
                for (j=0;j<desk.length;j++){
                if (bookings.get(i).b<=desk[j]){
                    desk[j]=0;
                    break;
                }
                }
                if (j<desk.length && desk[j]==0)
                sum+=bookings.get(i).c;
              //  System.out.println(Arrays.toString(desk)+"\t"+bookings.get(i).b);
            }
            System.out.println(sum);
        }
    }
}

package CodeM;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

class traffic{
    int x,y,c;
    String ts,td;

    public traffic(int x, int y, int c, String ts, String td) {
        this.x = x;
        this.y = y;
        this.c = c;
        this.ts = ts;
        this.td = td;
    }
}
public class yourCity {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();int m=sc.nextInt();
        traffic[] train=new traffic[m];
        for (int i=0;i<m;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            int c=sc.nextInt();
            String ts=sc.next();
            String td=sc.next();
            train[i]=new traffic(x,y,c,ts,td);

        }
        Arrays.sort(train, new Comparator<traffic>() {
            @Override
            public int compare(traffic traffic, traffic t1) {
                return traffic.ts.compareTo(t1.ts);
            }
        });



    }
    private static int dfs(traffic[] train,int cost,int cur,int next,int n,int index,int ways,String st,String et){
        if (cur==n){
            return cost;
        }
        for (int i=index+1;i<train.length;i++){
            if (ways==0&&et.compareTo(train[i].ts)<=0&&cur==train[i].x){
                ways=1;next=train[i].y;
                cost+=train[i].c;
                st=train[i].ts;
                dfs(train,cost,cur,next,n,i+1,ways,st,et);
            }
            if (ways==1&&cur==train[i].x&&next==train[i].y&&st.compareTo(train[i].ts)<=0){
                ways=1;
            }
        }
return cost;
    }
}

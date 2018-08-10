package CodeM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class landscapePlan_2017B {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        int[][] landscape=new int[n+1][3];
        for (int i=1;i<n+1;i++){
            landscape[i][0]=sc.nextInt();
            landscape[i][1]=sc.nextInt();
            landscape[i][2]=sc.nextInt();
        }
        HashMap<String,Integer> road=new HashMap<>(128);
        for (int i=0;i<m;i++){
            int x=sc.nextInt();
            int y=sc.nextInt();
            int t=sc.nextInt();
            road.put(String.valueOf(x+"_"+y),t);
        }
        double[] res=new double[2];
        int cnt=0;
        ArrayList<Integer> vis=new ArrayList<>();
        for (int i=1;i<n;i++){
            if (vis.contains(i))continue;
            int time=landscape[i][0];
            if (time>k)continue;
            cnt+=1;
            int male=landscape[i][1];
            int female=landscape[i][2];
            for (int j=i+1;j<=n;j++){
                String str=i+"_"+j;
                if (road.containsKey(str)){
                    time+=road.get(str);
                    time+=landscape[j][0];
                    if (time>k)break;
                    male+=landscape[j][1];
                    female+=landscape[j][2];
                }
            }

        }

    }
}

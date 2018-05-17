package alibaba;

import java.util.Scanner;

public class t2 {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int node=sc.nextInt();
            int edge=sc.nextInt();
            int line=sc.nextInt();
            int[][] a=new int[node][node];
            for (int i=0;i<edge;i++){
                int in=sc.nextInt();
                int out=sc.nextInt();
                a[in][out]=1;
            }
            int max=0;int start=-1;
            for (int i=0;i<node;i++){
                int t=0;
                for (int j=0;j<node;j++){
                    if (a[i][j]!=0){
                        t++;
                    }
                }
                if (t>max){
                    max=t;
                    start=i;
                }
            }
            int res=dfs(a,start,0);
            System.out.println(res);
        }
    }

   private static int dfs(int[][]a,int i,int cur){

        for (int pos=0;pos<a.length;pos++){
            if (a[i][pos]!=0){
                cur=dfs(a,pos,cur+1);
            }
        }
        return cur;
   }
}

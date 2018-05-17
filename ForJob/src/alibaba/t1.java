package alibaba;

import java.util.Scanner;

public class t1 {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int row=sc.nextInt();
            int col=sc.nextInt();
            int[][] a=new int[row][col];
            for (int i=0;i<row;i++){
                for (int j=0;j<col;j++)
                    a[i][j]=sc.nextInt();
            }
            int min=Integer.MAX_VALUE,max=0;
           for (int i=0;i<a.length;i++){
               for (int j=0;j<a[0].length;j++){
                   if (a[i][j]!=0){
                       int cur=dfs(a,i,j,0);
                       if (cur>max){
                           max=cur;
                       }
                       if (cur<min){
                           min=cur;
                       }
                   }
               }
           }
            System.out.println(max+"\n"+min);
        }
    }
    private static int dfs(int[][] a,int cur_i,int cur_j,int cur){
        cur+=a[cur_i][cur_j];
        a[cur_i][cur_j]=0;
        int[] dir={-1,0,1};
        for (int i=0;i<dir.length;i++){
            for (int j=0;j<dir.length;j++){
                int pos_i=cur_i+dir[i];
                int pos_j=cur_j+dir[j];
                if (pos_i>=0 && pos_i<a.length && pos_j>=0 &&
                        pos_j<a[0].length && a[pos_i][pos_j]!=0){
                    cur=dfs(a,pos_i,pos_j,cur);
                }
            }
        }
        return cur;
    }
}

package testForJob;
import java.util.ArrayList;
import java.util.Scanner;


public class Treasure {

    public static void main(String[] args){
        // find the min path ,and get the max len. need
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int N=sc.nextInt();
            int M=sc.nextInt();
            int[] dist=new int[N*(N+1)/2];
            for (int i=0;i<M;i++){
                int x=sc.nextInt();
                int y=sc.nextInt();
                int len=sc.nextInt();
                x-=1;y-=1;
                if (x>y){
                    int t=x;x=y;y=t;
                }
                dist[x*(2*N-x+1)/2+y-x]=len;
                //dist[y-1][x-1]=len;
            }
            int[] minDist=new int[N];
            int[] path=new int[N];
            for (int i=1;i<N;i++) {
                if (dist[i] == 0)
                    minDist[i] = Integer.MAX_VALUE;
                else {
                    minDist[i] = dist[i];
                    path[i]=0;
                }
            }
            ArrayList<Integer> vector=new ArrayList<>();
            vector.add(0);
            while (vector.size()<N){
                int min= Integer.MAX_VALUE;
                int index=-1;
                for (int j=1;j<N;j++){
                    // find the min
                    if (!vector.contains(j) && min>minDist[j]){
                       min=minDist[j];
                       index=j;
                    }
                }
                vector.add(index);
                for (int k=1;k<N;k++){
                    int x=index,y=k;
                    if (index>k){
                        x=k;y=index;
                    }
                    if (!vector.contains(k) && dist[x*(2*N-x+1)/2+y-x]!=0
                            && minDist[k]>min+dist[x*(2*N-x+1)/2+y-x]){
                        minDist[k]=min+dist[x*(2*N-x+1)/2+y-x];
                        path[k]=index;
                    }
                }
            }
            int minLen=Integer.MIN_VALUE;
            for (int index:vector){
                int x=index,y=path[index];
                if (index>path[index]){
                    x=path[index];y=index;
                }
                if (path[index]!=0 && minLen<dist[x*(2*N-x+1)/2+y-x]){
                    minLen=dist[x*(2*N-x+1)/2+y-x];
                }
            }
            System.out.println(minLen);
        }
    }
}

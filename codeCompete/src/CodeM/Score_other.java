package CodeM;

import java.util.Arrays;
import java.util.Scanner;

public class Score_other {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int k=sc.nextInt();
        int C=sc.nextInt();
        int[] weight=new int[m];
        for (int i=0;i<m;i++){
            weight[i]=sc.nextInt();
        }
        int[][] score=new int[n][m];
        int[] max_t=new int[m];
        int miss_j=-1,miss_i=-1;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                max_t[j]=max_t[j]==0?1:max_t[j];
                score[i][j]=sc.nextInt();
                if (max_t[j]<score[i][j]){
                    max_t[j]=score[i][j];
                }
                if (score[i][j]==-1){
                    miss_j=j;miss_i=i;
                    score[i][j]=0;
                }
            }
        }
        sc.close();
        float[] mark=new float[n];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                mark[i]+=(float)score[i][j]/max_t[j]*weight[j];
            }
        }
        float[] use2=mark.clone();
        Arrays.sort(mark);
       // System.out.println(Arrays.toString(mark));
        float tag=mark[n-k];
        //System.out.println(Arrays.toString(use2)+"\t"+tag);

        if (use2[miss_i]>=tag){
            // the lower is greater than tag
           judge(mark,use2,n,k,tag);
        }else {
            //use the best score to judge
            if (max_t[miss_j]<C){
                max_t[miss_j]=C;
            }
            score[miss_i][miss_j]=C;
            mark=new float[n];
            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    mark[i]+=(float)score[i][j]/max_t[j]*weight[j];
                }
            }
            use2=mark.clone();
            Arrays.sort(mark);
            //System.out.println(Arrays.toString(mark));
            tag=mark[n-k];
            //System.out.println(Arrays.toString(use2)+"\t"+tag);
            if (use2[miss_i]<tag){
                judge(mark,use2,n,k,tag);
            }else {
                  for (int i=0;i<n;i++){
                    if (use2[i]==mark[n-k-1] || i==miss_i){
                        System.out.println("3");
                    }else if (use2[i]<tag)
                        System.out.println("2");
                    else if (use2[i]>tag){
                        System.out.println("1");
                    }else System.out.println("1");
                }
            }

        }

    }
    private static void judge(float[] mark,float[] use2,int n,int k,float tag){
        boolean flag=false;
        if (tag==mark[n-k-1]){
            flag=true;
        }
        for (int i=0;i<n;i++){
            if (use2[i]>tag){
                System.out.println("1");
            }else if (use2[i]<tag)
                System.out.println("2");
            else if (flag&&use2[i]==tag){
                System.out.println("3");
            }else System.out.println("1");
        }
    }
}

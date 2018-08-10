package CodeM;


import java.util.Arrays;
import java.util.Scanner;

public class Score {
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
        int[] max_t=new int[m];
        int[][] score=new int[n][m];
        int miss_i=-1,miss_j=-1;
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                max_t[j]=max_t[j]==0?1:max_t[j];
                score[i][j]=sc.nextInt();
                if (score[i][j]==-1){
                    miss_i=i;miss_j=j;
                }
                if (max_t[j]<score[i][j]){
                    max_t[j]=score[i][j];
                }
            }
        }

        float[] final_score=new float[n];
        for (int i=0;i<n;i+=1){
            for (int j=0;j<m;j++){
                if (score[i][j]==-1)
                    score[i][j]=0;
                final_score[i]+=((float) score[i][j]/max_t[j])*weight[j];
            }
        }
        if (max_t[miss_j]<C){
            max_t[miss_j]=C;
        }
        float miss_best=final_score[miss_i]+((float) C/max_t[miss_j])*weight[miss_j];
        float[] use2find=final_score.clone();
        Arrays.sort(final_score);
        //System.out.println(Arrays.toString(use2find));
        boolean flag=false;
        float tag=final_score[n-k];

        if (miss_best>=tag && use2find[miss_i]<tag){
            use2find[miss_i]=tag;
            flag=true;
        }
        if (final_score[n-k-1]==tag){
            flag=true;
        }
        //System.out.println(tag+"\t"+flag+"\t"+miss_best);
        for (int i=0;i<n;i++){
            if (flag){
                if (use2find[i]<tag){
                    System.out.println("2");
                }else if (use2find[i]==tag){
                    System.out.println("3");
                }else System.out.println("1");
            }else {
                if (use2find[i]<tag){
                    System.out.println("2");
                }else System.out.println("1");
            }
        }

    }
}

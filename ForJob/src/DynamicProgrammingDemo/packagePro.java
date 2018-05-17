package DynamicProgrammingDemo;

import java.util.Arrays;

public class packagePro {
    public static void main(String[] args){
        int W=20;
        int[] weight={3,5,1,1,2,3,4,7,2,4};
        int[] value={3,6,2,1,4,5,7,12,5,9};
        int[][] c=new int[weight.length+1][W+1];
        for (int i=1;i<c.length;i++){
            for (int j=1;j<W+1;j++){
                c[i][j]=c[i-1][j];
                if (j>=weight[i-1]){
                    c[i][j]=Math.max(c[i][j],c[i-1][j-weight[i-1]]+value[i-1]);
                }
            }
        }
        for (int i=0;i<c.length;i++)
            System.out.println(Arrays.toString(c[i]));
    }
}

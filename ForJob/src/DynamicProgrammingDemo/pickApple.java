package DynamicProgrammingDemo;

import java.util.Arrays;

public class pickApple {
    public static void main(String [] args){

        int[][] a={{1,4,6},{2,7,4},{5,3,4}};
        int[][] max=new int[a.length][a[0].length];
        max[0][0]=a[0][0];
        for (int i=1;i<a.length;i++)
            max[i][0]=max[i-1][0]+a[i][0];
        for (int i=1;i<a.length;i++)
            max[0][i]=max[0][i-1]+a[0][i];
        for (int i=1;i<a.length;i++){
            for (int j=1;j<a[0].length;j++){
                // only two ways to go next,one is go down a step,
                // another is go right a step .
                max[i][j]=Math.max(max[i-1][j],max[i][j-1])+a[i][j];
            }
        }
        for (int i=0;i<a.length;i++){
           System.out.println(Arrays.toString(a[i]));
        }
        System.out.println("################");
        for (int i=0;i<a.length;i++){
            System.out.println(Arrays.toString(max[i]));
        }
    }
}

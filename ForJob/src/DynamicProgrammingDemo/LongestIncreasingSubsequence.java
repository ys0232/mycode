package DynamicProgrammingDemo;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args){
        int[] a={1,2,-2,4,5,-5,6,7,-9,8};
        int[] c=new int[a.length+1];
        int[] b=new int[a.length+1];
        int max=0,index=0;
        for (int i=1;i<c.length;i++){
            c[i]=1;//b[i]=-1;
            for (int j=1;j<=i;j++){
                if ((a[i-1]-a[j-1])>0 && c[i]<c[j]+1){
                    c[i]=c[j]+1;
                   b[i]=j;
                }
            }
            if (max<c[i]){
                max=c[i];
                index=i;
            }
        }
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c)+max);

        String res="";
        while ( index>0) {
               res=a[index-1]+"\t"+res;
            //System.out.println(index+"\t"+b[index]+"\t");
               index=b[index];

        }
        System.out.println(res);
    }
}

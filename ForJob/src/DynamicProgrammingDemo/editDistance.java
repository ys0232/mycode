package DynamicProgrammingDemo;

import java.util.Arrays;

public class editDistance {
    public static void main(String[] args){
        String s="bnkmko";
        String t="nkmok";
        int[][] m=new int[s.length()+1][t.length()+1];
        for (int i=0;i<m.length;i++){
            //inital column
            m[i][0]=i;
        }
        for (int i=0;i<m[0].length;i++)
            //inital row
            m[0][i]=i;

        for (int i=1;i<m.length;i++){
            for (int j=1;j<m[0].length;j++){
                if (s.charAt(i-1)==t.charAt(j-1)){
                    m[i][j]=m[i-1][j-1];
                }else {
                    m[i][j]=Math.min(Math.min(m[i-1][j-1],m[i-1][j]),m[i][j-1])+1;
                }
            }
            System.out.println(Arrays.toString(m[i]));
        }
    }
}

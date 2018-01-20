package AtOffer;

import java.util.ArrayList;

/**
 * Created by yolin on 2018/1/15.
 */
public class PrintMatrix {
    public static void main(String[] args){
        int[][] a={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> r=printMatrix(a);
        for (int i:r){
            System.out.print(i+"\t");
        }

    }
    private static ArrayList<Integer> printMatrix(int[][] matrix){
        ArrayList<Integer> result=new ArrayList<>();
        int len=matrix.length,count=len*len;
        int i=0,j=0;
        while (count>0){
            if(i==0 && j<len){
                result.add(matrix[i][j]);
                j++;
            }else if (j==len && i<len && i>0){
                result.add(matrix[i][j-1]);
                i++;
            }else if (i==len && j==len){
                result.add(matrix[i-1][j]);
                j--;
            }else if (j==0 && i>0){
                result.add(matrix[i][j-1]);
                i--;
            }

        }

        return result;
    }
}

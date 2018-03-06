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
        int row=matrix.length; int col=matrix[0].length;
        if (row==0 || col==0)return result;
        int left=0,top=0,right=col-1,bottom=row-1;
        while (left<=right && top <= bottom){
            for (int i=left;i<=right;i++) result.add(matrix[top][i]);
            for (int i=top+1;i<=bottom;i++) result.add(matrix[i][right]);
            if (top!=bottom)
                for (int i=right-1;i>=left;i--)result.add(matrix[bottom][i]);
            if (left!=right)
                for (int i=bottom-1;i>top;i--) result.add(matrix[i][left]);
            left++;top++;right--;bottom--;
        }

        return result;
    }
}

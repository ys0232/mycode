package AtOffer;

/**
 * Created by yolin on 2018/3/6.
 */
public class MovingCount {
    public static void main(String[] args){
        System.out.println(movingCount(15,20,20));

    }
    private static int movingCount(int threshold, int rows,int cols){

        int flag[][]=new int[rows][cols];
        return hepler(threshold,rows,cols,0,0,flag);
    }
    private static int hepler(int threshold,int rows,int cols,int i,int j,int[][] flag){
        if (i<0 || i>=rows || j<0 || j>=cols || numSum(i)+numSum(j)>threshold || flag[i][j]==1)return 0;
        flag[i][j]=1;
        return hepler(threshold,rows,cols,i-1,j,flag)
                +hepler(threshold,rows,cols,i+1,j,flag)
                +hepler(threshold,rows,cols,i,j-1,flag)
                +hepler(threshold,rows,cols,i,j+1,flag)+1;
    }
    private static int numSum(int i){
        int sum=0;
        while (i!=0){
            sum+=i%10;
            i/=10;
        }
        return sum;
    }

}

package ACMTest;
import java.util.*;

public class diguiMatrix {

	public static int MatrixChain(int[] A,int[][] s,int i,int j){
		int b1,b2 = 0;
		if(i==j)
			return A[i];
		else{
			 b1=MatrixChain(A,s,i,s[i][j]);
			 b1=MatrixChain(A,s,s[i][j]+1,j);
		}
		return b1*b2;
	}
	public static void main(String[] args){
		int n=6;
		int[] A={30,35,15,5,10,20,25};
		int[][] s;
		
	
	}
}

package tenDaysOfStatistics;
import java.util.*;
public class day9MultipleLinearRegression {

	private static double[][] transposed(double[][] x){
		//to get the x's transposed
		int m=x.length;
		int n=x[0].length;
		double[][] tmp=new double[n][m];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++)
				tmp[j][i]=x[i][j];
		}
		
		return tmp;
	}
	private static double[][] inverse(double[][] x){
		//to get the x's inverse
		int m=x.length;
		int n=x[0].length;
		double[][] tmp=new double[n][m];
		double A=MatrixResult(x);
		for(int i=0;i<x.length;i++){
			for(int j=0;j<x[0].length;j++){
				if((i+j)%2==0){
					tmp[i][j]=MatrixResult(getConfactor(x,i+1,j+1))/A;
				}else{
					tmp[i][j]=-MatrixResult(getConfactor(x,i+1,j+1))/A;
				}
			}
		}
		tmp=transposed(tmp);
		
		
		
		return tmp;
	}
	private static double MatrixResult(double[][] x){
		double ans=0;
		if(x.length==2){
			return x[0][0]*x[1][1]-x[0][1]*x[1][0];
		}
		int n=x.length;
		double[] nums=new double[n];
		for(int i=0;i<n;i++){
			if(i%2==0){
				nums[i]=x[0][i]*MatrixResult(getConfactor(x,1,i+1));
			}
			else{
				nums[i]=-x[0][i]*MatrixResult(getConfactor(x,1,i+1));
			}
			}
		for(int i=0;i<x.length;i++){
			ans+=nums[i];
		}
			return ans;
}

	private static double[][] getConfactor(double[][] x,int h,int v){
		int H=x.length;
		int V=x[0].length;
		double[][] newdata=new double[H-1][V-1];
		for(int i=0;i<newdata.length;i++){
			if(i<h-1){
				for(int j=0;j<newdata[i].length;j++){
					if(j<v-1){
						newdata[i][j]=x[i][j];
					}
					else{
						newdata[i][j]=x[i][j+1];
					}
				}
			}else{
				for(int j=0;j<newdata.length;j++){
					if(j<v-1){
						newdata[i][j]=x[i+1][j];
					}
					else{
						newdata[i][j]=x[i+1][j+1];
					}
				}
			}
		}
		return newdata;
	}
	private static double[][] MultipleMatrix(double[][] a,double[][] b){
		int m=a.length;
		int n=b[0].length;
		double[][] ans=new double[a.length][b[0].length];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				double tmp=0;
				for(int k=0;k<b.length;k++)
					 tmp+=a[i][k]+b[k][j];
				ans[i][j]=tmp;
			}
		}
		return ans;
		
	}	

	
	
	
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		double[][] x=new double[n][m+1];
		double[][] y=new double[n][1];
		for(int i=0;i<n;i++){
			x[i][0]=1;
			x[i][1]=sc.nextDouble();
			x[i][2]=sc.nextDouble();
			y[i][0]=sc.nextDouble();
		}
		int q=sc.nextInt();
		double[][] testx=new double[q][m+1];
		for(int i=0;i<q;i++){
			testx[i][0]=1;
			testx[i][1]=sc.nextDouble();
			testx[i][2]=sc.nextDouble();
		}
		sc.close();
		double[][] b=new double[m+1][1];
		b=inverse(MultipleMatrix(transposed(x),x));
		b=MultipleMatrix(MultipleMatrix(b,transposed(x)),y);
		for(int i=0;i<m+1;i++)
		System.out.println(Arrays.toString(b[i]));
		double[][] ans=new double[q][1];
		ans=MultipleMatrix(testx,b);
		System.out.println(Arrays.toString(ans[0]));
	}
}

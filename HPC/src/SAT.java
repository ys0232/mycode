import java.io.*;
import java.util.Arrays;

public class SAT {
	public static void main(String[] args) throws IOException{
		File test=new File("c:\\SATtest.txt");
		BufferedReader in=new BufferedReader(new InputStreamReader(new FileInputStream(test)));
		String str=null;
		String[] tmp=null;
		int line=20,row=3;
		int[][] testArr=new int[line][row];
		int k=0;
		while((str=in.readLine())!=null){
			tmp=str.split(" ");
			for(int i=0;i<row;i++){
			testArr[k][i]=Integer.parseInt(tmp[i]);
			}
			System.out.println(Arrays.toString(testArr[k]));
			k++;
		}
		in.close();
		int maxIn=0;
		int[] check=new int[line];
		for(int i=0;i<line;i++){
			for(int j=0;j<row;j++){
				if(maxIn<Math.abs(testArr[i][j]))
					maxIn=Math.abs(testArr[i][j]);
			}
		}
		maxIn+=1;
		int[] ans=new int[maxIn];
		int[] result=new int[maxIn];
		for(int i=0;i<line;i++){
			for(int j=0;j<row;j++){
				ans[Math.abs(testArr[i][j])]++;
			}
		}
		for(int i=0;i<maxIn;i++){ //三言析取式中有一项与其余项不相关时，可直接将其设为真值，从而可保证其为真值
			if(ans[i]==1){
				for(int j=0;j<line;j++){
					for(int p=0;p<row;p++){
						if(Math.abs(testArr[j][p])==i){
							check[j]=1;
							if(testArr[j][p]>0)
							result[Math.abs(testArr[j][p])]=1;
							else
							result[Math.abs(testArr[j][p])]=1;
						}
					}
				}
			}
			result[i]=1;
		}
		boolean flag=true;
		int count=0;
		do{
			for(int i=0;i<line;i++){
				if(check[i]!=1){
				int n=(int) (Math.random()*3);
				if(testArr[i][n]>0){
					result[Math.abs(testArr[i][n])]=1;
				}else
					result[Math.abs(testArr[i][n])]=-1;
				}
				check[i]=1;
			}
			for(int i=0;i<line;i++){
				for(int j=0;j<row;j++){
					if(testArr[i][j]*result[Math.abs(testArr[i][j])]>0){
						check[i]=1;
						break;
					}
					else
						check[i]=0;
				}
			}
			
			int l;
			for( l=0;l<line;l++){
				if(check[l]==0)
				{
					flag=true;
					break;
				}
			}
			if(l>=line && check[l-1]==1)
				flag=false;
			count++;
		}	while(flag && count<1000);
		if(count>1000)
			System.out.println("在有限时间内找不出一个正确解");
		else
		System.out.println("找到一个解："+Arrays.toString(result));
		
		
		
	}

}

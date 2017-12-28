package Implementation;
import java.util.*;
public class Encryption {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		sc.close();
		int len=s.length();
		int colums=(int)(Math.sqrt(len+1));
		int rows=(int)(Math.sqrt(len-1));
		if(colums*rows<len){
			rows=rows+1;
			if(colums*rows<len)
				colums++;
		}
		
		int k=0;
		char[][] a=new char[colums][rows];
		for(int i=0;i<colums;i++){
			for(int j=0;j<rows;j++){
				if(k<len)
			a[i][j]=s.charAt(k++);
				else
					a[i][j]=' ';
			}
		}
	for(int i=0;i<rows;i++){
		for(int j=0;j<colums;j++)
			System.out.print(a[j][i]);
		System.out.print(" ");
	}		
	System.out.println(len+" "+rows+" "+colums);
	}	
}

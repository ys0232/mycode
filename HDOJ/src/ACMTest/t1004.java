package ACMTest;

import java.util.Scanner;
public class t1004 {
	private static Scanner sc;

	public static void main(String[] args){
		sc = new Scanner(System.in);
		int num=sc.nextInt();
		char[][] str=new char[1000][16];
		int[] k=new int[1000];
		while(num!=0){ 
		int max=0;
		int index=0;
		
			for(int i=0;i<num;i++){
				k[i]=0;
			}
			for(int i=0;i<num;i++){
				str[i]=sc.next().toCharArray();
				
			}
			for(int i=0;i<num;i++){
				for(int j=0;j<num;j++){
					if(str[i].equals(str[j]))
						k[j]++;
				}
			}
			for(int i=1;i<num;i++){
				if(max<k[i]){
					max=k[i];
					index=i;
				}
			}
			System.out.println(str[index]);
		
		num=sc.nextInt();
		}
	}

}

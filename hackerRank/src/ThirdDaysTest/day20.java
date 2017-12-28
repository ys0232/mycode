package ThirdDaysTest;
import java.util.*;
import java.math.*;
public class day20 {
public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	int n=sc.nextInt();
	int[] a=new int[n];
	for(int i=0;i<n;i++)
		a[i]=sc.nextInt();
	sc.close();
	int num=0;
	for(int i=0;i<n;i++){
		int tmpNum=0;
		for(int j=0;j<n-1;j++){
			if(a[j]>a[j+1]){
				int tmp=a[j];
				a[j]=a[j+1];
				a[j+1]=tmp;
				num++;
				tmpNum++;
			}
				
		}
			if(tmpNum==0)
				break;
	}
	System.out.println(Arrays.toString(a));
	System.out.println("Array is sorted in "+num+" swaps");
	System.out.println("First Element: "+a[0]);
	System.out.println("Last Element: "+a[n-1]);
}
}

package CrackingtheCodingInterview;
import java.util.*;

public class StringsMakingAnagrams {
	private static int numberNeeded(String first,String second){
		
		int len=0;
		char[] a=first.toCharArray();
		char[] b=second.toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);
		int[] countA=new int[a.length];
		int[] countB=new int[b.length];
		char[] elementA=new char[a.length];
		char[] elementB=new char[b.length];	
		int k=0;
		elementA[0]=a[0];
		countA[0]=1;
		for(int i=0;i<a.length-1;i++){
			if(a[i]==a[i+1]){
				countA[k]++;
			}
			else{
			k++;
			elementA[k]=a[i+1];
			countA[k]=1;
			}				
		}
		 k=0;
		elementB[0]=b[0];
		countB[0]=1;
		for(int i=0;i<b.length-1;i++){
			if(b[i]==b[i+1]){
				countB[k]++;
			}
			else{
			k++;
			elementB[k]=b[i+1];
			countB[k]=1;
			}				
		}
		
		for(int i=0;i<elementA.length;i++){
			for(int j=0;j<elementB.length;j++){
				if(elementA[i]==elementB[j] && elementB[j]!='!'){
					countA[i]=Math.abs(countA[i]-countB[j]);
					elementB[j]='!';
					}		
			}
		}
		for(int i=0;i<countA.length;i++)
			len+=countA[i];
		for(int j=0;j<countB.length;j++){
			if(elementB[j]!='!')
				len+=countB[j];
		}
		return len;
	}

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String a=sc.next();
		String b=sc.next();
		sc.close();		
		System.out.println(numberNeeded(a,b));
	}
}

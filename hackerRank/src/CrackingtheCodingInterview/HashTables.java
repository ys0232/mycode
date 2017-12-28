package CrackingtheCodingInterview;
import java.util.*;
public class HashTables {

	Map<String,Integer> magazineMap;
	String[] Note;
	int[] count;
	public HashTables(String magazine,String note){
		String s=" ";
		String[] tmp=magazine.split(s);
		magazineMap=new HashMap<String,Integer>();
		 count=new int[tmp.length];
		for(int i=0;i<tmp.length;i++){
			if(magazineMap.containsKey(tmp[i])==false){
	            	magazineMap.put(tmp[i], i);
	               count[i]=1;    	
			}
			else{
				int k=magazineMap.get(tmp[i]);
				count[k]++;
			}
				
		}
		Note=note.split(s);
		//System.out.println("count: "+Arrays.toString(count)+"\n"+"Note: "+Arrays.toString(Note)+"\n"+"magazine: "+magazineMap.keySet());
		
	}
	public boolean solve(){
		boolean f=true;
		for(int i=0;i<Note.length;i++){
			if(!magazineMap.containsKey(Note[i])){
				f=false;
				break;}
			else{
				int k=magazineMap.get(Note[i]);
				count[k]--;
				if(count[k]<0){
					f=false;
					break;
					}
			}
		}
		
		return f;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		sc.nextLine();
		String maga=sc.nextLine();
		String noteStr=sc.nextLine();
		HashTables s=new HashTables(maga,noteStr);
		sc.close();
		boolean answer=s.solve();
		if(answer)
			System.out.println("Yes");
		else 
			System.out.println("No");
		int l=Integer.MIN_VALUE;
		
	}
}

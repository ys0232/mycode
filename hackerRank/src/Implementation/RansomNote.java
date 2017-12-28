package Implementation;
import java.util.*;
public class RansomNote {
	    Map<String,Integer> magazineMap;
		Map<String,Integer> noteMap;
		static String[] maga;
		static String[] Note;
	    
	public RansomNote(String magazine,String note){
		 magazineMap=new HashMap<String,Integer>();
			noteMap=new HashMap<String,Integer>();
			
			String s=" ";
			String[] maga=magazine.split(s);
			String[] Note=note.split(s);
			for(int i=0;i<maga.length;i++)
			magazineMap.put(maga[i],i);
			for(int i=0;i<Note.length;i++){
				noteMap.put(Note[i],i);
			}
			System.out.println("maga: "+Arrays.toString(maga)+" note: "+Arrays.toString(Note));
			
	    }
	 public boolean solve() {
	 boolean f=true;
		for(int i=0;noteMap.get(i)!=null;i++){
			if(magazineMap.containsValue(noteMap.get(i))==false){
				f=false;
				break;
			}
			
		}
			
		return f;
}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		 int n=sc.nextInt();
		sc.nextLine();
		String s1=sc.nextLine();
		String s2=sc.nextLine();
		RansomNote s=new RansomNote(s1,s2);
		String sp=" ";
		String[] s1a=s1.split(sp);
		String[] s2a=s2.split(sp);
		System.out.println("s1:"+Arrays.toString(s1a)+"\n"+"s2:"+Arrays.toString(s2a));
		sc.close();
		boolean answer=s.solve();
		if(answer){
			System.out.println("Yes");
		}
		else
			System.out.println("No");
	}
}

package CrackingtheCodingInterview;
import java.util.*;
public class TriesContacts {

	static ArrayList<String> s=new ArrayList<>();
	private static int findPartial(String str){
		int count=0;
	    for(int i=0;i<s.size();i++){
	    	int c=s.get(i).compareTo(str);
	    	//System.out.println(s.get(i));
	    	if(c>=0)
	    		count++;
	    }
		return count;
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		//Set<String> s=new HashSet<>();
		for(int i=0;i<n;i++){
			String op=sc.next();
			String contact=sc.next();
			int k;
			if(op.equals("add"))
				k=1;
			else
				k=2;
			switch(k){
			case 1:s.add(contact);break;
			case 2:System.out.print(findPartial(contact)+"  ");
			break;
			}
		}
		
		sc.close();
	}
	
}

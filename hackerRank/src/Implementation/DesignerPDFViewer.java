package Implementation;
import java.util.*;
public class DesignerPDFViewer {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		int n=26;
		int[] h=new int[n];
		for(int i=0;i<n;i++){
			h[i]=sc.nextInt();
			map.put((char) ('a'+i), h[i]);
		}
		String word=sc.next();
		sc.close();
		char[] w=word.toCharArray();
		int max=0;
		for(int i=0;i<w.length;i++){
			if(map.get(w[i])>max)
				max=map.get(w[i]);
		}
		int area=w.length*max;
		System.out.println(area);
	}
}

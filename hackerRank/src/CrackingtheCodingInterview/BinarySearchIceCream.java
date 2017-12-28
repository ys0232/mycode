package CrackingtheCodingInterview;
import java.util.*;

class IceCream implements Comparable<Object>{
	
	int flavor;
	int index;
	public IceCream(int flavor,int index){
		this.flavor=flavor;
		this.index=index;
		
	}
	
	public int compareTo(IceCream o){
		return (int)(this.flavor-o.flavor);
	}
	public boolean equals(Object o){
		return (this.flavor==(int)o)?true:false;
	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return (int)(this.flavor-(int)o);
	}
}
public class BinarySearchIceCream {

	public static int binarySearch(int first,int last,IceCream[] arr,int search){
		 if(first<=last){
		        int mid=(int)(first+last)/2;
		        if(arr[mid].equals(search)) return arr[mid].index;
		        if(arr[mid].compareTo(search)>0){
		            return binarySearch(first,mid-1,arr,search);
		        }
		        else return binarySearch(mid+1,last,arr,search);
		        }
		        else if(first==last && arr[first].equals(search)) return arr[first].index;
		        else return -1;
	}

	public static void main(String[] args){
		int t;int n,m;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		while(t-->0){
		m=sc.nextInt();
		n=sc.nextInt();
		IceCream[] arr=new IceCream[n];
		
		for(int i=0;i<n;i++){
			arr[i]=new IceCream(sc.nextInt(),sc.nextInt());
			
		}
		Arrays.sort(arr);
		int firstIndex=100000;
		int secondIndex=100000;
		for(int i=0;i<n-1;i++){
			int search=m-arr[i].flavor;
			if(search>=arr[i].flavor){
				int index=binarySearch(i+1,n-1,arr,search);
				if(index!=-1){
					System.out.println(Math.min(arr[i].index, index)+" "+Math.max(arr[i].index, index));
				}
			}
		}
				
	}
		sc.close();
}
	}

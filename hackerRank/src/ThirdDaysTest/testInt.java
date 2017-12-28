package ThirdDaysTest;

public class testInt {
	static boolean test(int[] a){
		for(int i=0;i<a.length;i++)
		if(a[i]!=0)
			return true;
		 return false;
	}
public static void main(String[] args){
	int[] a={123,454,6,6,8,9};
	if(test(a))
		System.out.print("true");
}
}

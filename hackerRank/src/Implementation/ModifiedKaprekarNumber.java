package Implementation; 
import java.math.BigInteger;
import java.util.*;

public class ModifiedKaprekarNumber {

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int p=sc.nextInt();
		int q=sc.nextInt();
		sc.close();
		boolean flag=false;
		for(int i=p;i<=q;i++){
			String tmp;
			
			if(i<=9999){
			 tmp=String.valueOf(i*i);
		
			    }
			    
			    else
			    {
			    	tmp=String.valueOf(i);
			    	BigInteger a=new BigInteger(tmp);
			    	BigInteger b=a.multiply(a);
			        tmp=b.toString();
			    
			    }
			int d=tmp.length();
	        String r=tmp.substring(d/2);
			
			int right=Integer.parseInt(r);
			int left;
			String l;
			if(d/2<1)
				l=String.valueOf(0);
			else
				
				l=tmp.substring(0,d/2);
			    left=Integer.parseInt(l);
			    if(right+left==i){
					flag=true;
					System.out.print(i+" ");
				}	
			//System.out.println(tmp+"   "+l+"  "+r);
			
		}
		if(flag==false)
			System.out.println("INVALID RANGE");
	}
}

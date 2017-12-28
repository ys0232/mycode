package one;

import java.math.BigInteger;

public class testing89 {

	public static void main(String[] args){
		 BigInteger i=new BigInteger(99999);
		BigInteger t=new BigInteger(i*i);
		System.out.println(t);
		String tmp=String.valueOf(t);
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
		    System.out.println(left+"  "+right+"  "+(right+left));
	}
}

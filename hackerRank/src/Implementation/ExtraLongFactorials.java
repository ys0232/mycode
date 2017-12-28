package Implementation;
import java.math.BigInteger;
import java.util.*;

public class ExtraLongFactorials {

	
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
	    BigInteger nfact=new BigInteger(""+n);
	    while(n-->1){
	    	nfact=nfact.multiply(new BigInteger(""+n));
	    }
	    System.out.println(nfact);
	    
	}
}

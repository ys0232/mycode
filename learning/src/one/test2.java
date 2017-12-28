package one;
import java.util.*;
import java.math.*;
import java.text.*;
public class test2 {
public static void main(String[] args){
	double d=1;
	int n=6;
	DecimalFormat df=new DecimalFormat("#0.000000");
	String s="932ser";
	System.out.println((s.charAt(0)-48)*10);
	char c1=s.charAt(0);
	char c2=s.charAt(1);
	n=s.charAt(0)+12;
	System.out.println(df.format(d/(double)n));
}
}

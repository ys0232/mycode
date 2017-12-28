package ACMTest;
import java.io.*;
import java.util.*;
public class t1000 {
public static void main(String[] args){
	long a;
	long b;
	Scanner sc=new Scanner(System.in);
	while(sc.hasNext()){
		a=sc.nextLong();
		b=sc.nextLong();
		System.out.println(a+b);
	}
	sc.close();
}
}

package ThirdDaysTest;
import java.util.*;
import java.io.*;
public class day18 {
	Stack<Character> st;
	Queue<Character> qu;
   void pushCharacter(char c){
	   try{
	   st.push(c);}
	   catch(NullPointerException e){
		   st=new Stack<Character>();
		   st.push(c);
	   }
   }
   void enqueueCharacter(char c){
	   try{
		   qu.add(c);}
		   catch(NullPointerException e){
			   qu=new LinkedList<Character>();
			   qu.add(c);
		   }
	  
   }
   char popCharacter(){
	   return (char) st.pop();
   }
   char dequeueCharacter(){
	   return (char) qu.remove();
   }
public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	String input=sc.nextLine();
	sc.close();
	char[] s=input.toCharArray();
	day18 p=new day18();
	for(char c:s){
		p.pushCharacter(c);
		p.enqueueCharacter(c);
	}
	boolean isPalindrome=true;
	for(int i=0;i<s.length/2;i++){
		if(p.popCharacter()!=p.dequeueCharacter()){
			isPalindrome=false;
			break;
		}
	}
	System.out.println("The Word, "+input+", is "+((!isPalindrome)?"not a Palindrome":"a Palindrome"));
}
}

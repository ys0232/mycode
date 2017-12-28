package CrackingtheCodingInterview;
import java.util.*;
public class StacksBalancedBrackets {
	
	public static boolean isBalanced(String expression){
		
		Stack<Character> st=new Stack<>();
		for(int i=0;i<expression.length();i++){
			char ch=expression.charAt(i);
			if(ch=='('|| ch=='['||ch=='{')
				st.add(ch);
			if(ch==')')
				{
				if(st.isEmpty()|| (!st.isEmpty() && st.pop()!='('))
				return false;
			}
			if(ch==']'){
				if(st.isEmpty()|| (!st.isEmpty() &&st.pop()!='['))
					return false;
			}
			if(ch=='}'){
				if(st.isEmpty() || (!st.isEmpty() && st.pop()!='{' ))
				return false;
			}
				
				
		}
		
			
		
		return st.isEmpty();
		
	}

	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int i=0;i<t;i++){
			String express=sc.next();
			System.out.println((isBalanced(express))?"YES":"NO");
			}
		sc.close();
	}
}

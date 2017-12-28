package ThirdDaysTest;

import java.util.*;

public class stackTest {
	public static void main(String[] args){
  Stack st = null;
  char[] s="rescedfer".toCharArray();
  for(char c:s)
  st.push(c);
  while(!st.isEmpty())
  System.out.println(st.pop());
}

}

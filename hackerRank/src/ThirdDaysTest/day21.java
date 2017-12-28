package ThirdDaysTest;
import java.util.*;
import java.lang.*;
public class day21 {
static void printArray(Object[] ob){
	for(int i=0;i<ob.length-1;i++){
	System.out.print(ob[i]+"");
	}
	System.out.print(ob[ob.length-1]);
}
public static void main(){
Integer[] intArray={1,2,3};
String[] stringArray={"Hello","World"};
printArray(intArray);
printArray(stringArray);
if(day21.class.getDeclaredMethods().length>2){
	System.out.println("You should only have 1 method named printArray!");
	
}

}
}


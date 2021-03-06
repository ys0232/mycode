package ThirdDaysTest;
import java.util.*;

class Person {
	protected String firstName;
	protected String lastName;
	protected int idNumber;
	
	// Constructor
	Person(String firstName, String lastName, int identification){
		this.firstName = firstName;
		this.lastName = lastName;
		this.idNumber = identification;
	}
	
	// Print person data
	public void printPerson(){
		 System.out.println(
				"Name: " + lastName + ", " + firstName 
			+ 	"\nID: " + idNumber); 
	}
	 
}
class Student extends Person{
	private int[] testScores;
    Student(String firstName,String lastName,int identification,int[] testScores){
        super(firstName,lastName,identification);
        this.testScores=testScores;
    }
    public String calculate(){
        int sum=0;
        int ave=0;
        int i=0;
        for( i=0;i<testScores.length;i++)
            sum+=testScores[i];
        ave=sum/i;
        if(ave<40)
            return "T";
        else if(ave<55)
            return "D";
            else if(ave<70)
            return "P";
            else if(ave<80)
            return "A";
            else if(ave<90)
            return "E";
            else
            return "O";
    }
   
}
public class day12 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstName = scan.next();
		String lastName = scan.next();
		int id = scan.nextInt();
		int numScores = scan.nextInt();
		int[] testScores = new int[numScores];
		for(int i = 0; i < numScores; i++){
			testScores[i] = scan.nextInt();
		}
		scan.close();
		
		Student s = new Student(firstName, lastName, id, testScores);
		s.printPerson();
		System.out.println("Grade: " + s.calculate());
	}
}
package CrackingtheCodingInterview;
import java.util.*;
class Checker implements Comparator<Player>{
	
	public int compare(Player o1,Player o2){
		if(o1.score!=o2.score)
		return o2.score-o1.score;
		else{
			int len=o1.name.length()>o2.name.length()?o2.name.length():o1.name.length();
			for(int i=0;i<len;i++)
			{
				if(o1.name.charAt(i)!=o2.name.charAt(i))
					return o1.name.charAt(i)-o2.name.charAt(i);
				
			}
		}
		return o1.name.length()>o2.name.length()?1:-1;
		}
}
class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

public class SortingComparator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
       // Stack<Integer> st=new Stack<>();


        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();
     
        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
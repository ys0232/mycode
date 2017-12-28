package work1;
import java.util.*;

public class OilTest {
public static void main(String[] args){
	LinkedList<StateNode> stateQueue=new LinkedList<StateNode>();
	ArrayList<StateNode> stateList=new ArrayList<StateNode>();
	StateNode initialState=new StateNode(10,0,0,null);
	stateQueue.addFirst(initialState);
	stateList.add(initialState);
	while(!stateQueue.isEmpty()){
		StateNode tmp=stateQueue.removeLast();
		
		for(int i=1;i<=6;i++){
			System.out.println(5);
			
			StateNode newState=tmp.expandStateNode(i);
			
			if(newState!=null){
				System.out.println(1);
				if(newState.isTarget()){
					newState.printStep();
					return;
				}
				System.out.println(1);
				boolean tag=false;
				for(int j=0;j<stateList.size();j++){
					if(newState.equals(stateList.get(j))){
						tag=true;
						break;
					}
					System.out.println(1);
					if(!tag){
						stateQueue.addFirst(newState);
						stateList.add(newState);
					}
				}
			}
		}
	}
}
}

import java.util.ArrayList;
import java.util.LinkedList;

public class PartitionOil {
    public static void main(String[] args) {
        LinkedList<StateNode> stateQueue = new LinkedList<StateNode>();
        ArrayList<StateNode> stateList = new ArrayList<StateNode>();
        StateNode initialState = new StateNode(10, 0, 0, null);
        initialState.printStep();
        stateQueue.addFirst(initialState);
        stateList.add(initialState);
        
        while (!stateQueue.isEmpty()) {
            StateNode temp = stateQueue.removeLast();

            for (int i = 1; i <= 6; i++) { 
                StateNode newState = temp.expandStateNode(i); 
                if (newState != null) {
                    if (newState.isTargetState()) { 
                        System.out.println("----------Find target!!!---------");
                        newState.printStep();
                        return;
                    }


             boolean tag = false;
             for (int j = 0; j < stateList.size(); j++) { 
                 if (newState.eqauls(stateList.get(j))) {
                     tag = true;
                     break;
                 }
             }
             if (!tag) {
                 stateQueue.addFirst(newState);
                 stateList.add(newState);
             }
         }
     }
 }
}

            }

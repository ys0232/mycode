
public class StateNode {
    int b1;
    int b2;
    int b3;
private int first=10;
    private int second=7;
    private int third=3;
    StateNode parentState; 

    public StateNode(int b1, int b2, int b3, StateNode parent) {
       this.b1=b1;
        this.b2=b2;
        this.b3=b3;
        parentState = parent;
    }

    public String toString() {
        return "[" + b1 + " " + b2 + " " + b3 + "]";
    }

    public boolean isTargetState() { 
        if (b1 == 5 && b2 == 5)
            return true;
        else
            return false;
    }

    public boolean eqauls(StateNode s) { 
        if (s.b1 == this.b1 && s.b2 == this.b2 && s.b3 == this.b3)
            return true;
        else
            return false;
    }

    public void printStep() { 
        if (parentState != null)
            parentState.printStep();

        System.out.println(toString());
    }

    public StateNode expandStateNode(int n) { 
        StateNode newState = null;
        boolean isExpand = false;

       

        switch (n) {
            case 1: 
                if (b1!=0 && b2!=second) {
                    n =second- b2<= b1 ? second-b2: b1;
                    newState = new StateNode(b1-n, b2+ n,b3, this);
                }
                break;
            case 2: 
                if (b1!=0 && b3!=third) {
                    n =third- b3<= b1 ? third-b3: b1;
                    newState = new StateNode(b1-n, b2,b3+n, this);
                }
                    break;
            case 3: 
                if (b2!=0 && b1!=first) {
                    n =first-b1<= b2 ? first-b1: b2;
                    newState = new StateNode(b1+n, b2- n,b3, this);
                }
                break;
            case 4:
                if (b2!=0 && b3!=third) {
                    n =third-b3<= b2 ?third-b3: b2;
                    newState = new StateNode(b1, b2- n,b3+n, this);
                }
                break;
            case 5: 
                if (b3!=0 && b1!=first) {
                    n =first-b1<= b3 ? first-b1: b3;
                    newState = new StateNode(b1+n, b2,b3-n, this);
                }
                break;
            case 6: 
                if (b3!=0 && b2!=second) {
                    n =second-b2<= b3 ? second-b2: b3;
                    newState = new StateNode(b1, b2+n,b3-n, this);
                }
                break;
        }

        return newState;
    }

}

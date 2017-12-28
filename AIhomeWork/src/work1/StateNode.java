package work1;

public class StateNode {

	Bottle b1;
	Bottle b2;
	Bottle b3;
	StateNode parent;
	public StateNode(int b1,int b2,int b3,StateNode p){
		this.b1=new Bottle(10,b1);
		this.b2=new Bottle(7,b2);
		this.b3=new Bottle(3,b3);
		this.parent=p;
	}
	public String toString( ){
		return "["+b1.oil+","+b2.oil+","+b3.oil+"]";
		
	}
	public boolean isTarget(){
		if(b1.oil==5 && b2.oil==5)
			return true;
		else
			return false;
	}
	public boolean equals(StateNode s){
		if(s.b1.oil==this.b1.oil && s.b2.oil==this.b2.oil &&s.b3.oil==this.b3.oil)
			return true;
		else
			return false;
	}
	public void printStep(){
		if(parent!=null)
			parent.printStep();
		System.out.println(toString());
	}
	public StateNode expandStateNode(int n){
		StateNode newState=null;
		switch(n){
		case 1:
			//∆ø1µƒ”Õµπ»Î∆ø2
			if(!b1.isEmpty() && !b2.isFull()){
			n=b2.needForFull()<=b1.oil?b2.needForFull():b1.oil;
			newState=new StateNode(b1.oil-n,b2.oil+n,b3.oil,this);}
		break;
		case 2:
			//∆ø1µƒ”Õµπ»Î∆ø3
			if(!b1.isEmpty() && !b3.isFull()){
				n=b3.needForFull()<=b1.oil?b3.needForFull():b1.oil;
				newState=new StateNode(b1.oil-n,b2.oil,b3.oil+n,this);}
			break;
		case 3:
			//∆ø2µƒ”Õµπ»Î∆ø1
			if(!b2.isEmpty() && !b1.isFull()){
				n=b1.needForFull()<=b2.oil?b1.needForFull():b2.oil;
				newState=new StateNode(b1.oil+n,b2.oil-n,b3.oil,this);}
			break;
		case 4:
			//∆ø2µƒ”Õµπ»Î∆ø3
			if(!b2.isEmpty() && !b3.isFull()){
				n=b3.needForFull()<=b2.oil?b3.needForFull():b2.oil;
				newState=new StateNode(b1.oil,b2.oil-n,b3.oil+n,this);}
			break;
		case 5:
			//∆ø3µƒ”Õµπ»Î∆ø1
			if(!b3.isEmpty() && !b1.isFull()){
				n=b1.needForFull()<=b3.oil?b1.needForFull():b3.oil;
				newState=new StateNode(b1.oil+n,b2.oil,b3.oil-n,this);}
			break;
		case 6:
			//∆ø3µƒ”Õµπ»Î∆ø2
			if(!b3.isEmpty() && !b2.isFull()){
				n=b2.needForFull()<=b3.oil?b2.needForFull():b3.oil;
				newState=new StateNode(b1.oil,b2.oil+n,b3.oil-n,this);}
			break;	
		}
		return newState;
		}
	
		
	}
	


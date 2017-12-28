package work1;

public class Bottle {

	int oil;
	int volume;
	public Bottle(int v,int o){
		if(o<volume)
		oil=o;
		volume=v;
		
	}
	public boolean isEmpty(){
		if(oil==0)
			return true;
		else
			return false;
	}
	public boolean isFull(){
		if(oil==volume)
			return true;
		else
			return false;
		}
	public int needForFull(){
		return volume-oil; 
	}
}

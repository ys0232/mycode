package homework;
import java.util.*; 

public class OilTest {

	int bottle1;
	int bottle2;
	int bottle3;
	OilTest(){
		
	}
	OilTest(int bottle1,int bottle2,int bottle3){
		this.bottle1=bottle1;
		this.bottle2=bottle2;
		this.bottle3=bottle3;
		}
		public void depthFirstSearch(OilTest oil){
			OilTest target1=new OilTest(5,5,0);
			OilTest target2=new OilTest(5,4,1);
			OilTest target3=new OilTest(5,3,2);
			OilTest target4=new OilTest(5,2,3);
		if(oil.equals(target1)||oil.equals(target2)||oil.equals(target3)||oil.equals(target4))
	          {
			outputResult();//找到目标，输出
		return;
		}
		ArrayDeque<OilTest> st=new ArrayDeque<OilTest>();
		st.push(oil);
		
		}
		public void outputResult(){
			
		}
	public static void main(String[] args){
		OilTest oil=new OilTest(10,0,0);
		
	}
}

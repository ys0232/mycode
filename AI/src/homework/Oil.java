package homework;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.io.*;
import java.math.*;

public class Oil {
	//定义Oil类
		int One;
		int Seven;
		int Third;
		Oil(){};
		Oil(int o,int s,int t){
			this.One=o;
			this.Seven=s;
			this.Third=t;
			
	}
	public static void main(String[] args){
		Oil root=new Oil(10,0,0);
		Node[] arr=new Node[50];
		Node[] result=new Node[20];
		Queue<Node> oilQueue=new LinkedBlockingQueue<Node>();
		Node rootNode=new Node(root,-1);
		oilQueue.offer(rootNode);
		Oil oil=new Oil();
		int cnt=1;//数组元素的个数
		int t=0;//队列中记录的父节点
		
		int res=0;//记录最终结果数组的位置
		int r=0;//记录结果数组的个数

		arr[0]=rootNode;
		
		//建立队列进行广度优先遍历
		while(!oilQueue.isEmpty()){
			Oil newOil=new Oil();
			Node newNode=new Node();
			oil=oilQueue.peek().o;
			if(!isCir(oilQueue.peek(),cnt,arr)){
				newNode=new Node(oilQueue.peek().o,oilQueue.peek().n);
				arr[cnt]=newNode;
				cnt++;
				t=cnt-1;
			}
			oilQueue.poll();
			System.out.print(1);

			if(oil.Seven<7){
				
				newOil.Seven=7;
				newOil.One=10-7-oil.Third;
				newOil.Third=oil.Third;
				newNode.o=newOil;
				newNode.n=t;
				if(!isCir(newNode,cnt,arr))
					oilQueue.offer(newNode);
			}
			if(oil.Seven<3){
				
				newOil.Third=3;
				newOil.One=10-3-oil.Seven;
				newOil.Seven=oil.Seven;
				newNode.o=newOil;
				newNode.n=t;
				if(!isCir(newNode,cnt,arr))
					oilQueue.offer(newNode);
			}
			//7两瓶不空时倒空
			if(oil.Seven>0){
				newOil.Seven=0;
				newOil.One=10-oil.Third;
				newOil.Third=oil.Third;
				newNode.o=newOil;
				newNode.n=t;
				if(!isCir(newNode,cnt,arr))
					oilQueue.offer(newNode);
			}
			if(oil.Third>0){
				 
				newOil.Third=0;
				newOil.One=10-oil.Seven;
				newOil.Seven=oil.Seven;
				newNode.o=newOil;
				newNode.n=t;
				if(!isCir(newNode,cnt,arr))
					oilQueue.offer(newNode);
			}
			 if(oil.Seven>0 && oil.Seven+oil.Third<=3)  
		        {  
		            
		            newOil.Seven=0;  
		            newOil.Third=oil.Seven+oil.Third;  
		            newOil.One=10-oil.Seven-oil.Third;  
		            newNode.o=newOil;  
		            newNode.n=t;  
		            if(!isCir(newNode,cnt,arr))  
		              oilQueue.offer(newNode);  
		        }  
			 if(oil.Third>0 && oil.Seven+oil.Third<=7)  
		        {  
		           
		            newOil.Third=0;  
		            newOil.Seven=oil.Seven+oil.Third;  
		            newOil.One=10-oil.Seven-oil.Third;  
		            newNode.o=newOil;  
		            newNode.n=t;  
		            if(!isCir(newNode,cnt,arr))  
		               oilQueue.offer(newNode);  
		        }  
			 if(oil.Seven<7 && oil.Seven+oil.Third>=7)  
		        {  
		            
		            newOil.Seven=7;  
		            newOil.Third=oil.Seven+oil.Third-7;  
		            newOil.One=10-oil.Seven-oil.Third;  
		            newNode.o=newOil;  
		            newNode.n=t;  
		            if(!isCir(newNode,cnt,arr))  
		               oilQueue.offer(newNode);  
		        }  
			 if(oil.Third<3 && oil.Seven+oil.Third>=3)  
		        {  
		           
		            newOil.Third=3;  
		            newOil.Seven=oil.Seven+oil.Third-3;  
		            newOil.One=10-oil.Seven-oil.Third;  
		            newNode.o=newOil;  
		            newNode.n=t;  
		            if(!isCir(newNode,cnt,arr))  
		            oilQueue.offer(newNode);  
		        
		    }  
			
		}
		for(int q=0;q<cnt;q++){
			if(arr[q].o.One==5 && arr[q].o.Third<=3){
			res=q;
			break;
			
			}
		}
		while(arr[res].n!=-1){
			result[r]=result[res];
			res=arr[res].n;
			r++;
		}
		if(arr[res].n==-1){
			result[r]=arr[res];
			res=arr[res].n;
			
		}
		for(int p=r;p>=0;p--){
			System.out.println("<"+result[p].o.One+","+result[p].o.Seven+","+result[p].o.Third+">");
		}
	}
	private static boolean isCir(Node node, int cnt, Node[] arr) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<cnt;i++)
			if(node.equals(arr[i]))
				return true;
		return false;
	}
	}





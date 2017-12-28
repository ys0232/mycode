package ThirdDaysTest;
import java.util.*;
class LinkNode{
	int data;
	LinkNode next;
	LinkNode(int d){
		data=d;
		next=null;
	}
}
public class day24 {

	public static LinkNode removeDuplicates(LinkNode head){
		
		
		LinkNode p=head;
		LinkNode pre=head;
		 
        int n=1;
		while(p!=null){
			p=p.next;
			n++;
		}
		int[] a=new int[n];
		int k=0;
        p=head;
		while(p!=null){
			boolean flag=true;
			for(int i=0;i<=k;i++){
				if(p.data==a[i])
					flag=false;				
			}
			if(flag){
				a[k++]=p.data;
				pre=p;
				p=p.next;
			}
			else{
				
				pre.next=p.next;
				p=pre.next;
				
			}
			
        }
        return head;
    }
	public static LinkNode insert(LinkNode head,int data){
		LinkNode p=new LinkNode(data);
		if(head==null)
			head=p;
		else if(head.next==null)
			head.next=p;
		else{
			LinkNode start=head;
			while(start.next!=null){
				start=start.next;
				
			}
			start.next=p;
		}
		return head;
	}
	public static void display(LinkNode head){
		LinkNode start=head;
		while(start!=null){
			System.out.print(start.data+" ");
			start=start.next;
		}
	}
	public static void main(String[] args){
	
		Scanner sc=new Scanner(System.in);
		LinkNode head=null;
		int t=sc.nextInt();
		while(t-->0){
			int data=sc.nextInt();
			head=insert(head,data);
		}
		sc.close();
		head=removeDuplicates(head);
		display(head);
	}
}

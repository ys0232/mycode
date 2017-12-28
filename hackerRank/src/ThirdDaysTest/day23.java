package ThirdDaysTest;
import java.util.*;
class TreeNode{
	TreeNode left,right;
	int data;
	TreeNode(int data){
		this.data=data;
		left=right=null;
	}
}
public class day23 {
	static void levelOrder(TreeNode root){
		LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
		if(root!=null){
			queue.add(root);
			while(!queue.isEmpty()){
				TreeNode t=queue.poll();
				System.out.print(t.data+" ");
				if(t.left!=null)
					queue.add(t.left);
				if(t.right!=null)
					queue.add(t.right);
			}
		}
	}
public static TreeNode insert(TreeNode root,int data){
	if(root==null)
		return new TreeNode(data);
	else{
		TreeNode tmp;
		if(data<=root.data){
			tmp=insert(root.left,data);
			root.left=tmp;
		}
		else{
			tmp=insert(root.right,data);
			root.right=tmp;
		}
		return root;
	}
}
public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
	int T=sc.nextInt();
	TreeNode root=null;
	while(T-->0){
		int data=sc.nextInt();
		root=insert(root,data);
	}
	levelOrder(root);
}
}

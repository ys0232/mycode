package AtOffer;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by lenovo on 2018/1/13.
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class rebuildBinTree {
    public static void main(String[] args){
    int[] pre={1,2,4,7,3,5,6,8};
    int[] in={4,7,2,1,5,3,8,6};
    TreeNode root=reConstructBinaryTree(pre,in);
    printTreeBFS(root);
    }
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
       TreeNode root=new TreeNode(pre[0]);
       TreeNode q=root;
       int temp=pre[0];
       for (int i=1;i<pre.length;i++){
           TreeNode p=new TreeNode(pre[i]);
           int flag=-1;
           for (int j:in){
                if (in[j]==temp){
                    flag=1;
                }
                if (in[j]==pre[i]){
                    break;
                }
           }
           if (flag==-1){
            q.left=p;
            q=q.left;
           }else {
               q.right=p;
           }
           temp=pre[i];
       }
        return root;
    }
    public static void printTreeBFS(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int last,nlast=root.val,temp=-1;
        while (!queue.isEmpty()){
            TreeNode p=queue.poll();
            System.out.print(p.val+"\t");
            last=p.val;
            if (last==nlast){
                System.out.println();
            }
            if (p.left!=null){
                queue.offer(p.left);
                if (last==nlast)
                    temp=p.left.val;
            }
            if (p.right!=null){
                queue.offer(p.right);
                if (last==nlast)
                    temp=p.right.val;
            }
            nlast=temp;
        }

    }
}

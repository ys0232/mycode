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
    private static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
       TreeNode root;
       if (pre.length==0 || in.length==0)
           return null;
       root=reConstructTree(pre,in,0,pre.length-1,0,in.length-1);
        return root;
    }
   private static TreeNode reConstructTree(int [] pre,int [] in,int startpre,int endpre,int startin,int endin) {
        if (pre.length==0 || in.length==0)return null;
        if (startin>endin || startpre>endpre)return null;
        TreeNode root=new TreeNode(pre[startpre]);
        for (int i=startin;i<=endin;i++){
            if (pre[startpre]==in[i]){
                root.left=reConstructTree(pre,in,(startpre+1),i-startin+startpre,startin,i-1);
                root.right=reConstructTree(pre,in,i-startin+startpre+1,endpre,i+1,endin);
                break;
            }
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

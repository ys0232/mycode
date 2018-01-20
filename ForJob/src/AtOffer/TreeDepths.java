package AtOffer;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yolin on 2018/1/19.
 */
public class TreeDepths {
    public static void main(String[] args){
        int n=9;
        TreeNode root=new TreeNode(0);
        TreeNode p=root,q=p;
        int flag=-1;
        for(int i=1;i<n;i+=2){
            p.left=new TreeNode(i);
            p.right=new TreeNode(i+1);
            if (flag==-1){
              q=p;flag=1;
              p=p.left;
            }else {
                flag=-1;p=q.right;
            }
        }
        System.out.println(TreeDepth(root));
        printTreeBFS(root);

    }
    static void printTreeBFS(TreeNode root){
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
    private static int TreeDepth(TreeNode root){
        if (root==null)return 0;
        int left=TreeDepth(root.left);
        int right=TreeDepth(root.right);
        int depth=left>right?left:right;
        return depth+1;
    }
}

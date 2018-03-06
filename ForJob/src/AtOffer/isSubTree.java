package AtOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yolin on 2018/1/15.
 * this is correct when node is unique.
 */
public class isSubTree {
    public static void main(String[] args){
        int[] a={8,8,7,9,2,1,0,0,0,4,7};
        int[] b={8,9,2};
        TreeNode rootA,rootB,node,right;
        rootA=new TreeNode(a[0]);
        rootB=new TreeNode(b[0]);
        node=rootA;right=rootA;
        int flag=-1;
        for (int i=1;i<a.length;i+=2){
            node.left=new TreeNode(a[i]);
            node.right=new TreeNode(a[i+1]);
            if (flag==-1){
                right=node;
                node=node.left;
                flag=1;
            }else {
                node=right.right;
                flag=-1;
            }
        }
       printTreeBFS(rootA);
        node=rootB;right=rootB;
         flag=-1;
        for (int i=1;i<b.length;i+=2){
            node.left=new TreeNode(b[i]);
            node.right=new TreeNode(b[i+1]);
            if (flag==-1){
                right=node;
                node=node.left;
                flag=1;
            }else {
                node=right.right;
                flag=-1;
            }
        }
        System.out.println("===================================================");
        printTreeBFS(rootB);
        System.out.println("===================================================");
        System.out.println(HasSubtree(rootA,rootB));
    }
    private static boolean HasSubtree(TreeNode root1,TreeNode root2){
        if (root1==null || root2==null)return false;
        return isSubtree(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);

    }
    private static boolean isSubtree(TreeNode root1,TreeNode root2){
        if (root2==null) return true;
        if (root1==null ) return false;
        System.out.println(root1.val+"\t"+root2.val);
        if (root1.val == root2.val){
            return isSubtree(root1.left,root2.left) && isSubtree(root1.right,root2.right);
        }else return false;
    }

    private static void printTreeBFS(TreeNode root){
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

package AtOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yolin on 2018/1/15.
 * this is correct when node is unique.
 */
public class isSubTree {
    public static void main(String[] args){
        int[] a={1,2,3,4,5,6,7};
        int[] b={1,2,3};
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
        if (root2==null)return false;
        TreeNode node=root1,node1=root2;
        int flag=-1,flag1=-1;
        boolean f=false,flast=false;
        while (node!=null && node1!=null){
            f=false;
            System.out.println(node.val+"\t"+node1.val);
            if (node.val==node1.val){
                f=true;
                if (flag==-1){
                    root1=node;
                    root2=node1;
                    node=node.left;
                    node1=node1.left;
                    flag=1;
                }else {
                    node=root1.right;
                    node1=root2.right;
                    flag=-1;
                }
            }else if (flag1==-1){
                root1=node;
                node=node.left;
                flag1=1;
            }else {
                node=root1.right;
                flag=-1;
            }
            if (f){
                flast=true;
            }
            if (f!=flast){
               return false;
            }

        }
        return node1==null;
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

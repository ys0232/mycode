package tree;

import java.util.Collection;
import java.util.Iterator;
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

public class printTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        int n = 9;
        TreeNode p = root;
        TreeNode q=p;
        int flag = 1;
        for (int i = 1; i < n; i += 2) {
            p.left = new TreeNode(i);
            p.right = new TreeNode(i + 1);
            if (flag == 1) {
                q = p;
                p = p.left;
                flag = -1;
            } else {
                flag = 1;
                p = q.right;
            }
        }
        printTreeBFS(root);
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

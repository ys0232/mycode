package AtOffer;


import java.util.ArrayList;

/**
 * Created by yolin on 2018/1/15.
 */
public class TreeMirror {
    public static void main(String[] args){
        int[] pre={8,7,-1,6,-1,5,-1,4};
        TreeNode root=new TreeNode(pre[0]);
        TreeNode p,q;
        p=root;q=root;
        int flag=-1;
        for (int i=1;i<pre.length;i+=2){
            p.left=new TreeNode(pre[i]);
            if (i<pre.length-1)
                p.right=new TreeNode(pre[i+1]);
            if (flag==-1){
                flag=1;
                q=p;
                p=p.left;
            }else {
                flag=-1;
                p=q.right;
            }
        }
       // Mirror(root);
        M2(root);
        PrintTree(root);
    }
    private static void Mirror(TreeNode root){
        if (root==null)return;
        TreeNode p=root,q=p;
        int flag=-1;
        while (p.left!=null || p.right!=null){
            TreeNode temp=p.left;
            p.left=p.right;
            p.right=temp;
            temp=p;
            while(p==temp){
            if (flag==-1){
                q=p;flag=1;
                if(p.left!=null)
                p=p.left;
            }else{
                flag=-1;
                if (q.right!=null)
                p=q.right;
            }
            }
        }


    }
    private static void M2(TreeNode root){
        if (root==null) return;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        if (root.left!=null)M2(root.left);
        if (root.right!=null)M2(root.right);


    }
    private static void PrintTree(TreeNode root){
        TreeNode[] queue=new TreeNode[888];
        queue[0]=root;
        TreeNode last;
        TreeNode nlast=root;
        TreeNode temp=null;
        int k=1,id=0,count=1;
        while (count>0){
            TreeNode p=queue[id];
            id++;count--;
            System.out.print(p.val+"\t");
            last=p;
            if (last==nlast){
                System.out.println();
            }
            if (p.left!=null){
                queue[k]=p.left;
                k++;count++;
                if (last==nlast)
                    temp=p.left;
            }
            if (p.right!=null){
                queue[k]=p.right;
                k++;count++;
                if (last==nlast)
                    temp=p.right;
            }

            nlast=temp;
        }
    }
}

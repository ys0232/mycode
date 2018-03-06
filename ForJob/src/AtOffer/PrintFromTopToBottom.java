package AtOffer;

import java.util.ArrayList;

/**
 * Created by yolin on 2018/1/15.
 */
public class PrintFromTopToBottom {
    public static void main(String[] args){
        int[] pre={1,2,4,7,3,5,6,8};
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
    ArrayList<Integer> r=printFromTopToBottom(root);
       System.out.println("===============\n"+r.toString());
        r=printFromTtoB(root);
        System.out.println("===============\n"+r.toString());
    }
    private static ArrayList<Integer> printFromTopToBottom(TreeNode root){
        ArrayList<Integer> result=new ArrayList<>();
        if (root==null)return result;
        ArrayList<TreeNode> queue=new ArrayList<>();
        queue.add(root);
        int last,nlast=root.val,temp=-1;
        while (!queue.isEmpty()){
            TreeNode p=queue.get(0);
            queue.remove(p);
            System.out.print(p.val+"\t");
            result.add(p.val);
            last=p.val;
            if (last==nlast){
                System.out.println();
            }
            if (p.left!=null){
                queue.add(p.left);
                if (last==nlast)
                    temp=p.left.val;
            }
            if (p.right!=null){
                queue.add(p.right);
                if (last==nlast)
                    temp=p.right.val;
            }
            nlast=temp;
        }
        return result;
    }
    private static ArrayList<Integer> printFromTtoB(TreeNode root){
        ArrayList<Integer> result=new ArrayList<>();
        ArrayList<TreeNode> queue=new ArrayList<>();
        if (root==null) return result;
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.remove(0);
            result.add(temp.val);
            if (temp.left!=null)queue.add(temp.left);
            if (temp.right!=null)queue.add(temp.right);
        }
        return result;
    }
}

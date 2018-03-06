package AtOffer;

import java.util.Stack;

/**
 * Created by yolin on 2018/3/6.
 */
public class KthNodeOfTree {
    public static void main(String [] args){
        int[] pre={8,6,10,5,7,9,11};
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
        System.out.println(KthNode(root,7).val);
    }
    private static TreeNode KthNode(TreeNode pRoot,int k){
        if (k<=0)return null;
        Stack<TreeNode> st=new Stack<>();
        TreeNode  res =pRoot;
        TreeNode temp=pRoot;
        while ((temp!=null || !st.isEmpty()) && k>0){
            while (temp!=null){
                st.push(temp);
                temp=temp.left;
            }
            if (!st.isEmpty()){
                temp=st.pop();
                k--;
                res=temp;
                temp=temp.right;
            }
            System.out.println(res.val+"\t"+k+"\t"+(temp==null)+"\t"+(st.isEmpty()));
        }
        if (k==0)return res;
        else return null;
    }

}

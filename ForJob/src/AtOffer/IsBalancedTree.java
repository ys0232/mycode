package AtOffer;

import sun.reflect.generics.tree.Tree;

/**
 * Created by yolin on 2018/3/5.
 */
public class IsBalancedTree {
    static boolean flag=true;
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        System.out.println(IsBalanced_Solution(root));
    }
    private static boolean IsBalanced_Solution(TreeNode root){

        System.out.println(getDepth(root));

        return flag;

    }
    private static int getDepth(TreeNode root){
        if (!flag)return 0;
        if (root==null)return 0;
        int high=0;
        int left=getDepth(root.left);
        int right=getDepth(root.right);
        if (left>right){
            high=left+1;
        }else high=right+1;
        if (Math.abs(left-right)>1){
            flag=false;
        }
        return high;
    }
}

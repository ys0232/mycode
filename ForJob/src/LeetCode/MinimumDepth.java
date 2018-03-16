package LeetCode;

import AtOffer.TreeNode;

/**
 * Created by yolin on 2018/3/14.
 */
public class MinimumDepth {
    private static int run(TreeNode root){
        if (root==null)return 0;
        if (root.left==null && root.right==null)return 1;
        int left=0,right=0;
        if (root.left!=null)
             left=run(root.left);
        if (root.right!=null)
            right=run(root.right);
        if (left==0 || right==0)
        return 1+left+right;
        else return 1+Math.min(left,right);
    }
    public static void main(String[] args){

    }
}

package AtOffer;

import java.util.Stack;

/**
 * Created by yolin on 2018/3/5.
 */
public class isSymmetricalTree {
    public static void main(String[] args) {
        int[] pre = {8, 6, 6, 7, 5, 5, 7};
        TreeNode root = new TreeNode(pre[0]);
        TreeNode p, q;
        p = root;
        q = root;
        int flag = -1;
        for (int i = 1; i < pre.length; i += 2) {
            p.left = new TreeNode(pre[i]);
            if (i < pre.length - 1)
                p.right = new TreeNode(pre[i + 1]);
            if (flag == -1) {
                flag = 1;
                q = p;
                p = p.left;
            } else {
                flag = -1;
                p = q.right;
            }
        }
        System.out.println(isSymmetrical(root));
    }

    private static boolean isSymmetrical(TreeNode pRoot) {
        // it's not suitable for {5,5,5,5,#,#,5,5,#,5}

        if (pRoot == null) return true;
        TreeNode left = pRoot;
        TreeNode right = pRoot;
        Stack<TreeNode> lst = new Stack<>();
        Stack<TreeNode> rst = new Stack<>();
        while (left!=null && right!=null ||(!lst.isEmpty() && !rst.isEmpty())) {
            while (left != null && right != null) {
              //  System.out.print(left.val+"\t");
                lst.push(left);
                left = left.left;
                rst.push(right);
                right = right.right;
            }

            if (!lst.isEmpty() && !rst.isEmpty()) {
                left = lst.pop();
                right = rst.pop();
               // System.out.println(left.val + "\t" + right.val);
                if (left.val != right.val) return false;
                left = left.right;
                right = right.left;
            }
        }
       if (!lst.isEmpty() || !rst.isEmpty())return false;
        if (left!=null || right!=null)return false;
        return true;
    }
    private static boolean Solution(TreeNode pRoot){
        if (pRoot==null || (pRoot.left==null && pRoot.right==null))return true;
        TreeNode left=pRoot.left,right=pRoot.right;
        if (left.val!=right.val)return false;
        return combo(left.left,right.right)&&combo(left.right,right.left);
    }
    private static boolean combo(TreeNode left,TreeNode right){
        if (left==null && right==null)return true;
        if (left==null && right!=null || (left!=null && right==null))return false;
        if (left.val!=right.val)return false;
        return combo(left.left,right.right)&&combo(left.right,right.left);
    }

}

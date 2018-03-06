package AtOffer;

import java.util.ArrayList;

/**
 * Created by yolin on 2018/3/5.
 */
public class printTree {
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5,9,8,10};
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
        ArrayList<ArrayList<Integer>> r = Print(root);
        for (ArrayList<Integer> i : r)
            System.out.println("===============\n" + i.toString());

    }

    private static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(pRoot);
        int last, nlast = pRoot.val, temp = -1;
        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode p = queue.get(0);
            queue.remove(p);
             //System.out.print(p.val+"\t");
            res.add(p.val);
            last = p.val;
            if (last == nlast || queue.isEmpty()) {
                System.out.println("########" + res.toString());
                result.add(res);
                res = new ArrayList<>();
            }
            if (p.left != null) {
                queue.add(p.left);
                if (last == nlast)
                    temp = p.left.val;
            }
            if (p.right != null) {
                queue.add(p.right);
                if (last == nlast)
                    temp = p.right.val;
            }
            nlast = temp;
        }
        return result;
    }
}

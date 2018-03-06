package AtOffer;


/**
 * Created by yolin on 2018/3/3.
 */
public class ConvertTreeToLinkedList {
    static TreeNode head = null;
    static TreeNode realHead = null;

    public static void main(String[] args) {

    }

    private static TreeNode Convert(TreeNode pRootOfTree) {
        //LDR  中序遍历
        if (pRootOfTree == null) return null;
            Convert(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        Convert(pRootOfTree.right);
        return realHead;
    }

}

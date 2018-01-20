package AtOffer;

import java.util.Arrays;

/**
 * Created by yolin on 2018/1/15.
 *   if (i < k) return null;
 *   use i to judge ,rather than first == null
 */
public class FindKthToTail {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        int[] a = {3, 12, 6, 7, 23, 4, 1, 9, 34, 27, 83, 90, 10, 18, 26, 72};
        int k = a.length + 1;
        ListNode q = head;
        for (int i : a) {
            ListNode p = new ListNode(i);
            q.next = p;
            q = q.next;
        }
        System.out.println(Arrays.toString(a));
        head = FindKthToTailInList(head, k);
        q = head;
        System.out.println();
        while (q != null) {
            System.out.print(q.val + "\t");
            q = q.next;
        }

    }

    private static ListNode FindKthToTailInList(ListNode head, int k) {

        ListNode first = head, last = head;
        int i = 0;
        while (i < k && first != null) {
            //System.out.print(first.val+"\t");
            i++;
            first = first.next;
        }
        if (i < k) return null;
        while (first != null) {
            first = first.next;
            last = last.next;
        }
        return last;
    }
}

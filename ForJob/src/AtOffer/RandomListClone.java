package AtOffer;

import java.util.Random;
import java.util.logging.Handler;

/**
 * Created by yolin on 2018/1/19.
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class RandomListClone {
    public static void main(String[] args) {
        int n = 9;
        RandomListNode head = new RandomListNode(0);
        RandomListNode p = head;
        for (int i = 1; i < n; i++) {
            p.next = new RandomListNode(i);
            p = p.next;
        }
        p = head;
        while (p != null) {
            Random rd = new Random();
            int k = Math.abs(Math.abs(rd.nextInt() % 9));
            //  System.out.println(k);
            RandomListNode r = head;
            while (k > 0) {
                r = r.next;
                k--;
            }
            p.random = r;
            p = p.next;
        }
        p = head;
        while (p != null) {
            System.out.println(p.label + "\t" + p.random.label);
            p = p.next;
        }
        System.out.println("=================================");
        p = Clone(head);
        while (p != null) {
            System.out.println(p.label + "\t" + p.random.label);
            p = p.next;
        }
    }

    private static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode head = new RandomListNode(pHead.label);
        RandomListNode p = head;
        while (pHead != null) {
            if (pHead.next != null) {
                RandomListNode pre = new RandomListNode(pHead.next.label);
                p.next = pre;
            }
            if (pHead.random != null) {
                RandomListNode rd = new RandomListNode(pHead.random.label);
                p.random = rd;
            }
            p = p.next;
            pHead = pHead.next;
        }
        return head;
    }

}

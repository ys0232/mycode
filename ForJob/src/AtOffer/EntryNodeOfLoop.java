package AtOffer;

/**
 * Created by yolin on 2018/3/4.
 *  n = x + y
 *  2n = x + y + z
 *  ===> z = x + y
 *  ===> x = z - y
 *
 */
public class EntryNodeOfLoop {
    public static void main(String[] args){

    }
    private static ListNode entryNodeOfLoop(ListNode pHead){
        if (pHead==null || pHead.next==null)return null;
        ListNode p1,p2;
        p1=p2=pHead;
        while (p1!=null && p2!=null){
            p1=p1.next;
            p2=p2.next.next;
            if (p1==p2){
                p2=pHead;
                while (p1!=null && p2!=null){
                    if (p1==p2)
                        return p2;
                    p2=p2.next;
                    p1=p1.next;

                }
            }
        }
        return null;
    }
}

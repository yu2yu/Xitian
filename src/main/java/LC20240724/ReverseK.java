package LC20240724;

import structure.link.ListNode;

public class ReverseK {

    public ListNode reverseKGroup(ListNode head, int k) {


        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        // 找到第k个节点
        while(head != null){
            ListNode tail = pre;

            // 跳到第k个节点
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if(tail == null){
                    return dummy.next;
                }
            }

            ListNode nex = tail.next;
            ListNode[] reverse = reverse(pre, tail);
            ListNode kHead = reverse[0];
            tail = reverse[1];


            pre.next = kHead;
            tail.next = nex;
            pre = tail;
            head = tail.next;
        }
        return dummy;
    }

    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode cur = head;
        while(cur != tail){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return new ListNode[]{tail, head};
    }

}

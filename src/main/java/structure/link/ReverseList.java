package structure.link;

import org.junit.jupiter.api.Test;

public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode cur = head.next;
        ListNode prev = head;
        while(cur != null){
            ListNode next = cur;
            cur = cur.next;
            next.next = prev;
            prev = next;
        }
        head.next = null;
        return prev;
    }

    @Test
    public void testReverseList(){
        ListNode headNode = ListNode.constructListNodes(new int[]{1, 2, 3, 4, 5});
        ListNode node = reverseList(headNode);
        ListNode.printListNodes(node);
    }

}
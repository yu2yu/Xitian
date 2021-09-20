package structure.link;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CycleNode {

    /**
     * 给定一个链表，判断链表中是否有环
     * @param head
     * @return
     */
    public boolean detectCycle(ListNode head) {
        // 快慢指针
        if(head == null || head.next == null){
            return false;
        }
        ListNode quick = head.next,slow = head;
        while(quick != slow){
            if(quick == null || quick.next == null){
                return false;
            }
            quick = quick.next.next;
            slow = slow.next;
        }
        return true;
    }


    @Test
    public void testDetectCycle(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node3;

//        assertTrue(detectCycle(node1));
        assertFalse(detectCycle(node1));
    }

    public ListNode getCycle(ListNode head) {
        // 快慢指针
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head,slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                ListNode node1 = fast;
                ListNode node2 = head;
                while(node1 != node2){
                    node1 = node1.next;
                    node2 = node2.next;
                }
                return node1;
            }
        }
        return null;
    }

    @Test
    public void testGetCycle(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;

        System.out.println(getCycle(node1).val);
    }
}

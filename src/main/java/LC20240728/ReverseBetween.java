package LC20240728;

import structure.link.ListNode;

public class ReverseBetween {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 首先定位到left节点
        ListNode leftNode = head;
        for (int i = 0; i < left - 1; i++) {
            leftNode = leftNode.next;
        }
        ListNode curNode = leftNode.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = curNode.next;
            leftNode.next = curNode.next;
            curNode.next = next.next;
            next.next = curNode;
        }
        return head;
    }

}

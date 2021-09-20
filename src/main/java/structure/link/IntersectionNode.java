package structure.link;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class IntersectionNode {

    /**
     * 给你两个单链表的头节点 headA 和 headB ，
     * 请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        while(headA != null){
            if(map.getOrDefault(headA,0) == 0){
                map.put(headA,1);
            }
            headA = headA.next;
        }
        while(headB != null){
            if(map.getOrDefault(headB,0) != 0){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
     * 求出长度
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeJJ(ListNode headA, ListNode headB) {
        ListNode node1 = headA,node2 = headB,longHead = headA,shortHead = headB;
        int size1 = 0,size2 = 0;
        while(node1 != null){
            node1 = node1.next;
            ++size1;
        }
        while(node2 != null){
            node2 = node2.next;
            ++size2;
        }
        int distance = Math.abs(size1 - size2);
        if(size2>size1){
            longHead = headB;
            shortHead = headA;
        }
        while(distance != 0){
            longHead = longHead.next;
            --distance;
        }
        while(longHead != null){
            if(longHead == shortHead){
                return longHead;
            }
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return null;
    }

    @Test
    public void testGetIntersectionNode(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node5.next = node6;
//        node6.next = node3;

        ListNode node = getIntersectionNode(node1,node5);
        ListNode.printListNodes(node);
    }

    @Test
    public void testGetIntersectionNodeJJ(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);


        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node5.next = node6;
        node6.next = node3;

        ListNode node = getIntersectionNodeJJ(node1,node5);
        ListNode.printListNodes(node);
    }
}

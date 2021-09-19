package structure.link;

import org.junit.jupiter.api.Test;

public class SwapPairs {

    // 两两交换，实际交换
    public ListNode swapPairs(ListNode head){
        // 停止条件
        if(head == null || head.next == null){
            return head;
        }
        //
        ListNode node = head.next;
        head.next = swapPairs(node.next);
        node.next = head;
        return node;
    }


    // 迭代
    public ListNode swapPairsDD(ListNode head){
        // 创建一个临时节点
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode dummyHead = node;
        // 交换节点
        // node -》 node1 -》 node2
        // node -》 node2 -》 node1
        while(node.next != null && node.next.next != null){
            ListNode temp = node.next;
            ListNode node2 = node.next.next;
            node.next = node2;
            temp.next = node2.next;
            node2.next = temp;
            node = temp;
        }
        return dummyHead.next;
    }

    @Test
    public void testSwap(){
        ListNode headNode = ListNode.constructListNodes(new int[]{1, 2, 3, 4});
        ListNode node = swapPairs(headNode);
        ListNode.printListNodes(node);
    }

    @Test
    public void testSwapDD(){
        ListNode headNode = ListNode.constructListNodes(new int[]{1, 2, 3, 4,5});
        ListNode node = swapPairsDD(headNode);
        ListNode.printListNodes(node);
    }
}

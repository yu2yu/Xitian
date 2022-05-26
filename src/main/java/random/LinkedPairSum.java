package random;

import org.junit.jupiter.api.Test;
import structure.link.ListNode;
import structure.link.ReverseList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @description
 *  在一个大小为n且 n为偶数 的链表中，对于0 <= i <= (n / 2) - 1的 i，
 *  第i个节点（下标从 0开始）的孪生节点为第(n-1-i)个节点 。
 *      比方说，n = 4那么节点0是节点 3的孪生节点，节点 1是节点 2的孪生节点。这是长度为 n = 4的链表中所有的孪生节点。
 * 孪生和定义为一个节点和它孪生节点两者值之和。
 *
 * 给你一个长度为偶数的链表的头节点head，请你返回链表的 最大孪生和。
 *
 *
 *
 */
public class LinkedPairSum {

    public int pairSum(ListNode head) {
        ListNode slow = head,quick = head.next;
        while(quick.next != null){
            slow = slow.next;
            quick = quick.next.next;
        }
        // 翻转
        ListNode after = new ReverseList().reverseListDG(slow.next);

        int max = Integer.MIN_VALUE;
        ListNode cur = head;
        while(after != null){
            if((cur.val + after.val) > max){
                max = cur.val + after.val;
            }
            cur = cur.next;
            after = after.next;
        }
        return max;
    }


    @Test
    public void testPairSum(){
        ListNode headNode = ListNode.constructListNodes(new int[]{5,4,2,1});
        assertEquals(6,pairSum(headNode));
        headNode = ListNode.constructListNodes(new int[]{4,2,2,3});
        assertEquals(7,pairSum(headNode));
        headNode = ListNode.constructListNodes(new int[]{1,1000});
        assertEquals(1001,pairSum(headNode));
    }
}

package exercise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import structure.link.ListNode;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author yy
 * @version 1.0.0
 * @Description TODO 翻转
 * @createTime 2022-07-15 14:39:00
 */
public class Reverse {


    /**
     * 翻转列表
     * @param head
     * @return reverseHead
     */
    public ListNode reverseList(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode pre = head,cur = head.next;
        while(cur != null){
            ListNode next = cur;
            cur = cur.next;
            next.next = pre;
            pre = next;
        }
        head.next = null;
        return pre;
    }


}

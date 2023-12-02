/**
给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。 

 

 示例 1： 
 
 
输入：head = [1,2,2,1]
输出：true
 

 示例 2： 
 
 
输入：head = [1,2]
输出：false
 

 

 提示： 

 
 链表中节点数目在范围[1, 10⁵] 内 
 0 <= Node.val <= 9 
 

 

 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 

 Related Topics 栈 递归 链表 双指针 👍 1819 👎 0

*/

package leetcode.editor.cn;

import java.util.List;

public class I234PalindromeLinkedList{
    public static void main(String[] args) {
        Solution solution = new I234PalindromeLinkedList().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        int cnt = 0;
        while(p != null){
            cnt++;
            p = p.next;
        }
        int n = cnt / 2;
        ListNode pre = null;
        ListNode curr = head;
        while(curr != null && n > 0){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
            n--;
        }
        if(cnt % 2 == 0){
            return compare(pre,curr);
        }else {
            return compare(pre,curr.next);
        }
    }
    private boolean compare(ListNode node1,ListNode node2){
        while(node1 != null && node2 != null){
            if(node1.val != node2.val) return false;
            node1 = node1.next;
            node2 = node2.next;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
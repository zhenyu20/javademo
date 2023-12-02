/**
给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。 

 

 示例 1: 

 

 
输入: [1,2,3,null,5,null,4]
输出: [1,3,4]
 

 示例 2: 

 
输入: [1,null,3]
输出: [1,3]
 

 示例 3: 

 
输入: []
输出: []
 

 

 提示: 

 
 二叉树的节点个数的范围是 [0,100] 
 
 -100 <= Node.val <= 100 
 

 Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 992 👎 0

*/

package leetcode.editor.cn;


import java.util.*;

public class I199BinaryTreeRightSideView{
    public static void main(String[] args) {
        Solution solution = new I199BinaryTreeRightSideView().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return res;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.remove();
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
                if(i == size - 1) res.add(temp.val);
            }
        }
        return  res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
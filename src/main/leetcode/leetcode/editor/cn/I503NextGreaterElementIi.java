/**
给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 

 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。 


 

 示例 1: 

 
输入: nums = [1,2,1]
输出: [2,-1,2]
解释: 第一个 1 的下一个更大的数是 2；
数字 2 找不到下一个更大的数； 
第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 

 示例 2: 

 
输入: nums = [1,2,3,4,3]
输出: [2,3,4,-1,4]
 

 

 提示: 

 
 1 <= nums.length <= 10⁴ 
 -10⁹ <= nums[i] <= 10⁹ 
 

 Related Topics 栈 数组 单调栈 👍 878 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class I503NextGreaterElementIi{
    public static void main(String[] args) {
        Solution solution = new I503NextGreaterElementIi().new Solution();
        solution.nextGreaterElements(new int[]{1,2,1});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int idx = 0,topI = 0;
        Deque<Integer> q = new ArrayDeque<>();
        int[] res = new int[n];
        Arrays.fill(res,-1);
        for(int i = 0;i <= 2 * n - 1;i++){
            idx = i % n;
            while(!q.isEmpty() && nums[topI = q.peek()] < nums[idx]){
                q.pop();
                res[topI] = nums[idx];
            }
            q.push(idx);
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
//class Solution {
//    public int[] nextGreaterElements(int[] nums) {
//        int n = nums.length;
//        int idx = 0,top = 0;
//        Deque<Integer> q = new ArrayDeque<>();
//        int[] res = new int[n];
//        Arrays.fill(res,-1);
//        for(int i = 2 * n - 1;i >= 0;i--){
//            idx = i % n;
//            while(!q.isEmpty() && (top = q.peek()) <= nums[idx]){
//                q.pop();
//            }
//            if(!q.isEmpty()) res[idx] = top;
//            q.push(nums[idx]);
//        }
//        return res;
//
//    }
//}
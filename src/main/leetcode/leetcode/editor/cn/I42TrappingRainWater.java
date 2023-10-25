/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == height.length
 * 1 <= n <= 2 * 10⁴
 * 0 <= height[i] <= 10⁵
 * <p>
 * <p>
 * Related Topics 栈 数组 双指针 动态规划 单调栈 👍 4808 👎 0
 */

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class I42TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new I42TrappingRainWater().new Solution();
        solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            int[] leftMax = new int[n];
            int[] rightMax = new int[n];
            int area = 0;
            for (int i = 1; i < n; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
            }
            for (int i = n - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
            }
            for (int i = 0; i < n; i++) {
                area += Math.max(Math.min(leftMax[i],rightMax[i]) - height[i],0);
            }
            return area;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
//class Solution {
//    public int trap(int[] height) {
//        int n = height.length;
//        Deque<Integer> q = new ArrayDeque<>();
//        int top = 0, preI = 0;
//        int area = 0;
//        for (int i = 0; i < n; i++) {
//            while (!q.isEmpty() && height[q.peek()] < height[i]) {
//                top = q.pop();
//                if(q.isEmpty()) break;
//                preI = q.peek();
//                area += (i - preI - 1) * (Math.min(height[preI], height[i]) - height[top]);
//            }
//            q.push(i);
//        }
//        return area;
//    }
//}
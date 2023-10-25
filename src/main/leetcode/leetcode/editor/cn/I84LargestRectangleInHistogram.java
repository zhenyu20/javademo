/**
给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 

 求在该柱状图中，能够勾勒出来的矩形的最大面积。 

 

 示例 1: 

 

 
输入：heights = [2,1,5,6,2,3]
输出：10
解释：最大的矩形为图中红色区域，面积为 10
 

 示例 2： 

 

 
输入： heights = [2,4]
输出： 4 

 

 提示： 

 
 1 <= heights.length <=10⁵ 
 0 <= heights[i] <= 10⁴ 
 

 Related Topics 栈 数组 单调栈 👍 2590 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class I84LargestRectangleInHistogram{
    public static void main(String[] args) {
        Solution solution = new I84LargestRectangleInHistogram().new Solution();
        solution.largestRectangleArea(new int[]{2,1,5,6,2,3});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int [] newHeights = new int[n + 2];
        newHeights[0] = 0;
        newHeights[n - 1] = 0;
        System.arraycopy(heights, 0, newHeights, 1, n);
        heights = newHeights;
        Deque<Integer> q = new ArrayDeque<>();
        q.push(0);
        int area = 0;
        int topI = 0,temp = 0;
        for (int i = 1; i <= n + 1; i++) {
            while (!q.isEmpty() && heights[i] < heights[topI = q.peek()]){
                q.pop();
                if (q.isEmpty()) break;
                temp = (i - q.peek() - 1) * heights[topI];
                if(temp > area) area = temp;
            }
            q.push(i);
        }
        return area;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
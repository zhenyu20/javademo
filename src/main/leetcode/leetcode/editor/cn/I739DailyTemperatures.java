/**
给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几
天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。 

 

 示例 1: 

 
输入: temperatures = [73,74,75,71,69,72,76,73]
输出: [1,1,4,2,1,1,0,0]
 

 示例 2: 

 
输入: temperatures = [30,40,50,60]
输出: [1,1,1,0]
 

 示例 3: 

 
输入: temperatures = [30,60,90]
输出: [1,1,0] 

 

 提示： 

 
 1 <= temperatures.length <= 10⁵ 
 30 <= temperatures[i] <= 100 
 

 Related Topics 栈 数组 单调栈 👍 1633 👎 0

*/

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class I739DailyTemperatures{
    public static void main(String[] args) {
        Solution solution = new I739DailyTemperatures().new Solution();
        int[] its = new int[]{73,74,75,71,69,72,76,73};
        solution.dailyTemperatures(its);
    }
//leetcode submit region begin(Prohibit modification and deletion)
//从左向右
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int topI = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() &&   temperatures[topI = stack.peek()] < temperatures[i]){
                stack.pop();
                res[topI] =  i - topI;
            }
            stack.push(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

//从右向左
//class Solution {
//    public int[] dailyTemperatures(int[] temperatures) {
//        int n = temperatures.length;
//        Deque<Integer> stack = new ArrayDeque<>();
//        int topI = 0;
//        int[] res = new int[n];
//        for (int i = n - 1; i >= 0; i--) {
//            while(!stack.isEmpty() && temperatures[ topI = stack.peek()] <= temperatures[i] ){
//                stack.pop();
//            }
//            if(!stack.isEmpty()) res[i] = topI - i;
//            stack.push(i);
//        }
//        return res;
//    }
//}
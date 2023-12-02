/**
 * 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i +
 * 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：arr = [3,1,3,6]
 * 输出：false
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：arr = [2,1,2,6]
 * 输出：false
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：arr = [4,-2,2,-4]
 * 输出：true
 * 解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= arr.length <= 3 * 10⁴
 * arr.length 是偶数
 * -10⁵ <= arr[i] <= 10⁵
 * <p>
 * <p>
 * Related Topics 贪心 数组 哈希表 排序 👍 194 👎 0
 */

package leetcode.editor.cn;

import java.util.*;

public class I954ArrayOfDoubledPairs {
    public static void main(String[] args) {
        Solution solution = new I954ArrayOfDoubledPairs().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canReorderDoubled(int[] arr) {
            List<Integer> list = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (int a : arr) {
                list.add(a);
                map.put(a, map.getOrDefault(a, 0) + 1);
            }
//            list.sort((a, b) -> Math.abs(a) - Math.abs(b));
            list.sort(Comparator.comparingInt(Math::abs));

            for (Integer curr : list) {
                if (map.get(curr) > 0) {
                    map.put(curr, map.get(curr) - 1);
                    if (map.getOrDefault(curr * 2, 0) < 1) return false;
                    map.put(curr * 2, map.get(curr * 2) - 1);
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
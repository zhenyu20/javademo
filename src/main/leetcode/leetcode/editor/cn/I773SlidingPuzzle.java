/**
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示。一次 移动 定义为选择 0 与一个相邻的数字（上下
 * 左右）进行交换.
 * <p>
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 * <p>
 * 给出一个谜板的初始状态 board ，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：board = [[1,2,3],[4,0,5]]
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：board = [[1,2,3],[5,4,0]]
 * 输出：-1
 * 解释：没有办法完成谜板
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：board = [[4,1,2],[5,0,3]]
 * 输出：5
 * 解释：
 * 最少完成谜板的最少移动次数是 5 ，
 * 一种移动路径:
 * 尚未移动: [[4,1,2],[5,0,3]]
 * 移动 1 次: [[4,1,2],[0,5,3]]
 * 移动 2 次: [[0,1,2],[4,5,3]]
 * 移动 3 次: [[1,0,2],[4,5,3]]
 * 移动 4 次: [[1,2,0],[4,5,3]]
 * 移动 5 次: [[1,2,3],[4,5,0]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * board.length == 2
 * board[i].length == 3
 * 0 <= board[i][j] <= 5
 * board[i][j] 中每个值都 不同
 * <p>
 * <p>
 * Related Topics 广度优先搜索 数组 矩阵 👍 321 👎 0
 */

package leetcode.editor.cn;

import java.util.*;

public class I773SlidingPuzzle {
    public static void main(String[] args) {
        Solution solution = new I773SlidingPuzzle().new Solution();
        int[][] board = {{3, 2, 4}, {1, 5, 0}};
        System.out.println(solution.slidingPuzzle(board));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        public int slidingPuzzle(int[][] board) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 3; j++) {
                    sb.append(board[i][j]);
                }
            }
            String start = new String(sb);
            Deque<String> s1 = new ArrayDeque<>();
            Set<String> seen = new HashSet<>();
            s1.add(start);
            seen.add(start);
            int step = 0;
            while (!s1.isEmpty()) {
                int size = s1.size();
                for (int i = 0; i < size; i++) {
                    String curr = s1.poll();
                    if ("123450".equals(curr))
                        return step;
                    List<String> ret = get(curr);
                    for (String next : ret) {
//                        ret.forEach(System.out::print);
//                        System.out.println();
                        System.out.println(ret);
                        if (!seen.contains(next)) {
                            s1.add(next);
                            seen.add(next);
                        }
                    }
                }
                step++;
            }
            return -1;
        }
        // 枚举 status 通过一次交换操作得到的状态
        public List<String> get(String status) {
            List<String> ret = new ArrayList<>();
            char[] array = status.toCharArray();
            int x = status.indexOf('0');
            for (int y : neighbors[x]) {
                swap(array, x, y);
                ret.add(new String(array));
                swap(array, x, y);
            }
            return ret;
        }

        public void swap(char[] array, int x, int y) {
            char temp = array[x];
            array[x] = array[y];
            array[y] = temp;
        }

        private List<String> move(String curr){
            int idx = curr.indexOf("0");
            List<String> ret = new ArrayList<>();
            if(idx + 3 <= 5){
                StringBuilder temp = new StringBuilder(curr);
                temp.setCharAt(idx,curr.charAt(idx + 3));
                temp.setCharAt(idx + 3,'0');
                ret.add(new String(temp));
            }
            if(idx - 3 >= 0){
                StringBuilder temp = new StringBuilder(curr);
                temp.setCharAt(idx,curr.charAt(idx - 3));
                temp.setCharAt(idx - 3,'0');
                ret.add(new String(temp));
            }
            if(idx + 1 <= 5){
                StringBuilder temp = new StringBuilder(curr);
                temp.setCharAt(idx,curr.charAt(idx + 1));
                temp.setCharAt(idx + 1,'0');
                ret.add(new String(temp));
            }
            if(idx - 1 >= 0){
                StringBuilder temp = new StringBuilder(curr);
                temp.setCharAt(idx,curr.charAt(idx - 1));
                temp.setCharAt(idx - 1,'0');
                ret.add(new String(temp));
            }
            return ret;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

/*
public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < 2;i++){
            for(int j = 0;j < 3;j++){
                sb.append(board[i][j] + "");
            }
        }
        String start = new String(sb);
        String end = "123450";
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        Set<String> seen = new HashSet<>();
        s1.add(start);
        s2.add(end);
        int step = 0;
        while(!s1.isEmpty() && !s2.isEmpty()){
            if(s2.size() < s1.size()){
                Set<String> temp = new HashSet<>();
                temp = s1;
                s1 = s2;
                s2 = temp;
            }
            Set<String> temp = new HashSet<>();
            for(String curr : s1){
                seen.add(curr);
                if(s2.contains(curr))
                    return step;
                List<String> ret = move(curr);
                for(String next : ret){
                    if(!seen.contains(next))
                        temp.add(next);
                }
            }
            s1 = temp;
            ++step;
        }
        return -1;
    }
    //后面的有误
    private List<String> move(String curr){
        int idx = curr.indexOf("0");
        List<String> ret = new ArrayList<>();
        StringBuilder temp = null;
        if(idx + 3 <= 5){
            temp = new StringBuilder(curr);
            temp.setCharAt(idx,curr.charAt(idx + 3));
            temp.setCharAt(idx + 3,'0');
            ret.add(new String(temp));
        }
        if(idx - 3 >= 0){
            temp = new StringBuilder(curr);
            temp.setCharAt(idx,curr.charAt(idx - 3));
            temp.setCharAt(idx - 3,'0');
            ret.add(new String(temp));
        }
        if(idx + 1 <= 5){
            temp = new StringBuilder(curr);
            temp.setCharAt(idx,curr.charAt(idx + 1));
            temp.setCharAt(idx + 1,'0');
            ret.add(new String(temp));
        }
        if(idx - 1 >= 0){
            temp = new StringBuilder(curr);
            temp.setCharAt(idx,curr.charAt(idx - 1));
            temp.setCharAt(idx - 1,'0');
            ret.add(new String(temp));
        }
        return ret;
    }

*/
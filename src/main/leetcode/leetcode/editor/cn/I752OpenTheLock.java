/**
你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。 

 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。 

 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。 

 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。 

 

 示例 1: 

 
输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
输出：6
解释：
可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
因为当拨动到 "0102" 时这个锁就会被锁定。
 

 示例 2: 

 
输入: deadends = ["8888"], target = "0009"
输出：1
解释：把最后一位反向旋转一次即可 "0000" -> "0009"。
 

 示例 3: 

 
输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], 
target = "8888"
输出：-1
解释：无法旋转到目标数字且不被锁定。
 

 

 提示： 

 
 1 <= deadends.length <= 500 
 deadends[i].length == 4 
 target.length == 4 
 target 不在 deadends 之中 
 target 和 deadends[i] 仅由若干位数字组成 
 

 Related Topics 广度优先搜索 数组 哈希表 字符串 👍 639 👎 0

*/

package leetcode.editor.cn;

import java.util.*;

public class I752OpenTheLock{
    public static void main(String[] args) {
        Solution solution = new I752OpenTheLock().new Solution();
        solution.openLock(new String[]{"0201","0101","0102","1212","2002"},"0202");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class  Solution{
    // 将 s[j] 向上拨动一次
    private String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }
    // 将 s[i] 向下拨动一次
    private String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }
    public int openLock(String[] deadends, String target) {
        List<String> deadList = new ArrayList<>(Arrays.asList(deadends));
        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();
        Set<String> vis = new HashSet<>();
        int cnt = 0;
        s1.add("0000");
        s2.add(target);
        vis.add("0000");
        while(!s1.isEmpty() && !s2.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for (String top : s1) {
                if (deadList.contains(top))
                    continue;
                if (s2.contains(top))
                    return cnt;
                for (int j = 0; j < 4; j++) {
                    String newp = plusOne(top, j);
                    if (!vis.contains(newp)) {
                        temp.add(newp);
                        vis.add(newp);
                    }
                    String newm = minusOne(top, j);
                    if (!vis.contains(newm)) {
                        temp.add(newm);
                        vis.add(newm);
                    }
                }
            }
            cnt++;
            s1 = s2;
            s2 = temp;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
/*
DFS
class Solution {
    // 将 s[j] 向上拨动一次
    private String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }
    // 将 s[i] 向下拨动一次
    private String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }
    public int openLock(String[] deadends, String target) {
        List<String> deadList = new ArrayList<>(Arrays.asList(deadends));
        Deque<String> q = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        int cnt = 0;
        q.offer("0000");
        set.add("0000");
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0;i < size;i++){
                String top = q.poll();
                if(deadList.contains(top))
                    continue;
                if(target.equals(top))
                    return cnt;
                for(int j = 0;j < 4;j++){
                    String newp = plusOne(top,j);
                    if(!set.contains(newp)){
                        q.offer(newp);
                        set.add(newp);
                    }
                    String newm = minusOne(top,j);
                    if(!set.contains(newm)){
                        q.offer(newm);
                        set.add(newm);
                    }
                }
            }
            cnt++;
        }
        return cnt;
    }
}*/
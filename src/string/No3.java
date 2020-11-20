package string;

import java.util.HashMap;
import java.util.Map;

public class No3 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, ans = 0;
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right)) && map.get(s.charAt(right)) >= left) {
                // 当前访问的元素在窗口内有重复时才更新答案，并移动左指针
                int len = right - left;
                ans = len > ans ? len : ans;
                left = map.get(s.charAt(right)) + 1;
            }
            map.put(s.charAt(right), right++);
        }
        return Math.max(right - left, ans);
    }

}

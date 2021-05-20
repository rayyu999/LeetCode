package swindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Ray
 * @Date 2021/5/20 15:38
 * @Description 567.字符串的排列
 */
public class No567 {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            int cnt = need.getOrDefault(c, 0);
            need.put(c, cnt + 1);
        }
        // 滑动窗口，valid表示满足条件的字符的个数
        int left = 0, right = 0, n = s2.length(), valid = 0;
        while (right < n) {
            char c = s2.charAt(right);
            ++right;
            if (need.containsKey(c)) {
                int cnt = window.getOrDefault(c, 0);
                window.put(c, ++cnt);
                int required = need.get(c);
                if (cnt == required) {
                    ++valid;
                }
                // 窗口包含了s1所有的字符后，再将窗口缩小到s1的长度
                while (right - left > s1.length()) {
                    char d = s2.charAt(left);
                    ++left;
                    if (need.containsKey(d)) {
                        int tmp = window.get(d);
                        window.put(d, tmp - 1);
                        int m = need.get(d);
                        if (tmp == m) {
                            --valid;
                        }
                    }
                }
                // 判断是否仍然满足条件
                if (valid == need.size()) {
                    return true;
                }
            }
        }
        return false;
    }

}

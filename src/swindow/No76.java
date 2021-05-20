package swindow;

import java.util.HashMap;
import java.util.Map;

public class No76 {

    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        int start = 0, min = Integer.MAX_VALUE;
        // 统计需要字符的个数
        for (char c : t.toCharArray()) {
            int cnt = need.getOrDefault(c, 0);
            need.put(c, cnt + 1);
        }
        int left = 0, right = 0, len = s.length(), valid = 0;
        while (right < len) {
            char c = s.charAt(right);
            // 移动右指针，扩大窗口
            ++right;
            // 当前访问元素在need中存在时对滑动窗口进行处理
            if (need.containsKey(c)) {
                int cnt = window.getOrDefault(c, 0);
                // 将当前元素计入滑动窗口
                window.put(c, ++cnt);
                int n = need.get(c);
                // 统计need中满足条件字符的个数
                if (cnt == n) {
                    ++valid;
                }
                // 当获得一个可行解时，移动左指针，缩小窗口
                // 并在窗口内子串不满足条件时跳出循环
                while (valid == need.size()) {
                    // 更新最小子串
                    if (right - left < min) {
                        start = left;
                        min = right - left;
                    }
                    // 将左边的元素删除，然后移动左指针
                    char d = s.charAt(left);
                    if (need.containsKey(d)) {
                        int tmp = window.get(d);
                        window.put(d, tmp - 1);
                        int m = need.get(d);
                        // 当删除元素后不满足条件，将满足条件的字符数减一
                        if (tmp == m) {
                            --valid;
                        }
                    }
                    ++left;
                }
            }
        }
        // 最后还需要判断是否有解，若无返回空字符串
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }

}

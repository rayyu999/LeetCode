package swindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No438 {

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        for (char c : p.toCharArray()) {
            int cnt = need.getOrDefault(c, 0);
            need.put(c, cnt + 1);
        }
        int left = 0, right = 0, n = s.length(), valid = 0;
        List<Integer> res = new ArrayList<>();
        while (right < n) {
            char c = s.charAt(right);
            ++right;
            if (need.containsKey(c)) {
                int cnt = window.getOrDefault(c, 0);
                window.put(c, ++cnt);
                int required = need.get(c);
                if (cnt == required) {
                    ++valid;
                }
                // 缩小滑动窗口，直到窗口大小与p长度相等
                while (right - left > p.length()) {
                    char d = s.charAt(left);
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
                // 判断窗口内是否包含了p的所有字符
                if (valid == need.size()) {
                    res.add(left);
                }
            }
        }
        return res;
    }

}

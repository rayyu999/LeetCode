package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No242 {

    // 排序法
    public boolean isAnagramSort(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        // 对两个字符串进行排序
        Arrays.sort(cs);
        Arrays.sort(ct);
        return String.valueOf(cs).equals(String.valueOf(ct));
    }

    // 哈希表法
    public boolean isAnagramHash(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        // 统计字符串s中各字符的个数
        for (char ch : s.toCharArray()) {
            int cnt = map.getOrDefault(ch, 0);
            map.put(ch, cnt+1);
        }
        // 验证字符串t中各字符的个数是否与s相等
        for (char ch : t.toCharArray()) {
            int cnt = map.getOrDefault(ch, 0);
            if (cnt == 0) return false;
            map.put(ch, cnt - 1);
        }
        return true;
    }

}

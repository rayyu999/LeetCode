package string;

import java.util.HashMap;
import java.util.Map;

public class No387 {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int cnt = map.getOrDefault(c, 0);
            if (cnt > 1) continue;
            map.put(c, cnt+1);
        }
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (map.get(c) == 1) return i;
        }
        return -1;
    }

}

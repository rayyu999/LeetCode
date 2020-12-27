package string;

import java.util.HashMap;
import java.util.Map;

public class No205 {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            if (!map.containsKey(s.charAt(i))) {
                // 新建映射
                // 判断t中对应字母是否已经存在映射关系
                if (map.containsValue(t.charAt(i))) return false;
                map.put(s.charAt(i), t.charAt(i));
            } else {
                // 判断映射是否与前面已建立的符合
                if (map.get(s.charAt(i)) != t.charAt(i)) return false;
            }
        }
        return true;
    }

}

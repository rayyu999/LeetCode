package string;

import java.util.HashMap;
import java.util.Map;

public class No290 {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (words.length != pattern.length()) return false;
        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); ++i) {
            // 当前需要匹配的字母
            char cur = pattern.charAt(i);
            // 获得当前字符串对应的字母
            char c = map.getOrDefault(words[i], '-');
            if (c == '-') {
                // 若还没建立对应关系，则建立
                // 建立前首先判断是否与其它字符串对应的字母产生冲突
                if (map.containsValue(cur)) return false;
                map.put(words[i], cur);
            } else if (c != cur) {
                // 若对应关系与规律冲突，返回false
                return false;
            }
        }
        return true;
    }

}

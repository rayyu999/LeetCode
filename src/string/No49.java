package string;

import java.util.*;

public class No49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 将当前字符串排序
            char[] word = str.toCharArray();
            Arrays.sort(word);
            // 在map中查找对应字母组合的list，并将其加入该list中
            List<String> tmp = map.getOrDefault(String.valueOf(word), new ArrayList<>());
            tmp.add(str);
            map.put(String.valueOf(word), tmp);
        }
        // 遍历map的值
        for (List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }

}

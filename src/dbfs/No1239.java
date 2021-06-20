package dbfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName No1239
 * @Author 36d
 * @Date 2021/6/19 19:47
 * @Description 1239. 串联字符串的最大长度
 **/
public class No1239 {

    /**
     * 已加入当前路径的字符
     */
    Set<Character> visited;
    /**
     * 要求的字符串列表
     */
    List<String> list;
    /**
     * 最大长度
     */
    int res;

    public int maxLength(List<String> arr) {
        list = new ArrayList<>(arr);
        visited = new HashSet<>();
        res = 0;
        for (int i = 0; i <= list.size(); ++i) {
            recall(i, 0);
        }
        return res;
    }

    /**
     * 回溯
     * @param index
     * @param len
     */
    private void recall(int index, int len) {
        if (index == list.size()) {
            res = Math.max(res, len);
            return;
        }
        boolean flag = false;
        String str = list.get(index);
        if (!containsChar(str)) {
            len += str.length();
            addToSet(str);
            flag = true;
        }
        for (int i = index+1; i <= list.size(); ++i) {
            recall(i, len);
        }
        if (flag) {
            len -= str.length();
            removeFromSet(str);
        }
    }

    /**
     * 判断当前路径或当前字符串有无重复字符
     * @param str
     * @return
     */
    private boolean containsChar(String str) {
        Set<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            if (visited.contains(ch) || set.contains(ch)) {
                return true;
            }
            set.add(ch);
        }
        return false;
    }

    /**
     * 将当前字符串加入路径
     * @param str
     */
    private void addToSet(String str) {
        for (char ch : str.toCharArray()){
            visited.add(ch);
        }
    }

    /**
     * 将当前字符串移出路径
     * @param str
     */
    private void removeFromSet(String str) {
        for (char ch : str.toCharArray()) {
            visited.remove(ch);
        }
    }

}

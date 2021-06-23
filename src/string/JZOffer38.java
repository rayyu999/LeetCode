package string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @Author Ray
 * @Date 2021/6/23 22:51
 * @Description 剑指 Offer 38. 字符串的排列
 */
public class JZOffer38 {

    List<String> list;
    char[] str;

    public String[] permutation(String s) {
        this.list = new LinkedList<>();
        this.str = s.toCharArray();
        recur(0);
        return this.list.toArray(new String[this.list.size()]);
    }

    private void recur(int index) {
        if (index == this.str.length - 1) {
            this.list.add(String.valueOf(this.str));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = index; i < this.str.length; ++i) {
            if (!set.contains(this.str[i])) {
                swap(index, i);
                recur(index+1);
                // 交换计算完后需要交换回来
                swap(index, i);
                set.add(this.str[i]);
            }
        }
    }

    private void swap(int i, int j) {
        // 交换字符位置
        char tmp = this.str[i];
        this.str[i] = this.str[j];
        this.str[j] = tmp;
    }

}

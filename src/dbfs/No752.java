package dbfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author Ray
 * @Date 2021/5/20 15:40
 * @Description 752.打开转盘锁
 */
public class No752 {

    public int openLock(String[] deadends, String target) {
        // 存储待访问的密码
        Queue<String> q = new LinkedList<>();
        // 存储已访问的密码以及死亡密码
        Set<String> visited = new HashSet<>();
        for (String deadend : deadends) {
            visited.add(deadend);
        }
        // 死亡密码包括起始密码，直接返回-1
        if (!visited.contains("0000")) {
            q.offer("0000");
            visited.add("0000");
            int step = 0;
            while (q.size() > 0) {
                int size = q.size();
                for (int i = 0; i < size; ++i) {
                    String cur = q.poll();
                    // 找到解，返回step
                    if (cur.equals(target)) {
                        return step;
                    }
                    // 将四个位置的密码分别向上或向下旋转一位
                    for (int j = 0; j < 4; ++j) {
                        String up = plusOne(cur, j);
                        if (!visited.contains(up)) {
                            q.offer(up);
                            visited.add(up);
                        }
                        String down = minusOne(cur, j);
                        if (!visited.contains(down)) {
                            q.offer(down);
                            visited.add(down);
                        }
                    }
                }
                // 一层层地访问能保证满足题目要求的step最小
                ++step;
            }
        }
        return -1;
    }

    private String plusOne(String s, int i) {
        char[] c = s.toCharArray();
        if (c[i] == '9') {
            c[i] = '0';
        } else {
            c[i] += 1;
        }
        return new String(c);
    }

    private String minusOne(String s, int i) {
        char[] c = s.toCharArray();
        if (c[i] == '0') {
            c[i] = '9';
        } else {
            c[i] -= 1;
        }
        return new String(c);
    }

}

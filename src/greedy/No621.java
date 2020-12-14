package greedy;

import java.util.Arrays;

public class No621 {

    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        // 统计每个任务出现的次数
        for (char task : tasks) {
            ++cnt[task - 'A'];
        }
        Arrays.sort(cnt);
        int maxTimes = cnt[25], maxCount = 0;
        // 统计有多少个任务和次数最多的任务次数一样
        for (int i = 25; i >= 0; --i) {
            if (cnt[i] == maxTimes) ++maxCount;
            else break;
        }
        int res = (maxTimes - 1) * (n + 1) + maxCount;
        // 统一n为0和n不为0的结果
        return Math.max(res, tasks.length);
    }

}

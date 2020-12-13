package greedy;

import java.util.LinkedList;
import java.util.Queue;

public class No649 {

    public String predictPartyVictory(String senate) {
        int n = senate.length();
        // 分别存储有资格投票的参议员顺序
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        for (int i = 0; i < senate.length(); ++i) {
            if (senate.charAt(i) == 'R')
                radiant.offer(i);
            else
                dire.offer(i);
        }

        while (radiant.size() > 0 && dire.size() > 0) {
            // 总是将按照投票顺序的下一名对方阵营议员投票出去
            if (radiant.peek() < dire.peek()) {
                dire.poll();
                radiant.offer(radiant.poll() + n);
            } else {
                radiant.poll();
                dire.offer(dire.poll() + n);
            }
        }
        // 当某一阵营的议员全被投票出去时跳出循环
        return radiant.size() > 0 ? "Radiant" : "Dire";
    }

}

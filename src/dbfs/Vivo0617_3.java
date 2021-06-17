package dbfs;

import utils.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Ray
 * @Date 2021/6/17 23:12
 * @Description 06/17 Vivo提前批笔试第三题
 */
public class Vivo0617_3 {

    Map<Integer, Node> nodeMap;

    public Vivo0617_3() {
        nodeMap = new HashMap<>();
    }

    /**
     * 计算整个流程的最小花费时间
     * @param times 节点耗时列表
     * @param depStrList 节点依赖列表
     * @return
     */
    public int minCost(List<Integer> times, List<String> depStrList) {
        buildMap(depStrList, times);
        List<Integer> endNodes = findEnd();
        int minTime = Integer.MIN_VALUE;
        for (int index : endNodes) {
            minTime = Math.max(minTime, minTime(index));
        }
        return minTime;
    }

    /**
     * 计算当前节点完成的所需的最小时间
     * @param index
     * @return
     */
    private int minTime(int index) {
        Node cur = nodeMap.get(index);
        if (cur.inDegree == 0) {
            return cur.cost;
        }
        int minTime = Integer.MIN_VALUE;
        for (int pre : cur.dependence) {
            minTime = Math.max(minTime, minTime(pre));
        }
        return minTime + cur.cost;
    }

    /**
     * 找入度为0的节点列表
     * @return
     */
    private List<Integer> findEnd() {
        List<Integer> res = new ArrayList<>();
        for (int i : nodeMap.keySet()) {
            Node node = nodeMap.get(i);
            if (node.outDegree == 0) {
                res.add(i);
            }
        }
        return res;
    }

    /**
     * 构建节点map
     * @param strs
     */
    private void buildMap(List<String> strs, List<Integer> times) {
        // 对每个节点新建一个Node对象，并存入map中
        for (int i = 1; i <= strs.size(); ++i) {
            Node node = new Node();
            node.cost = times.get(i-1);
            nodeMap.put(i, node);
        }
        // 统计各节点的出度以及被依赖情况
        for (int i = 1; i <= strs.size(); ++i) {
            String str = strs.get(i-1);
            if (!str.equals("0")) {
                List<Integer> dep = Arrays.stream(str.split(",")).map(StringUtils::atoi).collect(Collectors.toList());
                Node cur = nodeMap.get(i);
                for (int index : dep) {
                    // 将依赖于当前节点的节点，添加当前节点为依赖
                    Node tmp = nodeMap.get(index);
                    tmp.dependence.add(i);
                    ++tmp.inDegree;
                    // 统计当前节点的出度
                    ++cur.outDegree;
                }
            }
        }
    }

    /**
     * 节点
     */
    static class Node {
        /**
         * 当前节点依赖的节点列表
         */
        List<Integer> dependence;
        /**
         * 当前节点的出度
         */
        int outDegree;
        /**
         * 当前节点的入度
         */
        int inDegree;
        /**
         * 当前节点的花费
         */
        int cost;

        Node() {
            this.dependence = new ArrayList<>();
            this.outDegree = 0;
            this.inDegree = 0;
        }
    }

}

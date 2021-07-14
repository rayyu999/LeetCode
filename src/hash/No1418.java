package hash;

import java.util.*;

/**
 * @Author Ray
 * @Date 2021/7/14 21:55
 * @Description 1418. 点菜展示表
 */
public class No1418 {

    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<Integer, Map<String, Integer>> map = new TreeMap<>();
        Set<String> foods = new TreeSet<>();
        for (List<String> order : orders) {
            int tableNum = Integer.parseInt(order.get(1));
            String food = order.get(2);
            Map<String, Integer> table = map.getOrDefault(tableNum, new HashMap<>());
            int cnt = table.getOrDefault(food, 0);
            table.put(food, cnt+1);
            foods.add(food);
            map.put(tableNum, table);
        }
        List<List<String>> res = new LinkedList<>();
        res.add(new LinkedList<>(foods));
        res.get(0).add(0, "Table");
        for (int key : map.keySet()) {
            Map<String, Integer> table = map.get(key);
            List<String> list = new LinkedList<>();
            list.add(String.valueOf(key));
            for (String food : foods) {
                int cnt = table.getOrDefault(food, 0);
                list.add(String.valueOf(cnt));
            }
            res.add(list);
        }
        return res;
    }

}

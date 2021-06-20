package design;

import java.util.*;

/**
 * @Author Ray
 * @Date 2021/6/20 20:27
 * @Description 1600.王位继承顺序
 */
public class ThroneInheritance {

    String kingName;
    Set<String> death;
    Map<String, List<String>> parents;

    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
        death = new HashSet<>();
        parents = new HashMap<>();
        parents.put(kingName, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {
        parents.get(parentName).add(childName);
        parents.put(childName, new ArrayList<>());
    }

    public void death(String name) {
        death.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> curOrder = new ArrayList<>();
        successor(kingName, curOrder);
        return curOrder;
    }

    private void successor(String x, List<String> curOrder) {
        if (!death.contains(x)) {
            curOrder.add(x);
        }
        for (String child : parents.get(x)) {
            successor(child, curOrder);
        }
    }

}

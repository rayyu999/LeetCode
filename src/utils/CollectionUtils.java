package utils;

import java.util.List;

/**
 * @Author Ray
 * @Date 2021/6/17 23:22
 * @Description TODO
 */
public class CollectionUtils {

    /**
     * Integer列表转int数组
     * @param list Integer列表
     * @return
     */
    public static int[] intListToArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

}

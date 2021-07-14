package binsearch;

/**
 * @Author Ray
 * @Date 2021/7/14 21:52
 * @Description 275. H 指数 II
 */
public class No275 {

    public int hIndex(int[] citations) {
        int len = citations.length;
        int l = 0, r = len-1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            // 升序排序，所以一共有len-mid篇文章的引用次数大于等于citations[mid]
            // 至少有len-mid篇文章被引用了citations[mid]次，继续往h指数高的方向搜索
            if (citations[mid] >= len - mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        // 引用次数大于等于citations[l]的文章一共有len-l篇
        return len - l;
    }

}

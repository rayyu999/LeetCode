package dp;

/**
 * @Author Ray
 * @Date 2021/7/1 23:13
 * @Description 740.删除并获得点数
 */
public class No740 {

    public int deleteAndEarn(int[] nums) {
        int[] arr = new int[10001];
        for (int num : nums) {
            arr[num] += num;
        }
        int yes = arr[0], no = 0, max = arr[0];
        for (int i = 0; i <= 10000; ++i) {
            int curYes = no + arr[i];
            int curNo = Math.max(yes, no);
            max = Math.max(max, Math.max(curYes, curNo));
            yes = curYes;
            no = curNo;
        }
        return max;
    }

}

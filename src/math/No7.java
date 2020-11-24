package math;

public class No7 {

    public int reverse(int x) {
        int ans = 0;
        while(x != 0) {
            int pop = x % 10;   // 每次将末尾位弹出放在答案的首位
            // 判断是否越界
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }

}

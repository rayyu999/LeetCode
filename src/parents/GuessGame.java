package parents;

/**
 * @Author Ray
 * @Date 2021/6/14 19:41
 * @Description 猜数字游戏抽象
 */
public class GuessGame {

    private final int pick;

    /**
     * 构造方法
     * @param pick 选择的数字
     */
    public GuessGame(int pick) {
        this.pick = pick;
    }

    /**
     * 判断猜的数字与选择的数字的大小
     * @param num 玩家选择的数字
     * @return
     */
    public int guess(int num) {
        if (num == this.pick) {
            return 0;
        } else if (num < this.pick) {
            return 1;
        }
        return -1;
    }

}

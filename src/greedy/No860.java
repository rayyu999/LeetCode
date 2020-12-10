package greedy;

public class No860 {

    public boolean lemonadeChange(int[] bills) {
        int[] cash = new int[2];    // 第一个数表示5美元的数量，第二个数表示10美元的数量
        for (int bill : bills) {
            // 按收到的零钱分类讨论
            switch (bill) {
                case 5:
                    ++cash[0];
                    break;
                case 10:
                    if (cash[0] == 0) return false;
                    --cash[0];
                    ++cash[1];
                    break;
                case 20:
                    // 先找10块，没有再全用5块找
                    if (cash[1] > 0 && cash[0] > 0) {
                        --cash[0];
                        --cash[1];
                    } else if (cash[1] == 0 && cash[0] > 2) {
                        cash[0] -= 3;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }

}

package math;

import java.util.Random;

public class No470 {

    /**
     * 公式法
     * @return
     */
    public int rand10_eql() {
        while (true) {
            int num = (rand7() - 1) * 7 + rand7();
            if (num <= 40) return num % 10 + 1;
        }
    }

    /**
     * 枚举法
     * @return
     */
    public int rand10_enum() {
        while (true) {
            int a = rand7();
            int b = rand7();
            if (a > 4 && b < 4) {
                continue;
            }
            return (a + b) % 10 + 1;
        }
    }

    private int rand7() {
        Random random = new Random();
        return random.nextInt(8);
    }

}

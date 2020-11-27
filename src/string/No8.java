package string;

public class No8 {

    public int myAtoi(String str) {
        int res = 0, index = 0;
        // 跳过前面多余的空格
        while (index < str.length() && str.charAt(index) == ' ') ++index;
        if (index != str.length()) {
            int signed = 0;
            while (index < str.length()) {
                char c = str.charAt(index);
                if (c == '+' || c == '-') {
                    if (signed != 0) return res;    // 之前已经确定了符号的情况
                    if (c == '+') signed = 1;
                    else signed = -1;
                } else if (c >= '0' && c <= '9') {
                    if (signed == 0) signed = 1;
                    int pop = (c - '0') * signed;
                    // 判断是否越界
                    if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7))
                        return Integer.MAX_VALUE;
                    if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8))
                        return Integer.MIN_VALUE;
                    res = res * 10 + pop;
                } else
                    return res;
                ++index;
            }
        }
        return res;
    }

    public int myAtoi_status(String str) {
        int status = 1, index = 0, res = 0, signal = 1;
        while (index < str.length()) {
            char c = str.charAt(index);
            status = changeStatus(status, c);
            if (status == 2 && c == '-') signal = -1;
            if (status == 4) break;
            if (status == 3) {
                int pop = Character.getNumericValue(c) * signal;
                // 判断是否越界
                if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7))
                    return Integer.MAX_VALUE;
                if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8))
                    return Integer.MIN_VALUE;
                res = res * 10 + pop;
            }
            index++;
        }
        return res;
    }

    private int changeStatus(int status, char c) {
        switch (status) {
            case 1:     // 起始状态
                if(c == ' ') return 1;
                if(c == '+' || c == '-') return 2;
                if(c <= '9' && c >= '0') return 3;
                return 4;
            case 2:     // 有符号状态
                if(c <= '9' && c >= '0') return 3;
                return 4;
            case 3:     // 插入数字状态
                if(c <= '9' && c >= '0') return 3;
                return 4;
        }
        return 4;
    }

}

package string;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Ray
 * @Date 2021/6/20 21:48
 * @Description 65.有效数字
 */
public class No65 {

    public boolean isNumber(String s) {
        Map<State, Map<CharType, State>> transfer = buildMap();
        State state = State.UNSIGNED;
        for (char c : s.toCharArray()) {
            Map<CharType, State> stateMap = transfer.get(state);
            CharType charType = getCharType(c);
            state = stateMap.getOrDefault(charType, State.ELSE);
            if (state == State.ELSE) {
                return false;
            }
        }
        return state != State.SIGNED && state != State.POINT_WITHOUT_INT && state != State.EXP && state != State.EXP_SIGN;
    }

    private Map<State, Map<CharType, State>> buildMap() {
        Map<State, Map<CharType, State>> transfer = new HashMap<>();
        // 初始状态的转换
        Map<CharType, State> unsigned = new HashMap<CharType, State>() {{
            put(CharType.SIGN, State.SIGNED);
            put(CharType.NUMBER, State.INTEGER);
            put(CharType.POINT, State.POINT_WITHOUT_INT);
        }};
        transfer.put(State.UNSIGNED, unsigned);
        // 有符号状态的转换
        Map<CharType, State> signed = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.INTEGER);
            put(CharType.POINT, State.POINT_WITHOUT_INT);
        }};
        transfer.put(State.SIGNED, signed);
        // 整数状态的转换
        Map<CharType, State> integer = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.INTEGER);
            put(CharType.POINT, State.POINT);
            put(CharType.EXP, State.EXP);
        }};
        transfer.put(State.INTEGER, integer);
        // 小数点状态没有整数状态的转换
        Map<CharType, State> point = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.FRACTION);
            put(CharType.EXP, State.EXP);
        }};
        transfer.put(State.POINT, point);
        // 小数点左侧没有整数状态的转换
        Map<CharType, State> pointWithoutInt = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.FRACTION);
        }};
        transfer.put(State.POINT_WITHOUT_INT, pointWithoutInt);
        // 小数状态的转换
        Map<CharType, State> fraction = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.FRACTION);
            put(CharType.EXP, State.EXP);
        }};
        transfer.put(State.FRACTION, fraction);
        // 字符e状态的转换
        Map<CharType, State> exp = new HashMap<CharType, State>() {{
            put(CharType.SIGN, State.EXP_SIGN);
            put(CharType.NUMBER, State.EXP_NUM);
        }};
        transfer.put(State.EXP, exp);
        // 指数符号状态的转换
        Map<CharType, State> expSign = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.EXP_NUM);
        }};
        transfer.put(State.EXP_SIGN, expSign);
        // 指数数字状态的转换
        Map<CharType, State> expNum = new HashMap<CharType, State>() {{
            put(CharType.NUMBER, State.EXP_NUM);
        }};
        transfer.put(State.EXP_NUM, expNum);
        return transfer;
    }

    private CharType getCharType(char c) {
        if (c >= '0' && c <= '9') {
            return CharType.NUMBER;
        }
        if (c == '-' || c == '+') {
            return CharType.SIGN;
        }
        if (c == '.') {
            return CharType.POINT;
        }
        if (c == 'E' || c == 'e') {
            return CharType.EXP;
        }
        return CharType.ELSE;
    }

    enum State {
        UNSIGNED,
        SIGNED,
        INTEGER,
        POINT,
        POINT_WITHOUT_INT,
        FRACTION,
        EXP,
        EXP_SIGN,
        EXP_NUM,
        ELSE
    }

    enum CharType {
        SIGN,
        NUMBER,
        EXP,
        POINT,
        ELSE
    }

}

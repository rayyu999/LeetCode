package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Ray
 * @Date 2021/6/17 23:15
 * @Description 字符串工具类
 */
public class StringUtils {

    /**
     * 字符串转数字
     * @param s 字符串
     * @return 对应的数字
     */
    public static int atoi(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            res = res * 10 + (s.charAt(i) - '0');
        }
        System.out.println(res);
        return res;
    }

    /**
     * 将用分隔符分割的整数字符串转换为列表
     * @param s 整数字符串
     * @param separator 分隔符
     * @return 整数列表
     */
    public static List<Integer> splitStringToInteger(String s, String separator) {
        return Arrays.stream(s.split(separator)).map(StringUtils::atoi).collect(Collectors.toList());
    }

    /**
     * 整数转字符串
     * @param i 整数
     * @return 对应的字符串
     */
    public static String itoa(Integer i) {
        StringBuilder sb = new StringBuilder();
        if (i > 0) {
            while (i > 0) {
                sb.append((char)(i%10 + '0'));
                i /= 10;
            }
        } else {
            sb.append('0');
        }
        return sb.reverse().toString();
    }

}

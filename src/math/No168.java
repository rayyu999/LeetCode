package math;

/**
 * @Author Ray
 * @Date 2021/7/1 23:11
 * @Description 168.Excel表列名称
 */
public class No168 {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        if (columnNumber <= 0) {
            return "";
        }
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char) ('A' + columnNumber%26));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

}

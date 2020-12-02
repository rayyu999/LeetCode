package string;

public class JZOffer5 {

    /**
     * 遍历法
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        int len = s.length();
        String res = "";
        for (int i = 0; i < len; ++i) {
            if (s.charAt(i) == ' ') res += "%20";
            else res += s.charAt(i);
        }
        return res;
    }

    /**
     * 使用函数的方法
     * @param s
     * @return
     */
    public String replaceSpace_useFunc(String s) {
        return s.replace(" ","%20");
    }

}

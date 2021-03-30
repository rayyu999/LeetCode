package string;

import java.util.Stack;

public class JZOffer58_1 {

    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                str.append(c);
            } else if (str.length() != 0){
                // 需要排除访问到多个连续空格的情况
                stack.push(str.toString());
                str.delete(0, str.length());
            }
        }
        while (!stack.isEmpty()) {
            if (str.length() != 0) {
                str.append(" ");
            }
            str.append(stack.pop());
        }
        return str.toString();
    }

}

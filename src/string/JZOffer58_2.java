package string;

import java.util.Stack;

public class JZOffer58_2 {

    public String reverseLeftWords(String s, int n) {
        // 先分别将第一第二部分翻转
        s = reverse(s.substring(0, n)) + reverse(s.substring(n));
        // 再将整个字符串翻转
        return reverse(s);
    }

    private String reverse(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            stack.push(c);
        }
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        return str.toString();
    }

}

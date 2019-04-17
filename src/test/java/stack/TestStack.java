package stack;

import org.junit.Test;

/**
 * @author songwb
 * @date 2019/4/11 17:23
 */
public class TestStack {
    @Test
    public void test1() {
        Stack<String> stack = new Stack<>();
        for (int i =0; i < 20; i ++) {
            stack.push(String.valueOf(i));

        }
        System.out.println(stack);
        for (int i = 0; i < 10; i ++) {
            System.out.println(stack.pop());
        }
        System.out.println(stack);
    }

    @Test
    public void test2() {
        String str1 = "{()[]}";
        System.out.println(TestStack.isValid(str1));
    }
    public static boolean isValid(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                Character pop = stack.pop();
                if (c.equals('{') && pop.equals('}')) {
                    return true;
                }
                if (c.equals('[') && pop.equals(']')) {
                    return true;
                }
                if (c.equals('(') && pop.equals(')')) {
                    return true;
                }
            }
        }
        return stack.empty();
    }
}

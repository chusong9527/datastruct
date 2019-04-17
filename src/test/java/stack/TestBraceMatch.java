package stack;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * @author songwb
 * @date 2019/4/9 16:28
 */
public class TestBraceMatch {

    @Test
    public void test1() {
        String str1 = "{()[]}";
        System.out.println(TestBraceMatch.isValid(str1));
//        new Queue<>();
//        new LinkedList<>();
//        Set

    }

    /**
     * 验证括号是否合法  {()[]}
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
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

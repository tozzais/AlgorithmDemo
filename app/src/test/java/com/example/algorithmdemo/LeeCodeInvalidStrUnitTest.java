package com.example.algorithmdemo;

import org.junit.Test;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 注意：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 */
public class LeeCodeInvalidStrUnitTest {
    @Test
    public void test() {
        String s = "()[]{}";
        System.out.println(isValid(s));


    }


    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();


    }

    public String remove(String s,int i,int j){
        StringBuffer stringBuffer = new StringBuffer();
        for (int k = 0; k < s.length(); k++) {
            if (k != i && k != j){
                char c = s.charAt(k);
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();

    }

    public boolean isEqual(char c,char c1){
        return (c == '[' && c1 == ']') || (c == '{' && c1 == '}')|| (c == '(' && c1 == ')');

    }




}
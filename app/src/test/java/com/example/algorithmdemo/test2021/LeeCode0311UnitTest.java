package com.example.algorithmdemo.test2021;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;


/**
 * 227. 基本计算器 II
 */
public class LeeCode0311UnitTest {
    @Test
    public void test() {
        System.out.println(calculate(" 3 5 / 2 "));
    }

    public int calculate(String s) {
        int sum = 0; //总和
        int subSum; //总和
        int flag = 1;//加 或者 减
        int length = s.length();
        int i = 0;
        while (i<length){
            char c = s.charAt(i);
            if (c == ' '){
                i++;
            }else if (c == '+'){
                flag = 1;
                i++;
            }else if (c == '-'){
                flag = -1;
                i++;
            }else{
                subSum = 1;
                int isMul = 0;
                while (i<length && s.charAt(i) != '+' && s.charAt(i) != '-'){
                    if (s.charAt(i) == ' '){
                        i++;
                    }else if (s.charAt(i) == '*'){
                        isMul = 1;
                        i++;
                    }else if (s.charAt(i) == '/'){
                        isMul = 2;
                        i++;
                    }else {
                        int num = 0;
                        while (i < length && (Character.isDigit(s.charAt(i)) || s.charAt(i) == ' ' )) {
                            if (s.charAt(i) != ' ') {
                                num = num * 10 + s.charAt(i) - '0';
                            }
                            i++;
                        }
                        if (isMul == 0){
                            subSum = num;
                        }else if (isMul == 1){
                            subSum *= num;
                        }else {
                            subSum /= num;
                        }
                    }
                }
                sum = sum + subSum*flag;
            }

        }
        return sum;


    }


        public int calculate1(String s) {
            Deque<Integer> stack = new LinkedList<Integer>();
            char preSign = '+';
            int num = 0;
            int n = s.length();
            for (int i = 0; i < n; ++i) {
                if (Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                }
                if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                    switch (preSign) {
                        case '+':
                            stack.push(num);
                            break;
                        case '-':
                            stack.push(-num);
                            break;
                        case '*':
                            stack.push(stack.pop() * num);
                            break;
                        default:
                            stack.push(stack.pop() / num);
                    }
                    preSign = s.charAt(i);
                    num = 0;
                }
            }
            int ans = 0;
            while (!stack.isEmpty()) {
                ans += stack.pop();
            }
            return ans;
        }






}
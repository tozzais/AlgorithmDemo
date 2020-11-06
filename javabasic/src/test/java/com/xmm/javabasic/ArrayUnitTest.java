package com.xmm.javabasic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ArrayUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    public class Node {
        //数据域
        public int data;
        //指针域，指向下一个节点
        public Node next;

        public Node() {
        }
        public Node(int data) {
            this.data = data;
        }
        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public class Stack {
        // 栈顶
        public Node stackTop;
        // 栈底
        public Node stackBottom;

        public Stack(Node stackTop, Node stackBottom) {
            this.stackTop = stackTop;
            this.stackBottom = stackBottom;
        }

        public Stack() {
        }

    }

    /**
     * 进栈
     * @param stack
     * @param value
     */
    public  void pushStack(Stack stack, int value) {

        // 封装数据成节点
        Node newNode = new Node(value);

        // 栈顶本来指向的节点交由新节点来指向
        newNode.next = stack.stackTop;

        // 栈顶指针指向新节点
        stack.stackTop = newNode;
    }

    /**
     * 遍历栈
     * @param stack
     */
    public static void traverse(Stack stack) {
        Node stackTop = stack.stackTop;
        //栈顶元素的指针不指向栈底，那么就一直输出遍历结果
        while (stackTop != stack.stackBottom) {
            System.out.println("栈数据：" + stackTop.data);
            stackTop = stackTop.next;
        }

    }
    /**
     * 出栈(将栈顶的指针指向下一个节点)
     * @param stack
     */
    public static void popStack(Stack stack) {
        // 栈不为空才能出栈
        if (stack.stackTop != stack.stackBottom) {
            //栈顶元素
            Node top = stack.stackTop;
            // 栈顶指针指向下一个节点
            stack.stackTop = top.next;
            System.out.println("栈数据：" + top.data);
        }
    }
}
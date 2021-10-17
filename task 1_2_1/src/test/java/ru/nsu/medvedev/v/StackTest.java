package ru.nsu.medvedev.v;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class StackTest {
    MyStack<Integer> stack;

    @BeforeEach
    private void newStack() {
        stack = new MyStack<>();
    }

    @Test
    public void some_test() {
        stack.push(15);
        stack.push(1);
        stack.push(3);
        int size = stack.count();
        int var1 = stack.pop();
        int var2 = stack.pop();
        int var3 = stack.pop();
        Assertions.assertEquals(3, size);
        Assertions.assertEquals(var1, 3);
        Assertions.assertEquals(var2, 1);
        Assertions.assertEquals(var3, 15);
        Assertions.assertEquals(0, stack.count());
    }

    @Test
    public void stack_push() {
        stack.push(1);
        MyStack<Integer> newstack = new MyStack<>();
        newstack.push(3);
        newstack.push(12);
        newstack.push(7);
        stack.pushStack(newstack);
        int var1 = stack.pop();
        int var2 = stack.pop();
        Assertions.assertEquals(var1, 7);
        Assertions.assertEquals(var2, 12);
    }

    @Test
    public void pushstack_test() {
        MyStack<Integer> stack2 = new MyStack<>();
        stack.push(12);
        stack.push(11);
        stack2.push(10);
        stack2.push(9);
        stack.push(1);
        stack.pushStack(stack2);
        Assertions.assertEquals(5, stack.count());
        Assertions.assertEquals(9, stack.pop());
        Assertions.assertEquals(10, stack.pop());
        Assertions.assertEquals(1, stack.pop());
        Assertions.assertEquals(2, stack.count());
    }

    @Test
    void popStack() {
        stack.push(4);
        stack.push(7);
        stack.push(1);
        MyStack<Integer> stack2 = stack.popStack(3);
        Assertions.assertEquals(1, stack2.pop());
        Assertions.assertEquals(7, stack2.pop());
        Assertions.assertEquals(4, stack2.pop());
        Assertions.assertEquals(0, stack2.count());
    }

    @Test
    void popStack_exception() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {stack.popStack(-1);});
    }

    @Test
    void pop_exception() {
        stack.push(1);
        stack.pop();
        Assertions.assertThrows(NoSuchElementException.class, () -> {stack.pop();});
    }
}

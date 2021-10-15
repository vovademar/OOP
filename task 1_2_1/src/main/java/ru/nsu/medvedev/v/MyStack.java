package ru.nsu.medvedev.v;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyStack<T> implements Iterable<T> {
    private int size = 0;
    private T[] arr;
    final private int MULTY = 2;
    final private int STACKSIZE = 10;
    @SuppressWarnings("unchecked")

    public MyStack() {
        arr = (T[]) new Object[STACKSIZE];
    }

    public void push(T el) {
        increase(size + 1);
        arr[size] = el;
        size++;
    }

    public T pop() {
        if (size <= 0) {
            throw new EmptyStackException();
        }
        size--;
        return arr[size];
    }

    private void increase(int n) {
        while (arr.length < n) {
            arr = Arrays.copyOf(arr, arr.length * MULTY);
        }
    }

    public void pushStack(MyStack<T> stack) {
        increase(size + stack.size);
        System.arraycopy(stack.arr, 0, arr, size, stack.size);
        size += stack.size;
    }

    public int count() {
        return size;
    }

    public MyStack<T> popStack(int ps) {
        if (ps > size || ps < 0) {
            throw new NoSuchElementException();
        }
        MyStack<T> stack = new MyStack<>();
        stack.increase(ps);
        System.arraycopy(this.arr, 0, stack.arr, 0, ps);
        stack.size = ps;
        this.size -= ps;
        return stack;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T> {
        int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size;
        }

        @Override
        public T next() {
            cursor += 1;
            return arr[cursor - 1];
        }
    }
}

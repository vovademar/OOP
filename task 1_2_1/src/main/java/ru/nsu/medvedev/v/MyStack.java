package ru.nsu.medvedev.v;

import java.util.Arrays;

public class MyStack<T> {
    private int size = 0;
    private T[] arr;
    final private int MULTY = 2;

    public MyStack() {
        arr = (T[]) new Object[10];
    }

    public void push(T el) {
        increase(size + 1);
        arr[size] = el;
        size++;
    }

    public T pop(){
        if (size <= 0) {
            throw new IndexOutOfBoundsException();
        }
        size--;
        return arr[size];
    }

    private void increase(int n) {
        while (arr.length < n) {
            arr = Arrays.copyOf(arr, arr.length * MULTY);
        }
    }

    public void pushStack(MyStack<T> stack){
        increase(size + stack.size);
        System.arraycopy(stack.arr, 0, arr, size, stack.size);
        size += stack.size;
    }

    public T[] popStack(int ps){
        if(ps>size || size < 0){
            throw new IndexOutOfBoundsException();
        }
        for(int i=0;i<ps;i++){
            pop();
        }
        return arr;
    }

    public int count(){
        return size;
    }


}

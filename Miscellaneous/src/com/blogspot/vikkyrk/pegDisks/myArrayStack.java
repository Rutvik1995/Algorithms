package com.blogspot.vikkyrk.pegDisks;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class myArrayStack<T> implements myStack<T> {

    private ArrayList<T> stack = new ArrayList<T>();

    public myArrayStack(int n) {
        stack.ensureCapacity(n);
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public void push(T t) {
        stack.add(t);
    }

    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public T peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

    @Override
    public void clear() {
        stack.clear();
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
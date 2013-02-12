package com.blogspot.vikkyrk.pegDisks;

import java.util.EmptyStackException;

public interface myStack<T> {
    public int size();

    public void push(T t);

    public T pop() throws EmptyStackException;

    public boolean isEmpty();

    public T peek() throws EmptyStackException;

    public void clear();
}

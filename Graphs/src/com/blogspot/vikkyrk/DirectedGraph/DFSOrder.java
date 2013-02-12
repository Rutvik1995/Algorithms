package com.blogspot.vikkyrk.DirectedGraph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFSOrder {
    private boolean[] marked;

    private Queue<Integer> preOrder = null;
    private Queue<Integer> postOrder = null;
    private Stack<Integer> reversePostOrder = null;

    public DFSOrder(DirectedGraph dGr) {
        marked = new boolean[dGr.V()];
        for (int i = 0; i < dGr.V(); i++) {
            marked[i] = false;
        }

        preOrder = new LinkedList<Integer>();
        postOrder = new LinkedList<Integer>();
        reversePostOrder = new Stack<Integer>();

        for (int i = 0; i < dGr.V(); i++) {
            if (!marked[i])
                DepthFirstSearchRecursive(dGr, i);
        }
        /*
         * This is need since Stack Iterator outputs elements from the bottom of
         * the stack.
         */
        Stack<Integer> temp = new Stack<Integer>();
        while (!reversePostOrder.isEmpty()) {
            temp.push(reversePostOrder.pop());
        }

        reversePostOrder = temp;
        temp = null;

    }

    public Iterable<Integer> preOrder() {
        return preOrder;
    }

    public Iterable<Integer> postOrder() {
        return postOrder;
    }

    public Iterable<Integer> reversePostOrder() {
        return reversePostOrder;
    }

    private void DepthFirstSearchRecursive(DirectedGraph dGr, int s) {
        preOrder.add(s);
        marked[s] = true;
        for (int i : dGr.adj(s)) {
            if (marked[i] == false) {
                DepthFirstSearchRecursive(dGr, i);
            }
        }

        postOrder.add(s);
        reversePostOrder.push(s);
    }
}

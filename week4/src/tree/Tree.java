package tree;


import javax.management.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Tree {
    private Node root;

    public void traverse(Node node) {
        if (node != null) {
            traverse(node.R);
            traverse(node.L);
            visit(node);
        }
    }

    public boolean exists(int key) {
        Node r = this.root;
        while (r != null && key != r.key) {
            if (key < r.key) {
                r = r.L;
            } else {
                r = r.R;
            }
        }
        return r != null;
    }

    public void remove(int key) {
        Node r = this.root;
        while (r != null && key != r.key) {
            if (key < r.key) {
                r = r.L;
            } else {
                r = r.R;
            }
        }
        if (r != null) {
            //todo
        }
    }

    private void visit(Node node) {
        System.out.println(node.key);
    }


    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);

        Node n5 = new Node(5, null, null);
        Node n7 = new Node(7, null, null);
        Node n6 = new Node(6, n5, n7);

        Node n4 = new Node(4, n2, n6);

        Node n9 = new Node(9, null, null);
        Node n11 = new Node(11, null, null);
        Node n10 = new Node(10, n9, n11);

        Node n13 = new Node(13, null, null);
        Node n15 = new Node(15, null, null);
        Node n14 = new Node(14, n13, n15);

        Node n12 = new Node(12, n10, n14);
        Node n8 = new Node(8, n4, n12);

        Tree tree = new Tree(n8);

        tree.traverse(n8);
    }

    public Tree(Node root) {
        this.root = root;
    }

    //start is inklusive, end is exklusive
    public Node buildTree(int[] sorted, int start, int end) {
        if (end > start) {
            int median = start >> 1 + end >> 1;
            return new Node(
                    sorted[median],
                    buildTree(sorted, start, median),
                    buildTree(sorted, median + 1, end)
            );
        }

        return null;
    }


    //public void traverseLevelOrder(Node node) { todo how to use queue
    //    Queue q = new Queue();
    //    q.push(node);
    //
    //    while (!q.isEmpty()) {
    //        Node current = q.pop();
    //        if (current.L != null) {
    //            q.push(current.L);
    //        }
    //        if (current.R != null) {
    //            q.push(current.R);
    //        }
    //        visit(current);
    //    }
    //}

    // macht es nicht richtig
    //public void traverseLevelOrder2(Node node) {
    //    if (node == null) {
    //        return;
    //    }
    //
    //    Stack q = new Stack();
    //    q.push(node);
    //
    //    while (!q.isEmpty()) {
    //        Node current = (Node) q.pop();
    //        if (current.L != null) {
    //            q.push(current.L);
    //        }
    //        if (current.R != null) {
    //            q.push(current.R);
    //        }
    //        visit(current);
    //    }
    //}

    private static class Node {
        int key;
        Node L;
        Node R;

        public Node(int key, Node L, Node R) {
            this.key = key;
            this.L = L;
            this.R = R;
        }
    }

}

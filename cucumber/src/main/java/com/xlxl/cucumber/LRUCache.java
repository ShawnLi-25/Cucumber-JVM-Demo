package com.xlxl.cucumber;

import java.util.HashMap;

public class LRUCache {
    private final HashMap<Integer, Node> cache = new HashMap<Integer, Node>();

    private final Node dummyHead = new Node();
    private final Node dummyTail = new Node();

    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        joinNode(dummyHead, dummyTail);
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        eraseNode(node);
        addHead(node);
        return node.val;
    }

    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.val = val;
            eraseNode(node);
            addHead(node);
        } else {
            if (cache.size() == capacity) {
                Node erasedNode = dummyTail.pre;
                if (erasedNode != dummyHead) {
                    cache.remove(erasedNode.key);
                    eraseNode(erasedNode);
                }
            }
            Node node = new Node(key, val);
            addHead(node);
            cache.put(key, node);
        }
    }

    public int size() {
        return cache.size();
    }

    public int head() {
        return dummyHead.nex.val;
    }

    public int tail() {
        return dummyTail.pre.val;
    }

    public void printCache() {
        Node cur = dummyHead;
        while (cur.nex != null) {
            System.out.println(cur.nex.key);
            cur = cur.nex;
        }
    }

    private void addHead(Node newHead) {
        Node preHead = dummyHead.nex;
        joinNode(dummyHead, newHead);
        joinNode(newHead, preHead);
    }

    private void joinNode(Node prev, Node next) {
        prev.nex = next;
        next.pre = prev;
    }

    public void eraseNode(Node node) {
        node.pre.nex = node.nex;
        node.nex.pre = node.pre;
    }

    static class Node {
        int key;
        int val;
        Node pre, nex;

        public Node() {
            this.key = -1;
            this.val = -1;
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

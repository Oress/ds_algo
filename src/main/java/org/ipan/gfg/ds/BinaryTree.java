package org.ipan.gfg.ds;

import java.util.*;

public class BinaryTree<KEY> {
    int modificationCount = 1;
    protected BTNode<KEY> root;

    protected BinaryTree() {
    }

    public static <KEY extends Comparable<KEY>> BinaryTree<KEY> fromHeapArray(KEY[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException();

        BinaryTree<KEY> result = new BinaryTree<>();
        result.root = new BTNode<>(arr[0]);
        Deque<Pair<Integer, BTNode<KEY>>> stack = new ArrayDeque<>();
        stack.addLast(new Pair<>(0, result.root));

        while (!stack.isEmpty()) {
            Pair<Integer, BTNode<KEY>> pair = stack.removeLast();
            BTNode<KEY> currentNode = pair.getItem2();
            int left = 2 * pair.getItem1() + 1;
            int right = left + 1;

            if (right < arr.length) {
                BTNode<KEY> rightNode = new BTNode<>(arr[right], currentNode);
                currentNode.right = rightNode;
                stack.addLast(new Pair<>(right, rightNode));
            }

            if (left < arr.length) {
                BTNode<KEY> leftNode = new BTNode<>(arr[left], currentNode);
                currentNode.left = leftNode;
                stack.addLast(new Pair<>(left, leftNode));
            }
        }

        return result;
    }

    public boolean search(KEY searchFor) {
        return searchNode(searchFor) != null;
    }

    protected BTNode<KEY> searchNode(KEY searchFor) {
        BTNode<KEY> result = null;
        for (PreOrderTraversalIterator it = preOrderTraversal(); it.hasNext(); ) {
            BTNode<KEY> item = it.nextInternal();
            if (searchFor.equals(item.key)) {
                result = item;
                break;
            }
        }
        return result;
    }

    public int getSize() {
        int size = 0;
        for (Iterator<KEY> it = preOrderTraversal(); it.hasNext(); ) {
            it.next();
            size++;
        }
        return size;
    }


    public PreOrderTraversalIterator preOrderTraversal() {
        return new PreOrderTraversalIterator();
    }

/*    public Iterator<BTNode<KEY>> inOrderTraversal() {

    }

    public Iterator<BTNode<KEY>> postOrderTraversal() {

    }*/

    protected static class BTNode<NK> {
        protected NK key;
        protected BTNode<NK> parent;
        protected BTNode<NK> left;
        protected BTNode<NK> right;

        public BTNode(NK key) {
            this.key = key;
        }

        public BTNode(NK key, BTNode<NK> parent) {
            this.key = key;
            this.parent = parent;
        }

        public BTNode(BTNode<NK> src) {
            this.parent = src.parent;
            this.key = src.key;
            this.left = src.left;
            this.right = src.right;
        }

    }

    protected class PreOrderTraversalIterator implements Iterator<KEY> {
        final int modCount = modificationCount;

        private final Deque<BTNode<KEY>> stack = new ArrayDeque<>();

        PreOrderTraversalIterator() {
            stack.addLast(root);
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public KEY next() {
            BTNode<KEY> node = nextInternal();
            return node.key;
        }

        protected BTNode<KEY> nextInternal() {
            if (modCount != modificationCount) {
                throw new ConcurrentModificationException();
            }
            BTNode<KEY> item = stack.removeLast();
            if (item.right != null) stack.addLast(item.right);
            if (item.left != null) stack.addLast(item.left);
            return item;
        }
    }
}

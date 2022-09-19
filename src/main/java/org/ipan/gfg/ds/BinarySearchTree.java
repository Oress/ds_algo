package org.ipan.gfg.ds;

import java.util.*;

/**
 * A binary Search Tree(BST) is a node-based binary tree data structure which has the following properties:
 * <p>
 * The left subtree of a node contains only nodes with keys lesser than the node’s key.
 * The right subtree of a node contains only nodes with keys greater than the node’s key.
 * The left and right subtree each must also be a binary search tree.
 * There must be no duplicate nodes.
 */
public class BinarySearchTree<KEY extends Comparable<KEY>> extends BinaryTree<KEY> {
    private final Comparator<KEY> comparator;

    public BinarySearchTree() {
        this.comparator = Comparator.comparing(it -> it);
    }

    public BinarySearchTree(Comparator<KEY> comparator) {
        this.comparator = comparator;
    }

    // Time complexity O(n) - worst case (degraded tree, i.e. linked list case)
    public void insert(KEY item) {
        if (root == null) {
            root = new BTNode<>(item);
            return;
        }

        BTNode<KEY> temp = root;
        while (true) {
            int compRes = comparator.compare(item, temp.key);
            if (compRes == 0) {
                throw new IllegalArgumentException();
            } else if (compRes < 0) {
                if (temp.left == null) {
                    temp.left = new BTNode<>(item, temp);
                    break;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right == null) {
                    temp.right = new BTNode<>(item, temp);
                    break;
                } else {
                    temp = temp.right;
                }
            }
        }
    }

    // ???
    // 3 cases:
    // 1 - leaf
    // 2 - 1 child
    // 3 - 2 children
    public void delete(KEY item) {

    }

    public KEY min() {
        BTNode<KEY> btNode = minNode();
        return btNode != null ? btNode.key : null;
    }

    private BTNode<KEY> minNode() {
        BTNode<KEY> temp = root;
        while (temp.left != null) temp = temp.left;
        return temp;
    }

    public KEY max() {
        KEY result = null;
        BTNode<KEY> temp = root;
        while (temp.right != null) temp = temp.right;
        result = temp.key;
        return result;
    }

    public InOrderTraversalIterator inOrderTraversal() {
        return new InOrderTraversalIterator();
    }

    @Override
    protected BTNode<KEY> searchNode(KEY searchFor) {
        BTNode<KEY> temp = root;
        int compRes;
        while (temp != null && (compRes = comparator.compare(searchFor, temp.key)) != 0) {
            if (compRes < 0) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return temp;
    }

    protected class InOrderTraversalIterator implements Iterator<KEY> {
        final int modCount = modificationCount;

        private final Deque<BTNode<KEY>> stack = new ArrayDeque<>();
        private BTNode<KEY> pointer = null;

        InOrderTraversalIterator() {
            if (root == null) throw new IllegalStateException();
            pointer = root;
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty() || pointer != null;
        }

        @Override
        public KEY next() {
            BTNode<KEY> node = nextInternal();
            return node.key;
        }

        // Starting from the min node -> going from the left to the right
        protected BTNode<KEY> nextInternal() {
            if (modCount != modificationCount) {
                throw new ConcurrentModificationException();
            }

            BTNode<KEY> item = null;

            if (pointer != null || stack.size() > 0) {
                /* Reach the left most Node of the pointer Node */
                while (pointer != null) {
                    // place pointer to a tree node on the stack before traversing the node's left subtree
                    stack.push(pointer);
                    pointer = pointer.left;
                }
                pointer = stack.pop();

                item = new BTNode<>(pointer);

                // we have visited the node and its left subtree.  Now, it's right subtree's turn
                pointer = pointer.right;
            }
            return item;
        }
    }
}

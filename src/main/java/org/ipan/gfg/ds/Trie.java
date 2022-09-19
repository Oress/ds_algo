package org.ipan.gfg.ds;

import java.util.*;


// In case of hashMap we can have flexible alphabet
// In case of fixed alphabet & array we get more efficient lookups but memory becomes a problem when the alphabet is large.
/*public class Trie {
    private final Node root = new Node();

    private final String[] alphabet;
    private final String[] alphabet;

    public Trie(String[] alphabet) {
        this.alphabet = Arrays.copyOf(alphabet, alphabet.length);
    }

    public List<String> autocomplete(String prefix, boolean ignoreCase) {
        List<String> result = new ArrayList<>();
        Node startingNode = getNodeByPrefix(prefix);

        return result;
    }

    private Node getNodeByPrefix(String prefix) {
        Node node = root;

        for (int i = 0; node != null && i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            node = node.getByChar(c);
        }
        return node;
    }

    private class Node {
        private boolean isEndOfTheWord = false;
        private String[] alphabet = new String[Trie.this.alphabet.length];

        public Node() {
        }

        public Node(boolean isEndOfTheWord) {
            this.isEndOfTheWord = isEndOfTheWord;
        }
    }
}*/

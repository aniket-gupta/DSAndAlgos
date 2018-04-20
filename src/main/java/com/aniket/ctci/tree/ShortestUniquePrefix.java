package com.aniket.ctci.tree;

import java.util.HashMap;

public class ShortestUniquePrefix {

    /**
     * Find shortest unique prefix to represent each word in the list.
     *
     * Example:
     *
     * Input: [zebra, dog, duck, dove]
     * Output: {z, dog, du, dov}
     * where we can see that
     * zebra = z
     * dog = dog
     * duck = du
     * dove = dov
     *  NOTE : Assume that no word is prefix of another. In other words, the representation is always possible.
     */

    /** Solution Approach
     * input: ["zebra", "dog", "duck", "dot"]
     *
     * Now we will build prefix tree and we will also store count of characters
     *
     *                 root
     *                 /|
     *          (d, 3)/ |(z, 1)
     *               /  |
     *           Node1  Node2
     *            /|        \
     *      (o,2)/ |(u,1)    \(e,1)
     *          /  |          \
     *    Node1.1  Node1.2     Node2.1
     *       | \         \            \
     * (g,1) |  \ (t,1)   \(c,1)       \(b,1)
     *       |   \         \            \
     *     Leaf Leaf       Node1.2.1     Node2.1.1
     *     (dog)  (dot)        \                  \
     *                          \(k, 1)            \(r, 1)
     *                           \                  \
     *                           Leaf               Node2.1.1.1
     *                           (duck)                       \
     *                                                         \(a,1)
     *                                                          \
     *                                                          Leaf
     *                                                          (zebra)
     *
     * Now, for every leaf / word , we find the character nearest to the root with frequency as 1.
     * The prefix that the path from root to this character corresponds to, is the representation of the word.
     */

    public static void main(String[] args) {
        TrieNode root = new TrieNode(' ');
        addWord(root, "zebra");
        addWord(root, "dog");
        addWord(root, "duck");
        addWord(root, "dove");

        System.out.println(getShortestUniquePrefix(root, "zebra"));
        System.out.println(getShortestUniquePrefix(root, "dog"));
        System.out.println(getShortestUniquePrefix(root, "duck"));
        System.out.println(getShortestUniquePrefix(root, "dove"));
    }

    private static void addWord(TrieNode root, String word) {
        TrieNode tmp = root;
        TrieNode tn = null;
        int index = 0;
        do {
            tn = tmp.children.get(word.charAt(index));
            if (tn != null) {
                tn.count++;
                tmp = tn;
                index++;
                if(index >= word.length()) {
                    tmp.isWord = true;
                    return;
                }
            }

        } while (tn != null);

        for (; index < word.length(); index++) {
            TrieNode node = new TrieNode(word.charAt(index));
            tmp.children.put(word.charAt(index), node);
            tmp = node;
        }
        tmp.isWord = true;
    }

    private static String getShortestUniquePrefix(TrieNode root, String word) {
        TrieNode tmp = root;
        TrieNode tn = null;
        int index = 0;
        do {
            tn = tmp.children.get(word.charAt(index));
            if (tn != null) {
                index++;
                tmp = tn;
                if(tn.count == 1) break;

            } else
                return null;

        } while (tn != null);

        return word.substring(0, index);
    }

    private static class TrieNode {
        char c;
        boolean isWord;
        HashMap<Character, TrieNode> children;
        int count;

        TrieNode(char c) {
            this.c = c;
            children = new HashMap<>();
            count = 1;
        }
    }
}

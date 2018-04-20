package com.aniket.ctci.tree;


import java.util.*;

public class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode(' ' );

    }

    public void addWord(String word) {
        char[] chars = word.toCharArray();
        TrieNode tmp = root;
        TrieNode tn = null;
        int index = 0;
        do {
            tn = tmp.children.get(chars[index]);
            if (tn != null) {
                tmp = tn;
                index++;
                // if the word is got over, then it is already in trie
                if (index >= word.length()) {
                    tmp.isWord = true;
                    tmp.word = word;
                    return;
                }

            }

        } while (tn != null);

        // tmp is the last node and word is not got over
        for (; index < chars.length; index++) {
            TrieNode node = new TrieNode(chars[index]);
            tmp.children.put(chars[index], node);
            tmp = node;
        }
        tmp.isWord = true;
        tmp.word = word;
    }

    public String[] wordsByPrefix(String prefix) {
        char[] cArray = prefix.toCharArray();
        TrieNode temp = root;
        TrieNode tn = null;
        int index = 0;

        do {
            tn = temp.children.get(cArray[index]);
            if (tn == null) return null;
            index++;
            temp = tn;

        } while (index < cArray.length);

        List<String> words = new ArrayList<>();
        Deque<TrieNode> DQ = new ArrayDeque<>();
        DQ.addLast(temp);
        while (!DQ.isEmpty()) {
            TrieNode first = DQ.removeFirst();
            if (first.isWord) {
                words.add(first.word);
            }
            for (char c: first.children.keySet()) {
                TrieNode n = first.children.get(c);
                if(n != null) {
                    DQ.add(n);
                }
            }
        }

        return words.toArray(new String[0]);

    }






    // -------------- TrieNode class -----------
    private class TrieNode {
        HashMap<Character, TrieNode> children;
        char c;
        boolean isWord;
        String word;

        TrieNode() {
            this.children = new HashMap<>();
        }

        TrieNode(char c) {
            this();
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.addWord("zebra");
        trie.addWord("dog");
        trie.addWord("duck");
        trie.addWord("dove");

        System.out.println(Arrays.asList(trie.wordsByPrefix("z")));
        System.out.println(Arrays.asList(trie.wordsByPrefix("d")));
        System.out.println(Arrays.asList(trie.wordsByPrefix("do")));


    }

}

package main.trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public char data;
    public Map<Character,TrieNode> children ;
    public  boolean isTerminal;

    public TrieNode(char data) {
        this.data = data;
        children = new HashMap<>();
        isTerminal = false;
    }
}

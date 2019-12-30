package main.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jitendra.kumar01
 * 12/11/19
 */
public class TrieImplementation {


    public static class TrieNode{
        private Map<Character,TrieNode> children ;
        private boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    private  final TrieNode root  ;

    TrieImplementation(){
        root = new TrieNode();
    }

    public boolean searchRecursive(String word) {
        return searchRecursive(root, word, 0);
    }
    private boolean searchRecursive(TrieNode current, String word, int index) {
        if (index == word.length()) {
            //return true of current's endOfWord is true else return false.
            return current.isEndOfWord;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        //if node does not exist for given char then return false
        if (node == null) {
            return false;
        }
        return searchRecursive(node, word, index + 1);
    }
    public void insertRecursive(String word) {
        insertRecursive(root, word, 0);
    }


    private void insertRecursive(TrieNode current, String word, int index) {
        if (index == word.length()) {
            //if end of word is reached then mark endOfWord as true on current node
            current.isEndOfWord = true;
            return;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);

        //if node does not exists in map then create one and put it into map
        if (node == null) {
            node = new TrieNode();
            current.children.put(ch, node);
        }
        insertRecursive(node, word, index + 1);
    }

    public void insert(String word){
        TrieNode current = root;

        for (int i = 0; i <word.length() ; i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(null == node){
                node = new TrieNode();
                current.children.put(ch,node);
            }
            current = node;
        }
        current.isEndOfWord = true;

    }


    public boolean search(String word){
        TrieNode current = root ;

        for (int i = 0; i <word.length() ; i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(null == node)
                return false;
            current = node;
        }
        return current.isEndOfWord;
    }

    public boolean delete(String word){
        return delete(root,word,0);
    }

    private boolean delete(TrieNode current, String word, int index) {
        if(index == word.length()){
            if(!current.isEndOfWord){
                return false;
            }

            current.isEndOfWord = false;
            return current.children.size() ==0;
        }

        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if(node == null){
            return false;
        }

        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        //if true is returned then delete the mapping of character and trienode reference from map.
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            //return true if no mappings are left in the map.
            return current.children.size() == 0;
        }
        return false;
    }

    public static void main(String[] args) {
        TrieImplementation trieImplementation = new TrieImplementation();
        trieImplementation.insert("abc");
        trieImplementation.insert("abcd");
        trieImplementation.insert("abgl");


        System.out.println(trieImplementation.delete("abc"));
        System.out.println(trieImplementation.search("abc"));

    }
}

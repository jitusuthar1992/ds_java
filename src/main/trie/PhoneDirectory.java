package main.trie;

import java.util.*;

public class PhoneDirectory {

         class TrieNode {
            public char data;
            public Map<Character,TrieNode> children ;
            public  boolean isTerminal;

            public TrieNode(char data) {
                this.data = data;
                children = new HashMap<>();
                isTerminal = false;
            }
        }



        class Trie {
            TrieNode root ;
            public Trie() {
                root = new TrieNode('\0');
            }

            void insertWord(String word){
                insertUtil(root,word,0);
            }

            void insertUtil(TrieNode root, String word, int index) {
                if(index == word.length()){
                    root.isTerminal = true;
                    return;
                }

                TrieNode child = root.children.get(word.charAt(index));


                //present
                if(child == null){
                    child = new TrieNode(word.charAt(index));
                    root.children.put(word.charAt(index),child);
                }

                //Recursion
                insertUtil(child,word, index+1);
            }

            private ArrayList<ArrayList<String>> getSuggestions(String queryStr) {
                TrieNode prev = root;
                ArrayList<ArrayList<String>> output =  new ArrayList<>();
                String prefix = "";
                for (int i = 0; i < queryStr.length(); i++) {
                    char lastch = queryStr.charAt(i);
                    prefix = prefix.concat(String.valueOf(lastch));
                    TrieNode curr = prev.children.get(lastch);
                    if(null == curr)
                        break;
                    ArrayList<String> temp = new ArrayList<>();
                    printSuggestions(curr,temp,prefix);
                    output.add(temp);
                    temp= new ArrayList<>();
                    prev = curr;
                }
                return output;
            }

            private void printSuggestions(TrieNode curr, ArrayList<String> temp, String prefix) {
                if(curr.isTerminal){
                    temp.add(prefix);
                }
                Set<Character> childChars = curr.children.keySet();
                for (Character ch: childChars) {
                    TrieNode next = curr.children.get(ch);
                    String prefixNext = prefix.concat(String.valueOf(ch));
                    printSuggestions(next,temp,prefixNext);
                }
            }
        }

        public ArrayList<ArrayList<String>> phoneDirectory(List<String> contactList, String queryStr)
        {
            Trie trie = new Trie();
            for(int i =0;i<contactList.size();i++){
                String str = contactList.get(i);
                trie.insertWord(str);
            }

            return trie.getSuggestions(queryStr);
            //    Write your code here.
        }

    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        System.out.println(phoneDirectory.phoneDirectory(Arrays.asList("cod","coding","codding","code","coly"),
                "coding"));

    }
}

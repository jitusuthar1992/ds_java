    package main.trie;

    import java.util.Arrays;
    import java.util.List;

    public class Trie {
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

        boolean searchWord(String word){
            return searchUtil(root,word,0);
        }

        boolean searchUtil(TrieNode root, String word, int index) {
            if(index == word.length()){
                return root.isTerminal;
            }

            TrieNode child = root.children.get(word.charAt(index));

            //present
            if(child == null){
               return false;
            }
            //Recursion
            return searchUtil(child,word, index+1);
        }

        boolean startWithWord(String word){
            return startWithWordUtil(root,word,0);
        }

        boolean startWithWordUtil(TrieNode root, String word,int index) {
            if(word.length()== index){
                return true;
            }
            TrieNode child = root.children.get(word.charAt(index));
            if(null == child){
                return false;
            }
            return startWithWordUtil(child,word,index+1);
        }

        boolean deleteWord(String word){
            return deleteWordUtil(root,word,0);
        }

        boolean deleteWordUtil(TrieNode root,String word, int index){
            if(word.length()== index){
                if(!root.isTerminal)
                    return false;
                root.isTerminal = false;
                return root.children.size()==0;

            }
            TrieNode child = root.children.get(word.charAt(index));
            if(null == child){
                return false;
            }
            boolean isDelete = deleteWordUtil(child,word,index+1);
            if(isDelete){
                root.children.remove(word.charAt(index));
                return root.children.size() ==0;
            }
            return false;
        }

        String getLongestCommonSubstring(String firstStr){
            String ans = "";
            for (int i = 0; i <firstStr.length() ; i++) {
                char ch = firstStr.charAt(i);
                if(root.children.size()==1){
                    ans = ans.concat(String.valueOf(ch));
                    root = root.children.get(ch);
                }else {
                    break;
                }
                if(root.isTerminal)
                    break;
            }
            return ans;
        }
        public static void main(String[] args) {
            Trie trie = new Trie();
            //trie.insertWord("ABCD");
            /*trie.insertWord("ABD");
            System.out.println("Word found : "+ trie.searchWord("ABD"));
            System.out.println("Word found : "+ trie.startWithWord("AB"));
            System.out.println("Deleted "+trie.deleteWord("ABD"));
            System.out.println("Word found : "+ trie.searchWord("ABD"));*/

            List<String> inputs = Arrays.asList("coding","coders","codingninza","codezer");
            for (int i = 0; i < inputs.size(); i++) {
                trie.insertWord(inputs.get(i));
            }

            System.out.println("LongestCommonPrefix :"+trie.getLongestCommonSubstring("coding"));

        }
    }

//package src.Olivia;
//
////NO 208
////trie
//
//
///**
// * Your Trie object will be instantiated and called as such:
// * Trie obj = new Trie();
// * obj.insert(word);
// * boolean param_2 = obj.search(word);
// * boolean param_3 = obj.startsWith(prefix);
// */
//
//
////no need to use val
//public class trie {
//    class TireNode{
//        public char val;
//        public boolean isWord;
//        public TireNode[] children = new TireNode[26];
//        public TireNode(){}
//        TireNode(char c){
//            TireNode node = new TireNode();
//            node.val = c;
//        }
//    }
//
//    private TireNode root;
//
//    /** Initialize your data structure here. */
//    public Trie() {
//        root = new TireNode();
//        root.val = ' ';
//    }
//
//    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        TireNode cur = root;
//        for(int i=0;i<word.length();i++){
//            char tmp = word.charAt(i);
//            if(cur.children[tmp-'a']==null){
//                cur.children[tmp-'a'] = new TireNode();
//            }
//           cur = cur.children[tmp-'a'];
//        }
//        cur.isWord = true;
//    }
//
//    /** Returns if the word is in the trie. */
//    public boolean search(String word) {
//        TireNode cur = root;
//        for(int i=0;i<word.length();i++){
//            char tmp = word.charAt(i);
//            //no path
//            if(cur.children[tmp-'a']==null) return false;
//            cur = cur.children[tmp-'a'];
//        }
//        return cur.isWord;
//    }
//
//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        TireNode cur = root;
//        for(int i=0;i<prefix.length();i++){
//            char tmp = prefix.charAt(i);
//            //no prefix
//            if(cur.children[tmp-'a']==null) return false;
//            cur = cur.children[tmp-'a'];
//        }
//        return true;
//    }
//}

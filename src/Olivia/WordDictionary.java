package src.Olivia;

//NO 211
//tire

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

public class WordDictionary {
    public class TireNode{
        boolean isWord;
        TireNode[] children = new TireNode[26];
        TireNode(){}
    }

    private TireNode root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TireNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TireNode cur = root;
        for(int i=0;i<word.length();i++){
            char tmp = word.charAt(i);
            if(cur.children[tmp-'a']==null)
                cur.children[tmp-'a'] = new TireNode();
            cur = cur.children[tmp-'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TireNode cur = root;
        return searchHelper(cur,word,0);
    }

    private boolean searchHelper(TireNode cur, String word, int start){
        //base case
        if(start == word.length()) return cur.isWord;
        char tmp = word.charAt(start);
        if(tmp!='.'){
            if(cur.children[tmp-'a']==null) return false;
            else{
                return searchHelper(cur.children[tmp-'a'],word,start+1);
            }
        }
        else{
            for(int j=0;j<cur.children.length;j++){
                if(cur.children[j]!=null&&searchHelper(cur.children[j],word,start+1))
                    return true;
            }
        }

        return false;
    }
}

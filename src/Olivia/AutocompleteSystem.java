package src.Olivia;

import java.util.*;

//NO 642
//hard

class AutocompleteSystem {
    class TireNode{
        boolean isWord;
        Map<Character,TireNode> children;
        Map<String,Integer> count;
        public TireNode(){
            isWord = false;
            children = new HashMap<>();
            count = new HashMap<>();
        }
    }
    TireNode root;
    String prefix;

    class pair{
        String sentence;
        int count;
        public pair(String sentence,int count){
            this.sentence = sentence;
            this.count = count;
        }
    }

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TireNode();
        prefix = "";
        for(int i=0;i<sentences.length;i++){
            addNode(sentences[i],times[i]);
        }
    }
    private void addNode(String sentence, int times){
        TireNode cur = root;
        for(char now:sentence.toCharArray()){
            if(cur.children.get(now)==null){
                cur.children.put(now,new TireNode());
            }
            cur = cur.children.get(now);
            cur.count.put(sentence,cur.count.getOrDefault(sentence,0)+times);
        }
        cur.isWord = true;
    }

    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if(c=='#'){
            prefix += "";
            //add prefix to the tire
            addNode(prefix,1);
            //refresh the prefix
            prefix = "";
            return res;
        }
        else{
            prefix += c;
            TireNode cur = root;
            for(int i=0;i<prefix.length();i++){
                char now = prefix.charAt(i);
                if(!cur.children.containsKey(now))
                    return res;
                else{
                    cur = cur.children.get(now);
                }
            }
            Map<String,Integer> count = cur.count;
            PriorityQueue<pair> que = new PriorityQueue<>((a,b)->(a.count==b.count)?a.sentence.compareTo(b.sentence):b.count-a.count);
            for(Map.Entry<String,Integer> entry:count.entrySet()){
                que.add(new pair(entry.getKey(),entry.getValue()));
            }
            for(int i=0;i<3&&!que.isEmpty();i++){
                res.add(que.poll().sentence);
            }
            return res;
        }
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */

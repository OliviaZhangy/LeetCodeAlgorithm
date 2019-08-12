package src.Olivia;

//NO 127
//BFS

import java.util.*;

public class ladderLength127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //corner case
        if(wordList.size()==0||!wordList.contains(endWord)) return 0;

        Queue<String> queue  =new LinkedList<>();
        //need a set to avoid duplicate
        Set<String> use = new HashSet<>(wordList);
        queue.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) return level;
                //convert the word
                char[] charArr = cur.toCharArray();
                for (int l = 0; l < beginWord.length(); l++) {
                    char tmp = charArr[l];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j != tmp) {
                            charArr[l] = j;
                        }
                        String tmp1 = new String( charArr);
                        if(use.contains(tmp1)){
                            queue.add(tmp1);
                            use.remove(tmp1);
                        }
                    }
                    charArr[l] = tmp;
                }
            }
            level++;
        }
        return 0;

    }
}

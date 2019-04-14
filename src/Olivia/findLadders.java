package src.Olivia;

import java.util.*;

//Try use BFS
//need to use DFS not complete
public class findLadders {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result_null = new ArrayList<>();
        //corner case
        if(wordList.size()==0||!wordList.contains(endWord)){
            return result_null;
        }
        List<List<String>> result = new ArrayList<>();
        //convert to set to help remove
        Set<String> wordSet = new HashSet<>(wordList);
        int level = 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        result.add(new ArrayList<String>());
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++) {
                String cur = queue.remove();
                if(cur.equals(endWord)) {
                    return level;
                }
                //Convert to char array so that we can replace each character from a - z and check if anything is present in the wordList (wordSet)
                char[] cArray = cur.toCharArray();
                int n = cArray.length;
                for(int k = 0; k < n; k++) {
                    char temp = cArray[k];
                    for (char j = 'a'; j <= 'z'; j++) {
                        cArray[k] = j;

                        String tempWord = new String(cArray);

                        if (wordSet.contains(tempWord)) {
                            queue.offer(tempWord);
                            wordSet.remove(tempWord);
                        }
                    }
                    cArray[k] = temp;
                }
            }
            level++;
        }
        return result_null;

    }

    }
}


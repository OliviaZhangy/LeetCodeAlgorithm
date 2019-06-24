package src.Olivia;
import Olivia.SwapPairs24;

import javax.print.DocFlavor;
import java.util.*;

//NO 721
//Union find

//The key task here is to connect those emails, and this is a perfect use case for union find.
// to group these emails, each group need to have a representative, or parent.
// At the beginning, set each email as its own representative.
// Emails in each account naturally belong to a same group,
// and should be joined by assigning to the same parent (let's use the parent of first email in that list);


public class accountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,String> findParent = new HashMap<>();
        Map<String,String> findOwner = new HashMap<>();
        Map<String,TreeSet<String>> get = new HashMap<>();
        //put itself as its owner
        for(List<String> cur : accounts){
            String name = cur.get(0);
            for(int i=1;i<cur.size();i++){
                findParent.put(cur.get(i),cur.get(i));
                findOwner.put(cur.get(i),name);
            }
        }
        //do the union find
        for(List<String> cur: accounts){
            //first email as the parent
            String parent = find(cur.get(1),findParent);
            for(int i=2;i<cur.size();i++){
                findParent.put(find(cur.get(i),findParent),parent);
            }
        }
        //combine together
        for(List<String> cur:accounts){
            String tmp_par = find(cur.get(1),findParent);
            if(!get.containsKey(tmp_par)){
                get.put(tmp_par,new TreeSet<String>());
            }
            for(int i = 1;i<cur.size();i++){
                get.get(tmp_par).add(cur.get(i));
            }
        }
        //get the result
        List<List<String>> result = new ArrayList<>();
        for(String email:get.keySet()){
            List<String> curString = new ArrayList<>(get.get(email));
            String name = findOwner.get(email);
            curString.add(0,name);
            result.add(curString);
        }
        return result;

    }
    //union find function
    private String find(String s, Map<String, String> p) {
        return p.get(s).equals(s) ? s : find(p.get(s), p);
    }
}

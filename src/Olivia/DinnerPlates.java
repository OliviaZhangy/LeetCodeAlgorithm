package src.Olivia;

//NO 1172

import java.util.*;

class DinnerPlates {
    int capa;
    int max;
    TreeMap<Integer, List<Integer>> map;
    //available
    TreeSet<Integer> available;

    public DinnerPlates(int capacity) {
        capa = capacity;
        map = new TreeMap<>();
        available = new TreeSet<>();
        max = 0;
    }

    public void push(int val) {
        //look at the position to push
       int loc = available.isEmpty()?max++:available.pollFirst();

       if(!map.containsKey(loc)){
           map.put(loc,new ArrayList<>());
       }
       map.get(loc).add(val);
       if(map.get(loc).size()<capa){
           available.add(loc);
       }
    }

    public int pop() {
        //corner case
      if(map.isEmpty()) return -1;

      int key = map.lastKey();
      List<Integer> list = map.get(key);
      int res = list.get(list.size()-1);
      list.remove(list.size()-1);
      map.remove(key);
      if(!list.isEmpty()){
          map.put(key,list);
      }
      available.add(key);
      return res;
    }

    public int popAtStack(int index) {
        //corner case
        if(!map.containsKey(index)) return -1;

        List<Integer> list = map.get(index);
        int res = list.get(list.size()-1);
        list.remove(list.size()-1);
        map.remove(index);
        if(!list.isEmpty()){
            map.put(index,list);
        }
        available.add(index);
        return res;
    }


    public static void main(String[] args) {
        DinnerPlates test = new DinnerPlates(2);
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        System.out.println(test.popAtStack(0));     // 2
        test.push(20);
        test.push(21);
        System.out.println(test.popAtStack(0));     // 20
        System.out.println(test.popAtStack(2));     // 21
        System.out.println("=====");
        System.out.println(test.pop());     // 5
        System.out.println(test.pop());     // 4
        System.out.println(test.pop());     // 3
        System.out.println(test.pop());     // 1
        System.out.println(test.pop());     // -1
    }

}
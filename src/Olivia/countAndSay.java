package src.Olivia;

//NO 38
//others

public class countAndSay {
    public String countAndSay(int n) {
        //base case
        if(n==1) return "1";
        String cur = countAndSay(n-1);
        StringBuilder str = new StringBuilder();
        int i = 0;
        while (i<cur.length()){
            char tmp = cur.charAt(i);
            int count = 0;
            while(i+count<cur.length()&&cur.charAt(i+count)==tmp) count++;
            str.append(count);
            str.append(tmp);
            i += count;
        }
        return str.toString();
    }
}

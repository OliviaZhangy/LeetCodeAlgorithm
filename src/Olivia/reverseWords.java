package src.Olivia;

//NO 151
//others

public class reverseWords {
    public String reverseWords(String s) {
        if(s==null||s.length()==0) return s;
        StringBuilder sb = new StringBuilder();

        //String[] tmp = s.split(" ");
        String[] tmp = s.split("\\s+");
        for(int i = tmp.length-1; i>=0; i--) {
            sb.append(tmp[i] + " ");
        }
        return sb.toString().trim();
    }
}

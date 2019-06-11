package src.Olivia;

//NO 345
//two pointers

public class reverseVowels {
    public String reverseVowels(String s) {
        //corner case
        if(s==null||s.length()==1) return s;
        String vowels = "aeiouAEIOU";
        char[] charArray = s.toCharArray();
        int start = 0;
        int end = charArray.length-1;
        while(start<end){
            while (start<end&&!vowels.contains(charArray[start]+"")) start++;
            while (start<end&&!vowels.contains(charArray[end]+"")) end--;
            char tmp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = tmp;
            start++;
            end--;
        }
        return new String(charArray);
    }
}

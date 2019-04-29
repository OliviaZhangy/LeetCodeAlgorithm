package src.Olivia;

//NO 125


public class isPalindrome {
    public boolean isPalindrome(String s) {
        int len = s.length();

        if (len <= 1)
            return true;

        char[] arr = new char[len];
        int idx = 0;

        for (int i =0; i< len; ++i) {
            char ch = s.charAt(i);
            if (isValid(ch)) {
                if (ch >= 'A' && ch <= 'Z')
                    ch -= 'A' - 'a';
                arr[idx++] = ch;
            }
        }

        for (int i=0; i< idx; ++i) {
            if (arr[i] != arr[idx -i - 1])
                return false;
        }
        return true;
    }

    private boolean isValid(char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z'
                || c >= '0' && c <= '9')
            return true;
        else
            return false;
    }
}

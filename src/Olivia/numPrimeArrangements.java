package src.Olivia;

//NO 1175
//prime

public class numPrimeArrangements {
    public int numPrimeArrangements(int n) {
        int count = countPrimes(n+1);
        long res = 1;
        for(int i=1;i<=count;i++){
            res = res*i%((int)Math.pow(10,9)+7);
        }
        for(int i=1;i<=n-count;i++){
            res = res*i%((int)Math.pow(10,9)+7);
        }
        return (int)res;
    }
    //count prime numbers less than n
    /**
     * Count prime number.
     * First, filter out all even number (n / 2).
     * Then
     *
     * @param n count # of prime number from 1 to n
     * @return # of prime numbers
     */
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }

        boolean[] f = new boolean[n];

        int count = n / 2;
        for (int i = 3; i * i < n && !f[i]; i += 2) {

            for (int j = i * i; j < n; j += 2 * i) {
                if (!f[j]) {
                    --count;
                    f[j] = true;
                }
            }
        }
        return count;
    }
}

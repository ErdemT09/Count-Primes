
public class Main
{
    // https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
    // Code taken from: https://www.programcreek.com/2014/04/leetcode-count-primes-java/
    // https://leetcode.com/problems/count-primes/submissions/
    
    public static int countPrimes(int n) {
	if (n <= 2)
		return 0;
 
	// init an array to track prime numbers
	boolean[] primes = new boolean[n];
	for (int i = 2; i < n; i++)
		primes[i] = true;
 
	for (int i = 2; i <= Math.sqrt(n - 1); i++) {
	// or for (int i = 2; i <= n-1; i++) {
		if (primes[i]) {
		    
		    // For example, by i == 3, we increment the number j by 3, and set
		    // all multiples of 3 to be a non-prime using this.
		    
			for (int j = i + i; j < n; j += i)
				primes[j] = false;
		}
	}
 
	int count = 0;
	for (int i = 2; i < n; i++) {
		if (primes[i])
			count++;
	}
 
	return count;
}
    public static void main(String[] args) {
		System.out.println(countPrimes(100000));
	}
}

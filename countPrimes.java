
public class Main
{
	// https://leetcode.com/problems/count-primes/submissions/
	
    public static int countPrimesSlow(int a)
    {
        List<Integer> primes = new LinkedList<Integer>();
        boolean _continue = false;
        for(int i = 2; i<=a; i++)
        {
            
            for(int j = 0; j<primes.size(); j++)
            {
                if (primes.get(j) < Math.sqrt(i)) //  the expression (primes.get(j) <= i/2) will yield an even slower calculation
                {
                    if( i % primes.get(j) == 0)
                    {
                    _continue = true;
                    break;
                    }
                }
            }            
            if(_continue)
            {
                _continue = false;
                continue;
            }         
            primes.add(i);
        }
        return primes.size();
    }
	
    public static int countPrimes(int n) {
    // https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
    // Code taken from: https://www.programcreek.com/2014/04/leetcode-count-primes-java/
	if (n <= 2)
		return 0;
 
	// initialize an array to track prime numbers
	boolean[] primes = new boolean[n];
	for (int i = 2; i < n; i++)
		primes[i] = true;
 
	for (int i = 2; i <= Math.sqrt(n - 1); i++) {
	// or for (int i = 2; i <= n-1; i++), but this is faster.
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
		System.out.println(countPrimes(100000)); //prints 9592
	        System.out.println(countPrimes(1000)); //prints 168
	}
}

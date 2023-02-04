package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class TheUnlucky13 {

    public static int K = 1000000009;
    public  static  HashMap<Integer,Long> cache1 = new HashMap<>();
    public  static  HashMap<Integer,Long> cache2 = new HashMap<>();

    public static void main(String[] args) throws  Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(getPermutations(N));
        }
    }

    public static Long getPermutations(int n) {

        HashMap<Integer,Long> cache;

        if (n<K/2) {
            cache = cache1;
        } else {
            cache = cache2;
        }

        if (n==0) {
            cache.put(n,1l);
            return cache.get(n);
        }

        if (n==1) {
            cache.put(n,10l);
            return cache.get(n);
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        } else {
            Long x = getPermutations(n/2);
            Long y = getPermutations(n/2-1);
            long res;
            if (n%2 == 0) {
                res = (((long) x*x - (long) y*y)%K);
            } else {
                Long z = getPermutations(n/2+1);
                res = (x* (z-y)) % K;
            }
            cache.put(n,res);

            return  cache.get(n);
        }
    }


}


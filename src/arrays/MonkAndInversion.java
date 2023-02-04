package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonkAndInversion {
    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        while (testCases-- >0) {
            int n = Integer.parseInt(br.readLine());
            List<List<Integer>> input = new ArrayList<>();

            for (int i=0;i<n;i++) {
                List<Integer> data = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList();
                input.add(data);
            }

            getMonkInversions(n,input);

        }
    }

    public  static  void  getMonkInversions(int n , List<List<Integer>> M) {

        int res = 0;

        for (int i =0 ; i<n ; i++) {
            for (int j =0 ; j<n ; j++) {
                for (int p= i ; p<n;p++) {
                    for (int q = j; q<n;q++) {
                        if (M.get(i).get(j) > M.get(p).get(q)) {
                            res++;
                        }
                    }
                }
            }
        }

        System.out.println(res);

    }

}

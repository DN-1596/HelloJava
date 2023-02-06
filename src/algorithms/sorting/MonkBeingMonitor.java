package algorithms.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MonkBeingMonitor {

    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Integer> input = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList();

            getMaxCountDifference(input,n);

        }
    }

    private static void getMaxCountDifference(List<Integer> input, int n) {

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        input.forEach(ele -> hashMap.put(ele,hashMap.getOrDefault(ele,0)+1));

        List<Integer> uniqueInputs = new ArrayList<>();
        uniqueInputs.addAll(hashMap.keySet().stream().toList());
        Collections.sort(uniqueInputs);
        int maxDiff = 0;
        int i = uniqueInputs.size()-1;
        int j=i;

        while (j > 0) {
            j--;
            int diff = hashMap.getOrDefault(uniqueInputs.get(i), 0)
                    - hashMap.getOrDefault(uniqueInputs.get(j), 0);

            if (diff > maxDiff) {
                maxDiff = diff;
            } else if (diff <= 0) {
                i = j;
            }
        }

        System.out.println(maxDiff);



    }

}

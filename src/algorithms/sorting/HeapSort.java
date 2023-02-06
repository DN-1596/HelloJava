package algorithms.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapSort {

    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("ENTER NUMBER OF TEST CASES - ");
        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0 ) {
            System.out.println("\nEnter a space separated array - ");
            List<Integer> input = new ArrayList<>();

            input.addAll(Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList());

            executeHeapSort(input) ;

        }


    }

    private static void executeHeapSort(List<Integer> A) {

        int heapSize = A.size();

        buildHeap(A,heapSize);
        printHeap(A);

        for (int i=A.size();i>1;i--) {
            swap(A,0,i-1);
            heapSize--;
            maxHeapify(A,1,heapSize);
            printHeap(A);
        }


    }

    private static void buildHeap(List<Integer> A, int heapSize) {
        for (int i = A.size()/2;i>0;i--) {
            maxHeapify(A,i,heapSize);
        }
    }

    private static void maxHeapify(List<Integer>  A, int i,int heapSize) {
        int left = 2*i;
        int right = 2*i+1;
        int largestIndex = i;

        if (left <= heapSize && A.get(largestIndex-1) < A.get(left-1)) {
            largestIndex = left;
        }
        if (right <= heapSize && A.get(largestIndex-1) < A.get(right-1)) {
            largestIndex = right;
        }

        if (largestIndex != i) {
            swap(A,largestIndex-1,i-1);
            maxHeapify(A,largestIndex,heapSize);
        }


    }

    public  static  void swap(List<Integer> A, int a , int b) {
        int temp = A.get(a);
        A.set(a,A.get(b));
        A.set(b,temp);
    }

    public  static  void  printHeap(List<Integer> A) {

        for (int i=0;i<A.size();i++) {
            System.out.print(A.get(i) + " ");
        }

        System.out.println();


    }


}

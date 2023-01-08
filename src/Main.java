import java.util.Arrays;
import java.util.Scanner;

public class Main {

    //bubble sort
    public static void bubbleSort(int[]arr){
        for (int i=0;i<arr.length-1;i++){
            for (int j = 0;j<arr.length-i-1;j++){
                if (arr[j]<arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // merge sort
    static void merge(int arr[], int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int M[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[p + i];
        for (int j = 0; j < n2; j++)
            M[j] = arr[q + 1 + j];

        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = M[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = M[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int arr[], int l, int r) {
        if (l < r) {

            int m = (l + r) / 2;

            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    // insertion sort
    static void insertionSort(int array[]) {
        int size = array.length;

        for (int step = 1; step < size; step++) {
            int key = array[step];
            int j = step - 1;

            // Compare key with each element on the left of it until an element smaller than
            // it is found.
            // For descending order, change key<array[j] to key>array[j].
            while (j >= 0 && key < array[j]) {
                array[j + 1] = array[j];
                --j;
            }

            // Place key at after the element just smaller than it.
            array[j + 1] = key;
        }
    }

    //heap sort
    public void sort(int arr[]) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Heap sort
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        // first problem
        Scanner input = new Scanner(System.in);
        System.out.println("please enter number n");
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0;i<n;i++){
            arr[i] = (int)((Math.random()*30)+20);
        }
        //sorting
//        bubbleSort(arr);
        insertionSort(arr);
        //to decreasing
        System.out.println(Arrays.toString(arr));
        System.out.println("running time is -->"+ n*n);

        // second problem
//        Triangle[] triangles = new Triangle[4];
//        double sum = 0;
//        System.out.println("enter number of triangles");
//        int y = input.nextInt();
//        for (int i = 0; i<n;i++) {
//            System.out.println("enter three sides no");
//            triangles[n].s1 = input.nextInt();
//            triangles[n].s2 = input.nextInt();
//            triangles[n].s3 = input.nextInt();
//            sum+=triangles[n].area();
//        }
//        System.out.println(sum);

    }
}
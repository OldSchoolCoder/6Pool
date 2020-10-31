import java.util.Arrays;

public class TestSearch {
    public static void main(String[] args) {
        int toFind = 102;
        int[] arr = new int[12];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 100;
        }
        System.out.println("Array = " + Arrays.toString(arr));
        System.out.println("toFind = " + toFind);
        ParallelSearch search = new ParallelSearch(arr, 102, 0);
        System.out.println("Index = " + Arrays.toString(search.search(arr, 102)));
    }
}

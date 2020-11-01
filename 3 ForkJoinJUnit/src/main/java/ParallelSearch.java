import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelSearch extends RecursiveTask<int[]> {
    private final int[] arr;
    private final int toFind;
    private final int point;

    public ParallelSearch(int[] arr, int toFind, int point) {
        this.arr = arr;
        this.toFind = toFind;
        this.point = point;
    }

    @Override
    protected int[] compute() {
        if (point == arr.length - 1) {
            return new int[0];
        }
        ParallelSearch ps = new ParallelSearch(arr, toFind, point + 1);
        ps.fork();
        int[] newArr = ps.join();
        return LineSearch.finder(arr, point, toFind, newArr);
    }

    public int[] search(int[] arr, int toFind) {
        if (arr.length > 10) {
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            return forkJoinPool.invoke(new ParallelSearch(arr, toFind, 0));
        } else {
            return LineSearch.search(arr, toFind);
        }
    }
}

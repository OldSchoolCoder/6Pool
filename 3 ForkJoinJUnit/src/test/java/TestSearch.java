import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class TestSearch {
    @Test
    public void testSearch() {
        int toFind = 102;
        int[] arr = new int[12];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 100;
        }
        ParallelSearch search = new ParallelSearch(arr, toFind, 0);
        int[] result = search.search(arr, toFind);
        assertThat(result, is(new int[]{2}));
    }
}

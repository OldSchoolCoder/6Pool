import java.util.Arrays;

public class LineSearch {

    public static int[] search(int[] arr, int point, int toFind) {
        if (point == arr.length - 1) {
            return new int[0];
        }
        int[] newArr = LineSearch.search(arr, point + 1, toFind);
        return finder(arr, point, toFind, newArr);
    }

    public static int[] finder(int[] arr, int point, int toFind, int[] newArr) {
        if (toFind == arr[point]) {
            int[] result = new int[newArr.length + 1];
            result[0] = point;
            for (int i = 0; i < newArr.length; i++) {
                result[i + 1] = newArr[i];
            }
            return result;
        } else {
            return newArr;
        }
    }

    public static int[] search(int[] arr, int toFind) {
        return search(arr, 0, toFind);
    }
}

package sort;

/**
 * 〈一句话功能简述〉:
 * 〈插入排序，从大到小〉
 *
 * @author PengHao
 * @version 1.0.0
 * @create 2019/8/8  16:22
 */
public class InsertSort {

    public static void sort(int[] arr) {
        int j;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            for (j = i; j > 0 && temp > arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

}

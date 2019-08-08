package sort;

/**
 * 〈一句话功能简述〉:
 * 〈选择排序，从大到小〉
 *
 * @author PengHao
 * @version 1.0.0
 * @create 2019/8/8  16:14
 */
public class SelectSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

}

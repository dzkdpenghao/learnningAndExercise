package sort;

/**
 * 〈一句话功能简述〉:
 * 〈冒泡排序,从大到小〉
 *
 * @author PengHao
 * @version 1.0.0
 * @create 2019/8/8  16:01
 */
public class BubbleSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}

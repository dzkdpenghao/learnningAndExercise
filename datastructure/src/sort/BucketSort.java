package sort;

/**
 * 〈一句话功能简述〉:
 * 〈桶排序〉
 *
 * @author PengHao
 * @version 1.0.0
 * @create 2019/8/8  16:36
 */
public class BucketSort {

    /**
     * @param arr：待排序的数组
     * @param max:数组中最大的数
     */
    public static void sort(int[] arr, int max) {
        int[] bucket;
        if (arr == null || arr.length < 2 || max < 1) {
            return;
        }

        bucket = new int[max + 1];
        //计数
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        //排序
        for (int i = 0, j = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0) {
                arr[j++] = i;
            }
        }
        bucket = null;
    }

}

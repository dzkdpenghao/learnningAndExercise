package sort;

/**
 * 〈一句话功能简述〉:
 * 〈快速排序〉
 *
 * @author PengHao
 * @version 1.0.0
 * @create 2019/8/8  16:58
 */
public class QiuckSort {

    /**
     *
     * @param arr：需要排序的数组
     * @param low:排序的起始下标
     * @param high：排序的终止下标
     */
    public static void sort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }

        i = low;
        j = high;
        //基准元素
        temp = arr[low];

        while (i < j) {
            //先看右边
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //满足条件则交换
            if (i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        //将基准元素与ij相等处交换
        arr[low]=arr[i];
        arr[i]=temp;

        //递归排序左右半边
        sort(arr,low,i-1);
        sort(arr,i+1,high);
    }

}

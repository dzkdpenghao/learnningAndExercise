package sort;

/**
 * 〈一句话功能简述〉:
 * 〈希尔排序〉
 *
 * @author PengHao
 * @version 1.0.0
 * @create 2019/8/10  10:46
 */
public class ShellSort {
    public static void sort(int[] arr) {
        int j;
        //采用希尔增量序列（gap,gap/2,gap/4,...,1）
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //每一个gap，从gap到数组结尾循环一边
            for (int i = gap; i < arr.length; i++) {
                int temp = arr[i];
                //把上层每次循环中索引为i的元素放到正确的位置
                for (j = i; j >= gap && temp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }
}

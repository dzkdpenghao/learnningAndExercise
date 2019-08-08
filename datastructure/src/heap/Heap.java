package heap;

import java.util.Arrays;

/**
 * 〈一句话功能简述〉:
 * 〈堆〉
 *
 * @author PengHao
 * @version 1.0.0
 * @create 2019/8/8  13:30
 */
public class Heap {

    private Integer[] arr = new Integer[16];//存储元素的数组，从下标1开始才是元素
    private int currentSize = 0;//当前数组元素的个数

    public void insert(Integer x) {
        if (currentSize == arr.length - 1) {
            arr = this.enlargeArray();
        }
        int hole = ++currentSize;
        for (arr[0] = x; x.compareTo(arr[hole / 2]) < 0; hole /= 2) {
            arr[hole] = arr[hole / 2];
        }
        arr[hole] = x;
    }

    public Integer deleMin() {
        if (currentSize < 1) {
            return null;
        } else if (currentSize == 1) {//如果数组中只有一个元素
            Integer temp1=arr[currentSize];
            arr[currentSize--] = null;
            return temp1;
        }

        //要删除的最小值
        Integer min = arr[1];

        //暂存数组中最后一个元素
        Integer temp = arr[currentSize];
        //删除最后一元素
        arr[currentSize--] = null;
        int hole = 1;
        int child;

        //下滤hole
        for (; hole * 2 <= currentSize; hole = child) {
            //找hole的左右儿子中最小的
            child = hole * 2;
            if (child != currentSize && (arr[child].compareTo(arr[child + 1]) > 0)) {
                child++;
            }
            //判断最后一个元素是否能够放到当前hole处,能则停止下滤,否则继续
            if (arr[child].compareTo(temp) < 0) {
                arr[hole] = arr[child];
            } else {
                break;
            }
        }
        //将最后一元素放到下滤后的hole处
        arr[hole] = temp;

        return min;
    }

    /**
     * 数组扩容:2*old+1
     *
     * @return Integer[]:扩容后的新数组
     */
    public Integer[] enlargeArray() {
        Integer[] newArr = new Integer[arr.length * 2 + 1];
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }

    @Override
    public String toString() {
        return "Heap{" +
                "arr=" + Arrays.toString(arr) +
                ", currentSize=" + currentSize +
                '}';
    }

    public Integer[] getArr() {
        return arr;
    }

    public void setArr(Integer[] arr) {
        this.arr = arr;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }
}

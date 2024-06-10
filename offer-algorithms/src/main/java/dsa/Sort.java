package dsa;

import java.util.Random;

/**
 * @program: LeetCodeSolution
 * @description:
 * @author: WhyWhatHow
 * @create: 2020-05-12 11:48
 **/

public class Sort {


    static int[] a = {11, 1, 2, 3, 4, 5, 6, 7, 7, 8};
    static int[] m = new int[20];

    public static void main(String[] args) {

        ThreadLocal threadLocal = new ThreadLocal();

        Thread t = new Thread(() -> {
            System.out.println(123);
            threadLocal.set("abc");

        });

        int x = 1024;
//        int y = x >> 1;
//        int z = x << 1;
//        System.out.println(y);
//        System.out.println(z);
        int r = a.length;
        int[] arr = new int[12];
        Random random = new Random();
//        random.setSeed(100);
        for (int i = 0; i < 12; i++) {
            arr[i] = random.nextInt(100);
        }
        for (int i : arr) {
            System.out.print("=" + i);
        }
        Sort sort = new Sort();
//        sort.quickSortA(arr, 0, arr.length - 1);
        sort.mergeSort(arr, 0, arr.length - 1);
//        sort.bubbleSort(arr,arr.length);
//        sort.selectSort(arr, arr.length);
//        sort.insertSort(arr, arr.length);
//        sort.insertSort(arr,arr.length);
        System.out.println();
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }

    static void heapSort(int[] a, int n) {

    }

    // 插入排序, 保证前半部分有序
    static void insertSort(int[] a, int n) {
        int i, j;
        for (i = 1; i < n; i++) {
            if (a[i] < a[i - 1]) {
                int temp = a[i];
                for (j = i - 1; j >= 0 && temp < a[j]; j--) {
                    a[j + 1] = a[j];
                }
                a[j + 1] = temp;

            }
        }
    }

    // 每一次i循环会选择出一个最小的元素
    static void selectSort(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            int k = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] <= a[k]) {
                    k = j;
                }
            }
            if (k != i) {
                int temp = a[i];
                a[i] = a[k];
                a[k] = temp;
            }
        }
    }

    static void bubbleSort(int[] a, int n) {
        int temp;
        for (int i = 0; i < n - 1; i++) {
            boolean yes = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j + 1] < a[j]) {
                    yes = true;
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            if (!yes) {
                return;
            }

        }

    }

    /**
     * [left,right) 前闭后开, 屎一样, , 前闭后闭  最好不过
     *
     * @param a
     * @param left
     * @param right
     */
    static void mergeSort(int[] a, int left, int right) {
        if (left == right)
            return;
        int mid = left + ((right - left) >> 1);
        mergeSort(a, left, mid); // [left,mid]
        mergeSort(a, mid + 1, right);// [mid+1,right]
        merge(a, left, mid, right);
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (a[i] > a[j]) {
                m[k++] = a[j++];
            } else if (a[i] <= a[j]) {
                m[k++] = a[i++];
            }
        }
        while (i <= mid) m[k++] = a[i++];
        while (j <= right) m[k++] = a[j++];
        for (int l = left; l < k; l++) {
            a[l] = m[l];
        }

    }

    /**
     * 快排每次确定一个位置
     * step : [left,right]
     * 1 .选取比较元素，
     * 2. 确定元素位置
     * 3. 递归处理余下部分
     *
     * @param a
     * @param left
     * @param right
     */
    static void quickSort(int[] a, int left, int right) {
        if (left >= right)
            return;
        int temp = a[left];
        int lo = left, hi = right;

        while (lo < hi) {
            while (lo < hi && temp <= a[hi]) hi--;
            a[lo] = a[hi];
            while (lo < hi && a[lo] <= temp) lo++;
            a[hi] = a[lo];
        }
        a[lo] = temp;
        quickSort(a, left, lo - 1);
        quickSort(a, lo + 1, right);
    }

    void quickSortA(int[] a, int left, int right) {
        if (left > right) {
            return;
        }
        int lo = left, hi = right, temp = a[left];
        while (lo < hi) {
            while (lo < hi && temp <= a[hi]) hi--;
            a[lo] = a[hi];
            while (lo < hi && a[lo] <= temp) lo++;
            a[hi] = a[lo];
        }
        a[lo] = temp;
        quickSortA(a, left, lo - 1);
        quickSortA(a, lo + 1, right);
    }

    int[] num = new int[10];

    void init() {
        num[0] = 10;
        for (int i = 1; i < num.length; i++) {
            num[i] = num[i - 1] + 2;
        }

    }
//    int solve(int n ){
//        return  num[n-1];
//    }
//    int solve(int n){
//        if ( )
//    }
}

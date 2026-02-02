package leetcode.algorithm.dsa;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @program: LeetCodeSolution
 * @description: 双堆+懒删除.
 * @author: WhyWhatHow
 * @create: 2026-02-02 21:17
 **/
public class DualHeap { // 可以用于求中位数.

    // 小顶堆：存较大的一半元素
    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // 大顶堆：存较小的一半元素
    private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    // 延迟删除表
    private final Map<Integer, Integer> delayed = new HashMap<>();
    // 有效元素数量
    private int maxHeapSize = 0;
    private int minHeapSize = 0;
    private final int k;

    public DualHeap(int k) {
        this.k = k;
    }

    public void add(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
            maxHeap.offer(num);
            maxHeapSize++;
        } else {
            minHeap.offer(num);
            minHeapSize++;
        }
        rebalance();
    }

    public void remove(int num) {
        delayed.merge(num, 1, Integer::sum);
        if (num <= maxHeap.peek()) {
            maxHeapSize--;
        } else {
            minHeapSize--;
        }
        rebalance();
    }

    public double getMedian() {
        prune(maxHeap);
        prune(minHeap);

        if (k % 2 == 1) {
            return maxHeap.peek();
        } else {
            return ((long) maxHeap.peek() + (long) minHeap.peek()) / 2.0;
        }
    }

    // 清理堆顶的延迟删除元素
    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty() && delayed.containsKey(heap.peek())) {
            int num = heap.poll();
            if (delayed.merge(num, -1, Integer::sum) == 0) {
                delayed.remove(num);
            }
        }
    }

    // 维持堆的平衡：maxHeap 比 minHeap 最多多一个元素
    private void rebalance() {
        if (maxHeapSize > minHeapSize + 1) {
            // maxHeap 太多，移一个到 minHeap
            minHeap.offer(maxHeap.poll());
            maxHeapSize--;
            minHeapSize++;
            prune(maxHeap);
        } else if (minHeapSize > maxHeapSize) {
            // minHeap 太多，移一个到 maxHeap
            maxHeap.offer(minHeap.poll());
            minHeapSize++;
            maxHeapSize--;
            prune(minHeap);
        }
    }
}

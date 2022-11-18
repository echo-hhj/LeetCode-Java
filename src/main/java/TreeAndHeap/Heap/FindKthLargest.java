package TreeAndHeap.Heap;

import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        //新建最小堆
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        //遍历数组元素，堆中元素个数大于k时删除堆顶元素
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) 
                heap.poll();
        }
        return heap.peek();
    }
}

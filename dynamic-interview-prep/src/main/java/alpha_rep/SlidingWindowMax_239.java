package alpha_rep;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMax_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int n = nums.length;
        int totalWindow = n - k + 1;
        int [] windowMax = new int[totalWindow];

        int ri = 0; // current window result pointer
        for(int i = 0; i < n; i++) {
            int cur = nums[i];
            while(!q.isEmpty() && q.peekFirst() <= i - k) {
                q.pollFirst();
            }
            while (!q.isEmpty() && nums[q.peekLast()] <= cur) {
                q.pollLast();
            }
            q.offer(i);
            if (i >= k -1 ) {
                windowMax[ri++] = nums[q.peekFirst()];
            }
        }
        return windowMax;
    }

    public int[] maxSlidingWindow_drona(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int ri = 0; // Index for our result array
        
        // Deque will store INDICES of the array elements
        Deque<Integer> q = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // 1. Remove indices that are out of the current window bounds
            if (!q.isEmpty() && q.peekFirst() < i - k + 1) {
                q.pollFirst();
            }
            
            // 2. Remove indices of elements that are smaller than the current element nums[i]
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pollLast();
            }
            
            // 3. Add the current element's index to the back of the queue
            q.offerLast(i);
            
            // 4. If the window has reached size k, the front of the queue is the max
            if (i >= k - 1) {
                result[ri++] = nums[q.peekFirst()];
            }
        }
        
        return result;
    }
}

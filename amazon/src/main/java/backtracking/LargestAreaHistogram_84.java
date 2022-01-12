package backtracking;

import java.util.Stack;

public class LargestAreaHistogram_84 {
  int [] heights;

  public int largestRectangleArea(int[] heights) {
    int len = heights.length;
    int i = 0;
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    int maxArea = 0;
    while (i < len) {
      int topIndex = stack.peek();
      if (topIndex == -1) {
        stack.push(i++);

      } else {
        int curVal = heights[i];
        int topVal = heights[topIndex];
        if (topVal <= curVal) {
          stack.push(i++);
        } else {
          stack.pop();
          maxArea = Math.max(maxArea, topVal * (i - (stack.peek() + 1)));
        }
      }
    }

    while (stack.size() > 1) {
      int topIndex = stack.pop();
      int topVal = heights[topIndex];
      maxArea = Math.max(maxArea, topVal * (i - (stack.peek() + 1)));
    }

    return maxArea;
  }

  public int largestRectangleArea1(int[] heights) {
    this.heights = heights;
    return max(0, heights.length - 1);
  }

  private int max(int l, int r) {
    if (l > r) {
      return Integer.MIN_VALUE;
    } else if (l == r) {
      return heights[l];
    } else {
      int minIndex = 0;
      int curMin = Integer.MAX_VALUE;
      for (int i = l; i <= r; i++) {
        if (heights[i] < curMin) {
          curMin = heights[i];
          minIndex = i;
        }
      }
      int leftArea = 0;
      if (l <= curMin - 1) {
        leftArea = max(l, minIndex - 1);
      }
      int rightArea = 0;
      if (curMin + 1 <= r) {
        rightArea = max(minIndex + 1, r);
      }
      return Math.max((curMin * (r - l + 1)), Math.max(leftArea, rightArea));
    }
  }


}

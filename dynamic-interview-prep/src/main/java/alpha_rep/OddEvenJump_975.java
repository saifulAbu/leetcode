package alpha_rep;

public class OddEvenJump_975 {
    public int oddEvenJumps_recursion(int[] arr) {
        int validIndexCount = 0;
        for(int i = 0; i < arr.length; i++){
            if (canReachEnd(arr, i, true)) {
                validIndexCount++;
            }
        }
        return validIndexCount;
    }

    private boolean canReachEnd(int[] arr, int i, boolean isOddJump) {
        // Base case: We reached the end of the array
        if (i == arr.length - 1) {
            return true;
        }

        // Search for the next target index 'j'
        int nextIndex = -1;

        if (isOddJump) {
            int min = Integer.MAX_VALUE;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] >= arr[i] && arr[j] < min) {
                    min = arr[j];
                    nextIndex = j;
                }
            }
        } else {
            int max = Integer.MIN_VALUE;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] <= arr[i] && arr[j] > max) {
                    max = arr[j];
                    nextIndex = j;
                }
            }
        }

        // If no valid target is found, the path dies
        if (nextIndex == -1) {
            return false;
        }

        // Recurse from the new position, flipping the jump state
        return canReachEnd(arr, nextIndex, !isOddJump);
    }

    public int oddEvenJumps_me(int[] arr) {
        int n = arr.length;
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];
        odd[n-1] = true;
        even[n-1] = true;

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(arr[n-1], n-1);

        int count = 1;
        for(int i = n -2; i >= 0; i--) {
            int cur = arr[i];
            //odd jump
            Entry<Integer, Integer> entry;
            entry = treeMap.ceilingEntry(cur);
            if(entry == null) {
                odd[i] = false;
            } else {
                Integer nextIndex = entry.getValue();
                odd[i] = even[nextIndex.intValue()];
                if(odd[i]) {
                    count++;
                }
            }

            //even jump
            entry = treeMap.floorEntry(cur);
            if(entry == null) {
                even[i] = false;
            }
            else {
                Integer nextIndex = entry.getValue();
                even[i] = odd[nextIndex.intValue()];
            }

            treeMap.put(cur, i);
        }

        return count;
    }

    public int oddEvenJumps_drona(int[] arr) {
        int n = arr.length;
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];
        
        odd[n - 1] = true;
        even[n - 1] = true;

        java.util.TreeMap<Integer, Integer> treeMap = new java.util.TreeMap<>();
        treeMap.put(arr[n - 1], n - 1);

        int count = 1;

        for (int i = n - 2; i >= 0; i--) {
            int cur = arr[i];

            java.util.Map.Entry<Integer, Integer> ceil = treeMap.ceilingEntry(cur);
            if (ceil != null) {
                odd[i] = even[ceil.getValue()];
                if (odd[i]) {
                    count++;
                }
            }

            java.util.Map.Entry<Integer, Integer> floor = treeMap.floorEntry(cur);
            if (floor != null) {
                even[i] = odd[floor.getValue()];
            }

            treeMap.put(cur, i);
        }

        return count;
    }
}

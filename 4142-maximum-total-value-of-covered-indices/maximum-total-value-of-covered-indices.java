class Solution {
    public long maxTotal(int[] nums, String s) {

        // Key Observation:

        // Example: "011110"
        //
        // Whenever we find a consecutive block of 1s,
        // suppose the block starts at 'start' and ends at 'end'.
        //
        // Then we can think of the contribution as:
        // sum of all elements in the range [start - 1, end]
        // minus the minimum element from that range.
        //
        // Intuition:
        // Is entire segment me hum sab values le sakte hain
        // except one value, so obviously minimum value ko
        // remove karna is the best choice.

        int n = nums.length;

        long res = 0;

        long min = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {

            if (s.charAt(i) == '1') {

                // Current value can definitely contribute
                // to the answer, so add it.

                res += nums[i];

                // Track minimum value of the current segment
                min = Math.min(min, nums[i]);

            } else {

                // Agar current 0 ke just right side par
                // consecutive block of 1s start ho raha hai,
                // then this 0 also becomes part of the segment.

                if (i + 1 < n && s.charAt(i + 1) == '1') {

                    res += nums[i];

                    min = Math.min(min, nums[i]);

                    // Finalize this segment:
                    // remove the minimum element once.

                    res -= min;
                }

                // Segment khatam ho gaya,
                // reset minimum for the next segment.

                min = Integer.MAX_VALUE;
            }
        }

        return res;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] count = new int[26];

        // Count frequency of each task
        for (char task : tasks) {
            count[task - 'A']++;
        }

        // Find the maximum frequency
        int maxFreq = 0;

        for (int freq : count) {
            maxFreq = Math.max(maxFreq, freq);
        }

        // Number of tasks having maximum frequency
        int maxCount = 0;

        for (int freq : count) {
            if (freq == maxFreq) {
                maxCount++;
            }
        }

        /*
         * Create slots based on the most frequent task.
         *
         * Example:
         * A A A, n = 2
         *
         * A _ _ A _ _ A
         *
         * (maxFreq - 1) groups, each of size (n + 1)
         * plus the last group containing maxCount tasks.
         */
        int result = (maxFreq - 1) * (n + 1) + maxCount;

        // We cannot have fewer intervals than the number of tasks.
        return Math.max(result, tasks.length);
    }
}

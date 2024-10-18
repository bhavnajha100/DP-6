//TC : nlogN - where N can be more than n in  heap
//SC : O(N)
class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] primes = {2, 3, 5};
        PriorityQueue<Long> heap = new PriorityQueue<>();
        HashSet<Long> visited = new HashSet<>();

        heap.add(1L);
        visited.add(1L);

        long curr = 1L;
        for (int i = 0; i < n; i++) {
            curr = heap.poll();
            for (int prime : primes) {
                long new_ugly = curr * prime;
                if (!visited.contains(new_ugly)) {
                    heap.add(new_ugly);
                    visited.add(new_ugly);
                }
            }
        }
        return (int)curr;
    }
}
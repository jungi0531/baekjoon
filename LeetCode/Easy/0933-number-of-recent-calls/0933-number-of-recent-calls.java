class RecentCounter {
    static Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }
    
    public int ping(int t) {
        /**
        들왔을 때 차이가 3000보다 큰 거 제거
        */
        while (!q.isEmpty() && t - q.peek() > 3000) {
            q.remove();
        }
        q.add(t);

        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
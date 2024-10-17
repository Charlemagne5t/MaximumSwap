import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int maximumSwap(int num) {
        char[] s = (num + "").toCharArray();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] a) -> -a[0]).thenComparing((int[] a) -> -a[1]));
        for (int i = 0; i < s.length; i++) {
            pq.offer(new int[]{s[i] - '0', i});
        }
        for (int i = 0; i < s.length; i++) {
            while (!pq.isEmpty() && pq.peek()[1] <= i) {
                pq.poll();
            }
            if (!pq.isEmpty() && (s[i] - '0') < pq.peek()[0]) {
                char t = s[i];
                s[i] = s[pq.peek()[1]];
                s[pq.peek()[1]] = t;
                break;
            }
        }
        return Integer.parseInt(new String(s));

    }
}
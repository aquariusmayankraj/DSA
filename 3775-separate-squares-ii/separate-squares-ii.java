import java.util.*;

class Solution {

    static class Event {
        long y;
        int type; // +1 = add, -1 = remove
        int x1, x2;

        Event(long y, int type, int x1, int x2) {
            this.y = y;
            this.type = type;
            this.x1 = x1;
            this.x2 = x2;
        }
    }

    static class SegmentTree {
        int n;
        long[] xs;
        long[] coveredLen;
        int[] count;

        SegmentTree(long[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            coveredLen = new long[4 * n];
            count = new int[4 * n];
        }

        void update(int node, int l, int r, int ql, int qr, int val) {
            if (ql >= r || qr <= l) return;

            if (ql <= l && r <= qr) {
                count[node] += val;
            } else {
                int mid = (l + r) / 2;
                update(node * 2, l, mid, ql, qr, val);
                update(node * 2 + 1, mid, r, ql, qr, val);
            }

            if (count[node] > 0) {
                coveredLen[node] = xs[r] - xs[l];
            } else {
                if (l + 1 == r) {
                    coveredLen[node] = 0;
                } else {
                    coveredLen[node] = coveredLen[node * 2] + coveredLen[node * 2 + 1];
                }
            }
        }

        void update(int l, int r, int val) {
            update(1, 0, n, l, r, val);
        }

        long query() {
            return coveredLen[1];
        }
    }

    public double separateSquares(int[][] squares) {
        List<Event> events = new ArrayList<>();
        Set<Long> xSet = new HashSet<>();

        for (int[] s : squares) {
            long x = s[0], y = s[1], len = s[2];
            events.add(new Event(y, +1, (int) x, (int) (x + len)));
            events.add(new Event(y + len, -1, (int) x, (int) (x + len)));
            xSet.add(x);
            xSet.add(x + len);
        }

        long[] xs = new long[xSet.size()];
        int idx = 0;
        for (long v : xSet) xs[idx++] = v;
        Arrays.sort(xs);

        Map<Long, Integer> xIndex = new HashMap<>();
        for (int i = 0; i < xs.length; i++) {
            xIndex.put(xs[i], i);
        }

        for (Event e : events) {
            e.x1 = xIndex.get((long) e.x1);
            e.x2 = xIndex.get((long) e.x2);
        }

        events.sort(Comparator.comparingLong(e -> e.y));

        SegmentTree st = new SegmentTree(xs);
        List<double[]> strips = new ArrayList<>();

        long prevY = events.get(0).y;
        long totalArea = 0;

        int i = 0;
        while (i < events.size()) {
            long currY = events.get(i).y;
            long dy = currY - prevY;

            if (dy > 0) {
                long width = st.query();
                if (width > 0) {
                    strips.add(new double[]{prevY, currY, width});
                    totalArea += width * dy;
                }
            }

            while (i < events.size() && events.get(i).y == currY) {
                Event e = events.get(i);
                st.update(e.x1, e.x2, e.type);
                i++;
            }
            prevY = currY;
        }

        double half = totalArea / 2.0;
        double acc = 0;

        for (double[] s : strips) {
            double y1 = s[0], y2 = s[1], w = s[2];
            double area = (y2 - y1) * w;

            if (acc + area >= half) {
                return y1 + (half - acc) / w;
            }
            acc += area;
        }

        return 0.0;
    }
}

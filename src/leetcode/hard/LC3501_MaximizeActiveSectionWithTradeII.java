package leetcode.hard;
import java.util.ArrayList;
import java.util.List;
public class LC3501_MaximizeActiveSectionWithTradeII {
    public static void main(String[] args) {
        String s = "1000100";
        int[][] query = {{1,5}, {0,6},{0,4}};

        System.out.println(maxActiveSectionsAfterTrade(s, query));
        System.out.println(maxActiveSectionsAfterTrade2(s, query));
    }
//  For Small Input
    static  List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries){
        int n = s.length();

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (s.charAt(i) == '1' ? 1 : 0);
        }

        List<Integer> ans = new ArrayList<>();

        for(int[] q : queries){
            int l = q[0];
            int r = q[1];

            String sub = s.substring(l, r + 1);

            int outsideOnes = prefix[l] + (prefix[n] - prefix[r + 1]);

            ans.add(outsideOnes + solve(sub));
        }

        return ans;
    }

    static int solve(String s){
        int count_one = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                count_one++;
            }
        }

        String t = "1" + s + "1";

        int n = t.length();

        List<Character> chars = new ArrayList<>();
        List<Integer> len = new ArrayList<>();

        int i = 0;

        while (i < n) {
            char ch = t.charAt(i);
            int j = i;

            while (j < n && t.charAt(j) == ch) {
                j++;
            }

            chars.add(ch);
            len.add(j - i);

            i = j;
        }

        int maxGain = 0;

        for (i = 1; i < chars.size() - 1; i++) {

            if (chars.get(i) == '1'
                    && chars.get(i - 1) == '0'
                    && chars.get(i + 1) == '0') {

                int gain = len.get(i - 1) + len.get(i + 1);

                maxGain = Math.max(maxGain, gain);
            }
        }
        return count_one + maxGain;
    }

//    For Large Input
    static void buildSegmentTree(int i, int l, int r, int[] segmentTree, int[] arr) {
    if (l == r) {
        segmentTree[i] = arr[l];
        return;
    }

    int mid = l + (r - l) / 2;
    buildSegmentTree(2 * i + 1, l, mid, segmentTree, arr);
    buildSegmentTree(2 * i + 2, mid + 1, r, segmentTree, arr);
    segmentTree[i] = Math.max(segmentTree[2 * i + 1], segmentTree[2 * i + 2]);
}

    static int[] constructST(int[] arr, int n) {
        int[] segmentTree = new int[4 * n];
        buildSegmentTree(0, 0, n - 1, segmentTree, arr);
        return segmentTree;
    }

    static int querySegmentTree(int start, int end, int i, int l, int r, int[] segmentTree) {
        if (l > end || r < start) {
            return Integer.MIN_VALUE;
        }

        if (l >= start && r <= end) {
            return segmentTree[i];
        }

        int mid = l + (r - l) / 2;
        return Math.max(querySegmentTree(start, end, 2 * i + 1, l, mid, segmentTree),
                querySegmentTree(start, end, 2 * i + 2, mid + 1, r, segmentTree));
    }

    static int RMQ(int[] st, int n, int a, int b) {
        return querySegmentTree(a, b, 0, 0, n - 1, st);
    }


    static int lowerBound(int[] arr, int len, int key) {
        int lo = 0, hi = len;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }


    static int upperBound(int[] arr, int len, int key) {
        int lo = 0, hi = len;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= key) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static List<Integer> maxActiveSectionsAfterTrade2(String s, int[][] queries) {
        int n = s.length();

        int activeCount = 0;
        for (int idx = 0; idx < n; idx++) {
            if (s.charAt(idx) == '1') activeCount++;
        }


        int[] blockStart = new int[n];
        int[] blockEnd = new int[n];
        int m = 0;
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == '0') {
                int start = i;
                while (i < n && s.charAt(i) == '0') i++;
                blockStart[m] = start;
                blockEnd[m] = i - 1;
                m++;
            } else {
                i++;
            }
        }


        if (m < 2) {
            List<Integer> res = new ArrayList<>();
            for (int k = 0; k < queries.length; k++) res.add(activeCount);
            return res;
        }

        int[] blockSize = new int[m];
        for (int k = 0; k < m; k++) {
            blockSize[k] = blockEnd[k] - blockStart[k] + 1;
        }

        int N = m - 1;
        int[] pairSum = new int[N];
        for (int k = 0; k < N; k++) {
            pairSum[k] = blockSize[k] + blockSize[k + 1];
        }

        int[] st = constructST(pairSum, N);

        List<Integer> result = new ArrayList<>();
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];


            int low  = lowerBound(blockEnd, m, l);

            int high = upperBound(blockStart, m, r) - 1;

            int maxPairSum = 0;
            if (low < high) {
                int firstLen = blockEnd[low] - Math.max(blockStart[low], l) + 1;
                int lastLen  = Math.min(blockEnd[high], r) - blockStart[high] + 1;

                if (high - low == 1) {
                    maxPairSum = firstLen + lastLen;
                } else {
                    int pair1 = firstLen + blockSize[low + 1];
                    int pair2 = blockSize[high - 1] + lastLen;
                    int rmqMaxPairSum = (low + 1 <= high - 2) ? RMQ(st, N, low + 1, high - 2) : 0;
                    maxPairSum = Math.max(pair1, Math.max(pair2, rmqMaxPairSum));
                }
            }
            result.add(maxPairSum + activeCount);
        }

        return result;
    }
}

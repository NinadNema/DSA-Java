package leetcode.medium;

import java.util.*;

public class LC3568_MinimumMovesToCleanTheClassroom {
    public static void main(String[] args) {
        LC3568_MinimumMovesToCleanTheClassroom lc = new LC3568_MinimumMovesToCleanTheClassroom();

        String[] s = {"S.", "XL"};
        int energy = 2;

        System.out.println(lc.minMoves(s, energy));
    }

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int sr = 0;
        int sc = 0;

        ArrayList<int[]> litter = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (classroom[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                }

                if (classroom[i].charAt(j) == 'L') {
                    litter.add(new int[]{i, j});
                }
            }
        }

        int totalLitter = litter.size();

        if (totalLitter == 0) {
            return 0;
        }

        int allCollected = (1 << totalLitter) - 1;

        int[][] litterIndex = new int[m][n];

        for (int[] row : litterIndex) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < totalLitter; i++) {
            int r = litter.get(i)[0];
            int c = litter.get(i)[1];

            litterIndex[r][c] = i;
        }

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{sr, sc, 0, energy, 0});

        boolean[][][][] visited =
                new boolean[m][n][1 << totalLitter][energy + 1];

        visited[sr][sc][0][energy] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int[] state = queue.poll();

            int r = state[0];
            int c = state[1];
            int mask = state[2];
            int currentEnergy = state[3];
            int moves = state[4];

            if (mask == allCollected) {
                return moves;
            }

            if (currentEnergy == 0) {
                continue;
            }

            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nr >= m ||
                        nc < 0 || nc >= n) {
                    continue;
                }

                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                int newEnergy = currentEnergy - 1;

                int newMask = mask;

                if (classroom[nr].charAt(nc) == 'L') {

                    int index = litterIndex[nr][nc];

                    newMask |= (1 << index);
                }

                if (classroom[nr].charAt(nc) == 'R') {
                    newEnergy = energy;
                }

                if (!visited[nr][nc][newMask][newEnergy]) {

                    visited[nr][nc][newMask][newEnergy] = true;

                    queue.offer(new int[]{
                            nr,
                            nc,
                            newMask,
                            newEnergy,
                            moves + 1
                    });
                }
            }
        }

        return -1;
    }
}

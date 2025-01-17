package DisjointSets;

import java.util.*;

public class FriendRequests {

    static class DSU {
        private int[] parent;
        private int[] rank;

        // Constructor to initialize the DSU structure
        public DSU(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i; // Initially, each node is its own parent
                rank[i] = 1;   // Rank (tree height) starts as 1
            }
        }

        // Find the representative (root) of the set with path compression
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        // Union two sets by rank
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) return false; // They are already in the same set

            // Union by rank
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }

    public static int findGroups(int n, int[][] friendRequests) {
        DSU dsu = new DSU(n);

        for (int[] request : friendRequests) {
            int a = request[0];
            int b = request[1];
            dsu.union(a, b); // Process the friendship requests
        }

        // Count distinct groups by finding unique roots
        Set<Integer> uniqueGroups = new HashSet<>();
        for (int i = 0; i < n; i++) {
            uniqueGroups.add(dsu.find(i));
        }

        return uniqueGroups.size();
    }

    public static void main(String[] args) {
        int n = 7; // Number of people (0 to 6)
        int[][] friendRequests = {
                {0, 1},
                {1, 2},
                {3, 4},
                {4, 5},
                {6, 6}
        };

        int result = findGroups(n, friendRequests);
        System.out.println("Number of groups: " + result);
    }
}

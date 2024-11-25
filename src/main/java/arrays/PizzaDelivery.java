package arrays;

import java.util.*;

public class PizzaDelivery {

    public static void main(String[] args) {
        int[][] orders = {
                {1, 2, 1},
                {1, 0, 2},
                {5, 1, 0}
        };
        int T = 2;
        System.out.println("Minimum car capacity needed: " + minCarCapacity(orders, T));
    }

    public static int minCarCapacity(int[][] orders, int T) {
        int high = calculateTotalCapacity(orders); // total capacity
        int low = minCapacity(orders, high);

        while (low < high) {
            int mid = (low + high) / 2;
            if (canDeliver(orders, mid, T)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low; // Minimum capacity
    }
    private static int calculateTotalCapacity(int[][] orders) {
        int totalCapacity = 0;
        for (int[] order : orders) {
            totalCapacity += order[0] * 1 + order[1] * 2 + order[2] * 3;
        }
        return totalCapacity;
    }

    private static int minCapacity(int[][] orders, int high) {
        int minCapacity = high;
        for (int[] order : orders) {
            int capacity = order[0] * 1 + order[1] * 2 + order[2] * 3;
            if(minCapacity > capacity){
                minCapacity = capacity;
            }
        }
        return minCapacity;
    }

    // Check if a given capacity can deliver all orders within T trips
    private static boolean canDeliver(int[][] orders, int capacity, int T) {
        int trips = 0;
        int currentLoad = 0;

        for (int[] order : orders) {
            int orderCapacity = order[0] * 1 + order[1] * 2 + order[2] * 3; // Calculate capacity for the current order

            if (orderCapacity > capacity) {
                // If a single order exceeds car capacity, it's impossible to deliver
                return false;
            }

            if (currentLoad + orderCapacity > capacity) {
                // Start a new trip if adding current order exceeds capacity
                trips++;
                currentLoad = orderCapacity;
            } else {
                // Otherwise, add order to the current trip
                currentLoad += orderCapacity;
            }
        }

        // Account for the last trip if there's any remaining load
        if (currentLoad > 0) {
            trips++;
        }

        // Check if the number of trips needed is within the allowed limit T
        return trips <= T;
    }
}


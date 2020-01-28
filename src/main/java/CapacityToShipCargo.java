/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 *
 * A conveyor belt has packages that must be shipped from one port to another within D days.
 *
 * The i-th package on the conveyor belt has a weight of weights[i].  Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
 *
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.
 *
 * Solution: Binary search on answer
 *
 * Complexity - Log(N/D) * N
 * Additional space - C
 */

public class CapacityToShipCargo {

    public static int shipWithinDays(int[] weights, int d) {
        if (weights.length == 0) {
            return 0;
        }

        int max = weights[0];
        for (int i = 1; i < weights.length; i++) {
            if (weights[i] > max) {
                max = weights[i];
            }
        }

        int left = max;
        int right = (left * weights.length) / d + 1;

        while (left <= right) {
            System.out.println(left + ":" + right);
            int mid = left + (right - left) / 2;
            if (!isEnoughCapacity(weights, d, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left + (right - left) / 2;
    }

    private static boolean isEnoughCapacity(int[] weights, int d, int capacity) {
        int current = 0;
        for (int i = 0; i < d; i++) {
            int sum = 0;
            while (sum < capacity && current < weights.length) {
                if (sum + weights[current] > capacity) {
                    break;
                }
                sum += weights[current];
                current++;
            }
        }
        return current == weights.length;
    }

}

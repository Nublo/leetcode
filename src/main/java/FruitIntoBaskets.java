import java.util.HashMap;

/**
 * https://leetcode.com/problems/fruit-into-baskets/
 *
 * Sliding window. O(N)
 */
public class FruitIntoBaskets {

    public int totalFruit(int[] tree) {
        if (tree.length < 3) {
            return tree.length;
        }

        int left = 0;
        int right = 1;

        HashMap<Integer, Integer> storage = new HashMap<>();
        putOrIncrease(storage, tree[left]);
        putOrIncrease(storage, tree[right]);

        int max = 2;
        while (left < tree.length && (right + 1) < tree.length) {
            int nextElement = tree[right + 1];
            if (storage.containsKey(nextElement) || storage.size() < 2) {
                putOrIncrease(storage, nextElement);
                right++;
                max = Math.max(max, right - left + 1);
            } else {
                decreaseOrRemove(storage, tree[left]);
                left++;
            }
        }

        return max;
    }

    private void putOrIncrease(HashMap<Integer, Integer> storage, int element) {
        if (storage.containsKey(element)) {
            storage.put(element, storage.get(element) + 1);
        } else {
            storage.put(element, 1);
        }
    }

    private void decreaseOrRemove(HashMap<Integer, Integer> storage, int element) {
        if (storage.get(element) > 0) {
            storage.put(element, storage.get(element) - 1);
        } else {
            storage.remove(element);
        }
    }

}

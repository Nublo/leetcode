import java.util.HashSet

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Solution:
 * Add char to tempAnswer if it is not in set, otherwise, start cutting first symbols from tempAnswer
 * O(N)
 * N - length of string
 */
fun lengthOfLongestSubstring(s: String): Int {
    val set = HashSet<Char>()
    var ans = StringBuilder()
    val cur = StringBuilder()
    for (i in 0 until s.length) {
        if (set.contains(s[i])) {
            if (cur.length > ans.length) {
                ans = StringBuilder(cur)
            }
            while (set.contains(s[i])) {
                set.remove(cur.first())
                cur.deleteCharAt(0)
            }
        }
        set.add(s[i])
        cur.append(s[i])
    }
    if (cur.length > ans.length) {
        ans = StringBuilder(cur)
    }
    return ans.length
}
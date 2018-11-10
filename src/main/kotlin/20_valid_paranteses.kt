import java.util.*

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 *   Open brackets must be closed by the same type of brackets.
 *   Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Solution:
 * Use stack, open brackets - push. Close brakets - check peek.
 *
 * O(N)
 * N - length of input string
 */
fun isValid(s: String): Boolean {
    val st = Stack<Char>()
    for (i in 0 until s.length) {
        if (s[i] == '[' || s[i] == '{' || s[i] == '(') {
            st.push(s[i])
        } else if (s[i] == ']' || s[i] == '}' || s[i] == ')') {
            if (st.empty()) {
                return false
            }
            if (st.peek() == '(' || s[i] != ')') {
                return false
            }
            if (st.peek() == '[' || s[i] != ']') {
                return false
            }
            if (st.peek() == '{' || s[i] != '}') {
                return false
            }
            st.pop()
        }
    }
    return st.empty()
}
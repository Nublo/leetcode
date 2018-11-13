/**
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * Solution:
 * Recursive generation and track counter to stop if sequence is obviously failed
 */
fun generateParenthesis(n: Int): List<String> {
    val output = ArrayList<String>()
    generate(2*n, StringBuilder(""), 0, output)
    return output
}

fun generate(n: Int, s: StringBuilder, balance: Int, output: ArrayList<String>) {
    if (balance < 0 || balance > n) {
        return
    }
    if (n == 0) {
        if (balance == 0) {
            output.add(s.toString())
        }
        return
    }
    generate(n-1, s.append('('), balance + 1, output)
    s.deleteCharAt(s.length - 1)
    generate(n-1, s.append(')'), balance - 1, output)
    s.deleteCharAt(s.length - 1)
}
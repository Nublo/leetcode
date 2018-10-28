/**
 * Given a string s, find the longest palindromic substring in s
 *
 * Solution:
 * f(i,j) means if substring is a palindrome
 * f(i,i) -> true
 * f(i,i+1) -> s[i] == s[i+1]
 * f(i,j) -> f(i+1,j-1) && s[i] == s[j]
 */
fun longestPalindrome(s: String): String {
    val f: Array<BooleanArray> = Array(s.length) {
        BooleanArray(s.length)
    }
    var answer: Pair<Int, String> = Pair(0, "")
    for (j in 0 until s.length) {
        for (i in 0..j) {
            when {
                i == j -> f[i][j] = true
                i + 1 == j -> f[i][j] = s[i] == s[i+1]
                else -> f[i][j] = f[i+1][j-1] && s[i] == s[j]
            }
            if (f[i][j] && j - i + 1 > answer.first) {
                answer = Pair(j - i + 1, s.substring(i, j + 1))
            }
        }
    }
    return answer.second
}
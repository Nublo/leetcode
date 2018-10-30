/**
 * https://leetcode.com/problems/zigzag-conversion/description/
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * Solution:
 * Just emulating it. Tracking rows in list of StringBuilders
 * O(N)
 * N - length of string
*/

fun convert(s: String, numRows: Int): String {
    if (numRows == 1) return s

    val matrix = Array(numRows) {
        StringBuilder()
    }

    var pos = 0
    var i = 0
    var j = 0
    var down = true
    while (pos < s.length) {
        matrix[i].append(s[pos])
        if (down) {
            i++
        } else {
            i--
            j++
        }
        if (i == numRows -1) {
            down = false
        }
        if (i == 0) {
            down = true
        }
        pos++
    }

    val result = StringBuilder()
    for (cur in matrix) {
        result.append(cur)
    }
    return result.toString()
}
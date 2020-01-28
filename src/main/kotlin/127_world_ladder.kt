import java.util.*

/**
 * https://leetcode.com/problems/word-ladder/
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 *
 * Solution: Build graph and use BFS to find a path
 *
 * Complexity - O(N + V) N - word count, V - amount of vertexes
 * Additional space - V + N
 */

fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
    if (!wordList.contains(endWord)) {
        return 0
    }

    val elements = if (wordList.contains(beginWord)) {
        wordList
    } else {
        mutableListOf<String>().apply {
            add(beginWord)
            addAll(wordList)
        }
    }

    val positions = mutableMapOf<String, Int>() // word -> index
    elements.forEachIndexed { index, elem -> positions[elem] = index }

    val neighbors = List(elements.size) {
        mutableListOf<Int>()
    }

    for (i in 0 until elements.size) {
        for (j in i+1 until elements.size) {
            if (isConnected(elements[i], elements[j])) {
                neighbors[i].add(j)
                neighbors[j].add(i)
            }
        }
    }

    val answer = mutableMapOf<String, Int>() // word -> distance

    val queue: Queue<String> = ArrayDeque<String>()
    queue.add(beginWord)
    answer[beginWord] = 1

    while (queue.isNotEmpty()) {
        val current = queue.poll()

        val neighbor = neighbors[positions[current]!!]

        for (i in 0 until neighbor.size) {
            if (answer[elements[neighbor[i]]] == null) {
                queue.add(elements[neighbor[i]])
                answer[elements[neighbor[i]]] = answer[current]!! + 1
            }
        }

        if (answer.containsKey(endWord)) {
            return answer[endWord]!!
        }
    }

    return 0
}

fun isConnected(a: String, b: String): Boolean {
    if (a.length != b.length)
        return false
    var diff = false
    for (i in 0 until a.length) {
        if (a[i] != b[i]) {
            if (diff) {
                return false
            }
            diff = true
        }
    }
    return true
}

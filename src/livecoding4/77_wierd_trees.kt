package livecoding4

import java.util.ArrayDeque

class TreeNodeChar(
    val letter: Char,
    var left: TreeNodeChar? = null,
    var right: TreeNodeChar? = null
)

fun findEquivalent (root: TreeNodeChar?): ArrayDeque<TreeNodeChar> {
    data class Info(
        val letters: Set<Char>,
        val subtreeSize: Int
    )

    data class BestTwo(
        var firstNode: TreeNodeChar? = null,
        var firstSize: Int = -1,
        var secondNode: TreeNodeChar? = null,
        var secondSize: Int = -1
    )

    val groups = HashMap<String, BestTwo>()

    fun makeKey(letters: Set<Char>): String {
        return letters.sorted().joinToString("")
    }

    fun dfs(node: TreeNodeChar?): Info? {
        if (node == null) {
            return null
        }

        val letters = HashSet<Char>()
        letters.add(node.letter)

        var subtreeSize = 1

        val leftInfo = dfs(node.left)
        if (leftInfo != null) {
            letters.addAll(leftInfo.letters)
            subtreeSize += leftInfo.subtreeSize
        }

        val rightInfo = dfs(node.right)
        if (rightInfo != null) {
            letters.addAll(rightInfo.letters)
            subtreeSize += rightInfo.subtreeSize
        }
        val key = makeKey(letters)
        val best = groups.getOrPut(key) { BestTwo() }

        // Размер поддерева без самой вершины:
        val descendantsCount = subtreeSize - 1

        if (descendantsCount > best.firstSize) {
            best.secondNode = best.firstNode
            best.secondSize = best.firstSize

            best.firstNode = node
            best.firstSize = descendantsCount
        } else if (descendantsCount > best.secondSize) {
            best.secondNode = node
            best.secondSize = descendantsCount
        }

        return Info(letters, subtreeSize)
    }

    dfs(root)

    var answerFirst: TreeNodeChar? = null
    var answerSecond: TreeNodeChar? = null
    var bestSum = -1

    for (pair in groups.values) {
        if (pair.firstNode != null && pair.secondNode != null) {
            val currentSum = pair.firstSize + pair.secondSize

            if (currentSum > bestSum) {
                bestSum = currentSum
                answerFirst = pair.firstNode
                answerSecond = pair.secondNode
            }
        }
    }

    val result = ArrayDeque<TreeNodeChar>()

    if (answerFirst != null && answerSecond != null) {
        result.addLast(answerFirst)
        result.addLast(answerSecond)
    }

    return result
}

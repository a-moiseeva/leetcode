package livecoding4

class TreeNodeCh(
    val letter: Char,
    var left: TreeNodeCh? = null,
    var right: TreeNodeCh? = null
)

fun findEquivalentPair(root: TreeNodeCh?): Pair<TreeNodeCh, TreeNodeCh>? {
    if (root == null) {
        return null
    }

    // Для каждого набора букв храним первую встреченную вершину
    val firstByKey = HashMap<String, TreeNodeCh>()

    var answer: Pair<TreeNodeCh, TreeNodeCh>? = null


    fun dfs(node: TreeNodeCh): Set<Char> {
        val letters = HashSet<Char>()

        // Буква текущей вершины входит в её поддерево
        letters.add(node.letter)

        if (node.left != null) {
            letters.addAll(dfs(node.left!!))
        }

        if (node.right != null) {
            letters.addAll(dfs(node.right!!))
        }

        val key = letters.sorted().joinToString("")

        val previousNode = firstByKey[key]

        if (previousNode != null && answer == null) {
            answer = previousNode to node
        } else if (previousNode == null) {
            firstByKey[key] = node
        }

        return letters
    }

    dfs(root)

    return answer
}

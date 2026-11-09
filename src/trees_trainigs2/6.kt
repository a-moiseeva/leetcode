package trees_trainigs2


class `5`
class Nodde(val value: Int) {
    var left: Nodde? = null
    var right: Nodde? = null
}

private class BinSer() {
    var root: Nodde? = null
    fun insert(value: Int) {
        root = insertRec(root, value)
    }

    private fun insertRec(node: Nodde?, value: Int): Nodde {
        if (node == null) return Nodde(value)
        if (node.value < value) node.right = insertRec(node.right, value)
        if (node.value > value) node.left = insertRec(node.left, value)
        return node
    }

    fun getHeight(): Int {
        return getHeightRec(root)
    }

    private fun getHeightRec(node: Nodde?): Int {
        if (node == null) return 0
        return (Math.max(getHeightRec(node.left), getHeightRec(node.right)) + 1)
    }

    fun obhodTwoKids() {
        obhodTwoKidsRec(root!!)
    }

    private fun obhodTwoKidsRec(node: Nodde) {
        if (node.right == null && node.left == null) {
            return
        }
        if (node.left != null) {
            obhodTwoKidsRec(node.left!!)
        }
        if(node.right != null && node.left != null){
            println(node.value)
        }
        if (node.right != null) {
            obhodTwoKidsRec(node.right!!)
        }

    }
}

fun main() {
    val bs = BinSer()
    val s = readln().split(" ").map { it.toInt() }
    for (i in s) {
        if (i != 0) bs.insert(i)
    }
    bs.obhodTwoKids()
}
package livecoding3

class Node(
    var value: Int
) {
    var left: Node? = null
    var right: Node? = null
    var parent: Node? = null
}

fun lowestCommonAncestor(p: Node?, q: Node?): Node? {
    var first = p
    var second = q

    while(first!= second){
        first = if( first==null) q else first.parent
        second = if(second==null) p else second.parent
    }
    return first
}

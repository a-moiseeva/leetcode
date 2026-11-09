package livecoding2

/*
class NestedIterator(nestedList: List<NestedInteger>) {
    val nums =  mutableListOf<Int>()
    var current =0
    var n=0
    init{
        flatten(nestedList)
        n=nums.size
    }
    fun flatten(l: List<NestedInteger>){
        for (i in l){
            if (i.isInteger()) nums.add(i.getInteger())
            else flatten(i.getList())
        }
    }
    fun next(): Int {
        hasNext()
        return nums[current].also{  current++}


    }

    fun hasNext(): Boolean {
        if(current<n)return true
        return false

    }
}*//*
class NestedIterator(nestedList: List<NestedInteger>) {
    val stack=ArrayDeque<NestedInteger>()
    init{
        for (i in nestedList.indices.reversed()){
            stack.addLast(nestedList[i])
        }
    }

    fun next(): Int {
        hasNext()
        return stack.removeLast().getInteger()!!
    }

    fun hasNext(): Boolean {

        while(stack.isNotEmpty()){
            if (stack.last().isInteger()) return true
            val x = stack.removeLast().getList()
            for (i in x.indices.reversed()){
                stack.addLast(x[i])
            }

        }
        return false
    }
}*/

fun main(){
    val stack = ArrayDeque<Int>()
    stack.addFirst(1)
    println(stack.joinToString(" "))
    stack.addFirst(3)
    println(stack.joinToString(" "))
    stack.addLast(4)
    println(stack.joinToString(" "))
    stack.add(5)
    println(stack.joinToString(" "))
}
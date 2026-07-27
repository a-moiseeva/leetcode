package `2_base`

class Stack<T>(){
    val stack = mutableListOf<T>()
    var size =0
    override fun toString(): String {
        return stack.toString()
    }
    fun push(value:T){
        stack.add(value)
        size++
    }
    fun pop():T{
        if(size==0) return -1 as T
        val value=stack[size-1]
        stack.removeAt(stack.size-1)
        size--
        return value
    }
    fun peek():T{
        if(size==0) return -1 as T
        return stack[size-1]
    }
    fun isEmpty():Boolean{
        return size==0
    }

}
fun main(){
    val n = readln().toInt()
    val stack = Stack<Int>()
    repeat(n){
        val s = readln().split(" ").map{it.toInt()}
        if (s[0]==1){
            stack.push(s[1])
        }
        else{
            stack.pop()
        }
        println(stack.peek())
    }
}
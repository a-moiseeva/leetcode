package `2_base`


class Stack2<T>(){
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
    fun showFirst():T{
        return stack[0]
    }
    fun removeFirst():T{
        size--
        return stack.removeAt(0)

    }

}

fun main(){
    val (n,k) = readln().split(" ").map{it.toInt()}
/*    val n = readln().toInt()
    val k=readln().toInt()*/
    val stack = Stack2<Int>()
    val s = readln().split(" ").map { it.toInt() }
    val answers= mutableListOf<Int>()

    for (i in 0..n-1){
        if (i >= k && s[i - k] == stack.showFirst()) {
            stack.removeFirst()
        }
        val value = s[i]
        while(!stack.isEmpty() && value<stack.peek()){
            stack.pop()
        }
        stack.push(value)
        if (i>=k-1){
            answers.add(stack.showFirst())
        }

    }
    println(answers.joinToString("\n"))
}
/*
10
3
2 3 2 1 4 5 3 4 4 4
 */
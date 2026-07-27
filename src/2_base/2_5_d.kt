package `2_base`


class Stack3<T>(){
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
    val m = mapOf<Char,Char>('{' to '}', Pair('[',']'), '(' to ')')
    val s = readln()
    val stack = Stack3<Char>()
    for (i in 0..s.length-1){
        if (!stack.isEmpty()&&m[stack.peek()]==s[i]){
                stack.pop()
        }else{
            stack.push(s[i])
        }
    }
    if(stack.isEmpty()){
        println("YES")
        return
    }
    println(   "NO")

}